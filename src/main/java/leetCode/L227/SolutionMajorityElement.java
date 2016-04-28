package leetCode.L227;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wq on 16-2-26.
 */
public class SolutionMajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i :nums){
            if(hashMap.get(i) ==null){
                hashMap.put(i,1);
            }else{
                hashMap.put(i,hashMap.get(i)+1);
            }
        }
        int majEle = nums.length/2;
        int ele = 0;
        for(Map.Entry entry : hashMap.entrySet()){
            if((int)entry.getValue() > majEle){
                ele = (int)entry.getKey();
            }
        }
        return ele;



//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        int candidate = 0;
//        int count = 0;
//        for (int num : nums) {
//            if (count == 0) {
//                candidate = num;
//                count++;
//            } else if (candidate == num) {
//                count++;
//            } else {
//                count--;
//            }
//        }
//        return candidate;
    }
}
