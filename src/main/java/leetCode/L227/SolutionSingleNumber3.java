package leetCode.L227;

import java.util.HashSet;

/**
 * Created by wq on 16-2-26.
 */
public class SolutionSingleNumber3 {
    public static int[] singleNumber(int[] nums) {
//        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
//        for(int i : nums){
//            if(hashMap.get(i) == null){
//                hashMap.put(i,1);
//            }else{
//                int c = hashMap.get(i);
//                hashMap.put(i,++c);
//            }
//        }
////        ArrayList<Integer> arrayList = new ArrayList<>();
////        int num = 0 ;
//        Stack<Integer> stack = new Stack<Integer>();
//        for(Map.Entry entry : hashMap.entrySet()){
//            if( (Integer)entry.getValue() == 1 ){
//                stack.push((Integer) entry.getKey());
//            }
//        }
//        int [] ss = new int[stack.size()];
//        int i = 0 ;
//        while(stack.iterator().hasNext()){
//            ss[i++] = stack.pop();
//        }
//        return ss;

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i :nums){
            if(hashSet.contains(i)){
                hashSet.remove(i);
            }else{
                hashSet.add(i);
            }
        }
        Object [] obj = hashSet.toArray();
        int [] array = new int[hashSet.size()];
        for(int i = 0 ; i<hashSet.size() ; i++){
            array[i] = (int)obj[i];
        }
        return array;

    }



    public static void main(String args[]){
        int a[] = {2,3,1,2,6,4,6};
        int [] bb = singleNumber(a);
        for(int s : bb){
            System.out.print(s);
        }
    }
}
