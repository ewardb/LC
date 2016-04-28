package leetCode;

/**
 * Created by wq on 16-3-8.
 */
public class Th {
    public static void main(String args[]){
        double profit = 0 ;
        double money = 1000 ;
        double sum = 0 ;
        int i =1 ;
        while(sum < 10000000){
            profit = money * 0.18 /12 ;
            money +=(1000+ profit) ;
            sum = money ;
            i++;
        }
        System.out.println("每月1000  本经共用" + i*1000 + "需要" +i/12 +"年"  );
//        System.out.println(i/12);
//        System.out.println(i*1000);

        profit = 0 ;
        money = 2000 ;
        sum = 0 ;
        i =1 ;
        while(sum < 10000000){
            profit = money * 0.18 /12 ;
            money +=(2000+ profit) ;
            sum = money ;
            i++;
        }
        System.out.println("每月2000  本经共用" + i*2000 + "需要" +i/12 +"年"  );
//        System.out.println(i*1000);
//        System.out.println(i/12);





        profit = 0 ;
        money = 3000 ;
        sum = 0 ;
        i =1 ;
        while(sum < 10000000){
            profit = money * 0.18 /12 ;
            money +=(3000+ profit) ;
            sum = money ;
            i++;
        }
        System.out.println("每月3000  本经共用" + i*3000 + "需要"+ i/12 +"年"  );
//        System.out.println(i*1000);
//        System.out.println(i/12);



        profit = 0 ;
        money = 4000 ;
        sum = 0 ;
        i =1 ;
        while(sum < 10000000){
            profit = money * 0.18 /12 ;
            money +=(4000+ profit) ;
            sum = money ;
            i++;
        }
        System.out.println("每月4000  本经共用" + i*4000 + "需要" +i/12 +"年"  );
//        System.out.println(i*1000);
//        System.out.println(i/12);
    }
}
