package leetCode.L428;

/**
 * Created by wq on 16-4-28.
 */
public class SoltionCountBits {
    public int[] countBits(int num) {
        int [] result = new int[num + 1];
        result[0] = 0;
        for(int i=1 ; i<=num ; i++ ){
            result[i] = result[i&(i-1)] +1 ;
        }

        return result;
    }


}
