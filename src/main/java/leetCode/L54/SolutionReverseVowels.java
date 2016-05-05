package leetCode.L54;

/**
 * Created by wq on 16-5-4.
 */
public class SolutionReverseVowels {
    public static String reverseVowels(String s) {
//        if(s.length() == 0 || s==null){
//            return s;
//        }
//
//        String t = s;
//        char [] chars =  t.toCharArray();
//        boolean b = false;
//        int vowNum= 0;
//        char vowCh =chars[0];
//        for(int i=0 ; i<chars.length ; i++){
//            if(isVowel(chars[i])){
//                vowNum = i;
//                vowCh = chars[i];
//                b =true;
//                break;
//            }
//        }
//        if(b){
//            for(int i = vowNum+1 ; i<chars.length ;i++){
//                if(isVowel(chars[i])){
//                    char temp = chars[i];
//                    chars[i] = chars[vowNum];
//                    chars[vowNum] = temp;
//                    vowNum = i;
//                    vowCh = chars[i];
//                }
//            }
//        }
//        return  new String(chars);

        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }

            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }


    public static boolean isVowel(char c){
        return c=='a' || c=='e' ||c=='i' ||c=='o' ||c=='u' ||c=='A'||c=='E'||c=='I'||c=='O' ||c=='U';
    }

    public static void main(String args[]){
        System.out.println(reverseVowels("cace car"));
    }

}
