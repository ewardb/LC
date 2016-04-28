package leetCode.L229;

/**
 * Created by wq on 16-2-26.
 */
public class SolutionBulbSwitcher {




    //Time limit Exceeded
    public static boolean swi(boolean b){
        if(b==true){
            return false;
        }else{
            return true;
        }
    }
    public static int bulbSwitch(int n) {
        if(n==0) return 0;
        int num = 0 ;
        boolean [] b = new boolean[n];
        int round = n/2;
        for(int i = 1 ; i<=round ;i++){
            for(int j= 1 ; j<=n ; j++){
                if((j)%i==0){
                    b[j-1] = swi(b[j-1]);
                }
            }
        }
        for(int i=round+1 ; i<=n ;i++){

                b[i-1] = swi(b[i-1]);

        }
        int c = 0 ;
        for(int i = 0 ; i<n ;i++){
            if(b[i]==true){
                System.out.println(i+1);
                c++;
            }
        }
        return c ;
    }

    public static void main(String args[]){
        bulbSwitch(12);
        System.out.print((byte)(8));
//        System.out.println((int)3.14);
//        System.out.println((int)3.54);
//        System.out.println((int)3.5);

    }
}

//      单数                       双数
//      n/2                       n/2
// 0 1 2 3 4 5 6             0 1 2 3 4 5 6 7
// 0 0 0 0 0 0 0             0 0 0 0 0 0 0 0
