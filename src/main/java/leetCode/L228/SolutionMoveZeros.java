package leetCode.L228;

/**
 * Created by wq on 16-2-25.
 */
public class SolutionMoveZeros {
    public static void moveZeroes(int[] nums) {
//        int zeroNum = 0;
//        for(int i : nums){
//            if(i==0){
//                zeroNum++;
//            }
//        }
//        for(int i = 0 ; i<nums.length ; i++){
//            if(nums[i]==0){
//                int tail = 0 ;
//                for(int j = i+1 ; j<nums.length -tail ; j++){
//                    nums[j-1] = nums[j];
//                }
//                nums[nums.length -tail-1] = 0;
//                tail++;
//            }
//        }
//
//        for(int i = 0 ; i<nums.length - zeroNum ; i++){
//            if(nums[i] == 0 ){
//                moveZeroes(nums);
//            }
//        }


        int zeroNum = 0 ;
        for(int i : nums ){
            if(i ==0 ){
                zeroNum ++;
            }
        }

        if(zeroNum == 0 || zeroNum ==nums.length){
            return ;
        }
        int m = 0 ;
        for(int i = 0 ; i<nums.length ;i++){
            if(nums[i] !=0 ){
                nums[m++] = nums[i];
            }
        }

        for(int i = nums.length - zeroNum ; i<nums.length ; i++){
            nums[i] =0 ;
        }






    }

    public static void main(String args[]){
        int [] a = {0,0,1};
        moveZeroes(a);
        for(int i : a ){
            System.out.print(i);
        }
    }
}
