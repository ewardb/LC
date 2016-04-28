package leetCode.L229;

/**
 * Created by wq on 16-2-29.
 */
public class SolutionMissNumber {
    public int missingNumber(int[] nums) {
//        Stack<Integer> s = new Stack<>();
//        if(nums.length !=1){
//            for(int i=0 ,j=i+1; i<nums.length;i++,j++){
//                if(nums[j]-nums[i] !=1){
//                    s.push(j);
//                    break;
//                }
//            }
//            return s.pop();
//        }else{
//            return 0;
//        }


        int n = nums.length;
        int total = n*(n+1)/2;
        int sum = 0 ;
        for(int i :nums){
            sum +=i;
        }
        return total-sum;
    }
}
