package longestConsecutive;

import java.util.HashMap;

/**
 * Created by wq on 16-4-28.
 */
public class SoluLongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        if(null == nums || nums.length == 0){
            return 0;
        }
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i],false);
        }
        for(int i = 0; i<nums.length;i++){
            int v=nums[i];
            map.get(nums[i]);
        }
        return 0;
    }
}
