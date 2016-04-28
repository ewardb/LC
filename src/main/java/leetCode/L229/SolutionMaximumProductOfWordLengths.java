package leetCode.L229;

/**
 * Created by wq on 16-2-29.    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class SolutionMaximumProductOfWordLengths {
    public static int maxProduct(String[] words) {
        int [] mask = new int[words.length];
        for(int i = 0 ; i<words.length ; i++){                  //   gaogaogaogaogao
            for(int j= 0 ; j <words[i].length() ; j++){
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0 ;
        for(int i= 0 ; i<words.length; i++){
            for(int j =i+1 ; j<words.length ; j++){
                if((mask[i] & mask[j]) == 0){
                    max = Math.max(words[i].length() * words[j].length() ,max );
                }
            }
        }

        return max ;
    }

        public static void main(String args[]){
//            String s = "abcv";
//            System.out.println("abcsssss".contains("abc"));
//            System.out.println('c'-'a');
            String [] s = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
            maxProduct(s);
        }




//    int[] mask = new int[words.length];
//    for(int i = 0; i < words.length; i++) {
//        for(int j = 0; j < words[i].length(); j++) {
//            mask[i] |= 1 << (words[i].charAt(j) - 'a');
//        }
//    }
//    int max = 0;
//    for(int i = 0; i < words.length; i++) {
//        for(int j = i + 1; j < words.length; j++) {
//            if((mask[i] & mask[j]) == 0) {
//                max = Math.max(words[i].length() * words[j].length(), max);
//            }
//        }
//    }
//    return max;
    }
//}
