package leetCode.L31;

/**
 * Created by wq on 16-3-1.
 */
public class SolutionPow {
    public double myPow(double x, int n) {
        if(x==0) return 0 ;
        if(n==0) return 1;
        int a = n < 0 ? -1 : 1;
        n = Math.abs(n);
        double result = myPow(x,n/2);
        result *= result;
        if(n%2!=0){
            result *=x ;
        }
        return a<0 ? 1/result : result;
    }
}

// 这种做法   时间太长！！！！！   可以用二分发！！！！！！！！！！
//double soltion = 1.0;
//        if(x==0) return 0.0;
//        if(n==0) return 1.0;
//        if(n>0){
//            for(int i =0 ; i<n ;i++ ){
//                soltion *= x;
//            }
//        }else{
//            n = -n;
//            for(int i =0 ; i<n ;i++ ){
//                soltion *= x;
//            }
//            soltion = 1.0/soltion;
//        }
//        return soltion;