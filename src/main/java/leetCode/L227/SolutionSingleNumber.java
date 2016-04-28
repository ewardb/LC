package leetCode.L227;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by wq on 16-1-25.
 */
public class SolutionSingleNumber {
    public static int main(int [] nums){
        HashMap hashMap = new HashMap<Integer,Integer>();
        int lon = nums.length;
        System.out.println(hashMap);
        for(int i = 0 ; i<lon ; i++){
            int in = hashMap.containsKey(nums[i]) ? (Integer)hashMap.get(nums[i]) : 0 ;
            int val = in +1;
            hashMap.put(nums[i],val);
        }
        Iterator iter = hashMap.entrySet().iterator();
        int returnVal = 0;
        while(iter.hasNext()){
            Map.Entry map = (Map.Entry)iter.next();
            if((Integer)map.getValue()==1){
                returnVal = (Integer)map.getKey();
            }
        }
        return returnVal;
    }
}


//public int findNumber(int [] nums){
//    int result = 0 ;
//    for(int i : nums){
//        result ^= i;
//    }
//    return result;
//
//}
