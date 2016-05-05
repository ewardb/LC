package leetCode.L227;

/**
 * Created by wq on 16-1-26.
 */
public class SolutionAddDigits {
    public static int addDigits(int num) {
        int result = 0;
        while(num > 0 ){
            int yu = num % 10;
            num  = num / 10;
            result += yu ;
        }
        if(result>=10){
            result = addDigits(result);
        }
        return result;

//        if(result>=10){
//            addDigits(result);
//        }else{
//            return result;
//        }
//        addDigits(result);
//        return result;
    }

    public static void main(String [] args){
        System.out.println(addDigits(19));
    }
}
