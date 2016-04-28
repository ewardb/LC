package leetCode.L228;

/**
 * Created by wq on 16-2-26.
 */
public class SoltionProduceExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
//        int length = nums.length;
//        int c = 0 ;
//        for(int i : nums){
//            if(i == 0){
//                c++;
//            }
//        }
//        if(c>1){
//            return new int[length];
//        }else if(c ==1){
//            int index = 0 ;
//            long lo = 1;
//            for (int i = 0; i < nums.length; i++) {
//                if(nums[i]==0){
//                    index = i ;
//                    continue;
//                }else{
//                    lo *= nums[i];
//                }
//            }
//            nums = new int[length];
//            nums[index] =(int) lo ;
//            return nums;
//        }else{
//            long lo = 1 ;
//            for(int i : nums){
//                lo*=i;
//            }
//            for(int i = 0 ; i<nums.length ; i++){
//                nums[i] = (int)lo/nums[i] ;
//            }
//            return nums;
//        }
        // i do not know !!!!!!!!!!!!!!!!!!!!
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String args[]){
        int a[] = {1,2,3,4};
        int [] bb = productExceptSelf(a);
        for(int s : bb){
            System.out.print(s);
        }
    }
}
