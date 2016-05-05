package leetCode.L428;

/**
 * Created by wq on 16-4-28.
 */
public class SolutionReverseString {
//    public static String reverseString(String s) {   //34ms
//        if(s ==null){
//            return "";
//        }
//        String xx[] = s.split("");
//        for(int i = 0,j=xx.length -1; i<xx.length/2 ;i++,j--){
//            String temp = xx[i];
//            xx[i] = xx[j];
//            xx[j] = temp;
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i<xx.length ; i++){
//            sb.append(xx[i]);
//        }
//        return sb.toString();
//    }


    public static String reverseString(String s) {  //  6ms
        if(s ==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1 ; i>=0 ; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String s = "abcde";
        System.out.println(reverseString(s));
    }


}
