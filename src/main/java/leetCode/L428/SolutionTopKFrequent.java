package leetCode.L428;

import java.util.*;

/**
 * Created by wq on 16-5-3.
 */
public class SolutionTopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> [] list = new List[nums.length+1];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i:nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }

        for(int key : hashMap.keySet()){
            int hz = hashMap.get(key);
            if(list[hz] == null){
                list[hz] = new ArrayList<>();
            }
            list[hz].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for(int pos = list.length-1 ; pos>=0 && res.size()<k;pos--){
            if(list[pos] !=null){
                res.addAll(list[pos]);
            }

        }

         for(int i=0 ;i<k;i++){
             System.out.println(res.get(i));
         }

        return res;

//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        for(int ele:nums){
//            hashMap.put(ele,hashMap.getOrDefault(ele,0) +1);
//        }
//        List<Integer> list = new ArrayList<>();
//        HashMap<Integer,ArrayList<Integer>> reverMap = new HashMap<>();
//        Set<Integer> treeSet = new TreeSet<>();
//        for(int key :hashMap.keySet()){
//            int value = hashMap.get(key);
//            treeSet.add(value);
//            if(reverMap.containsKey(value)){
//                ArrayList d = reverMap.get(value);
//                d.add(key);
//                reverMap.put(value,d);
//            }else{
//                ArrayList d= new ArrayList<>();
//                d.add(key);
//                reverMap.put(value,d);
//            }
//        }
//        List<Integer> temp = new ArrayList<>();
//        Iterator<Integer> iter = treeSet.iterator();
//
//        while(iter.hasNext()){
//            int o = iter.next();
//            ArrayList r = reverMap.get(o);
//            temp.addAll(r);
//        }
//        List<Integer> res = new ArrayList<>();
//        for(int i = temp.size()-1,j=0 ; j<k;j++,i--){
//            res.add(temp.get(i));
//        }
//        for(int i=0 ;i<res.size();i++){
//            System.out.println(res.get(i));
//        }
//        return res;

    }


    public static void main(String args[]){
        int [] a  = {1,1,1,2,2,2,2,2,3,3,3,3,4,5,6,7,5,4,3};
        topKFrequent(a,3);
    }
}
