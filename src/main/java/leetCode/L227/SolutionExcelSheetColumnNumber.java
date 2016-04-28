package leetCode.L227;

/**
 * Created by wq on 16-2-26.
 */

//注意byte数组 与  char 数组的区别

public class SolutionExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
//        char[] strArray = s.toCharArray();
//        byte [] bytes = s.getBytes();
//        int sum = 0;
//        for(int i = bytes.length -1 ,j=0; i>=0 ;i--,j++){
//            sum += Math.pow(26,i) * (bytes[j] - 64);
//        }
//        System.out.println(strArray[0]);
//        System.out.println(bytes[0]-64);
//        System.out.println(sum);
//        return sum ;

        int number=0;
        for(int i=0;i<s.length();i++)
        {
            number=26*number+(s.charAt(i)-'A')+1;
        }
        System.out.println(number);
        return number;


    }

    public static void main(String args[]){
        titleToNumber("ABC");
        System.out.println(3 + 26*2 + 26*26);
    }
}
