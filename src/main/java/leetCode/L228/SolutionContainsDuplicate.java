package leetCode.L228;

/**
 * Created by wq on 16-2-26.
 */
public class SolutionContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for(int i : nums){
//            if(hashSet.contains(i)){
//                return true ;
//            }
//            hashSet.add(i);
//        }
//        return false ;
//


        if (nums == null) {
            return false;
        }
        int[] hashTable = new int[nums.length];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            int h = nums[i] % nums.length;
            h = h >= 0 ? h : h + nums.length;
            while (hashTable[h] != Integer.MIN_VALUE) {
                if (nums[i] == hashTable[h]) {
                    return true;
                } else {
                    h = (h + 1) % nums.length;
                }
            }
            hashTable[h] = nums[i];
        }
        return false;
    }
    public static void main(String args[]){
        int[] aa = {1,2,7,4,1,6};
        containsDuplicate(aa);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
