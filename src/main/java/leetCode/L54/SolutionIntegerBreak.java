package leetCode.L54;

/**
 *
 * Created by wq on 16-5-4.
 */
//Given a positive integer n, break it into the sum of at least
// two positive integers and maximize the product of those integers. Return the maximum product you can get.
//For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
public class SolutionIntegerBreak {
    public static int integerBreak(int n){
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int max = 1;
        while(n>4){
            max*=3;
            n-=3;
        }
        return max*n;
    }

    public static void main(String args[]){
        System.out.print(integerBreak(7));
    }
}
