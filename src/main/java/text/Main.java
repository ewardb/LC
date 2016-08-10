package text;

import java.io.FileWriter;
import java.util.*;

interface A {
    default void fun(){

    }
}




/**
 * Created by wq on 16-8-2.
 */
public class Main {
    public static void main(String args[]) throws Exception{
        FileWriter fw = new FileWriter("/home/wq/aaaaaaha.txt", true);

        fw.write("h442");
        fw.write("\t\n");
        fw.write("wor66");
        fw.write("\n");
        fw.flush();
        fw.close();

//        Scanner sc = new Scanner(System.in);
//        Set<String> set = new HashSet<>();
//        while(sc.hasNext()){
//
//            do{
//                String str = sc.nextLine();
//                if(str == null || str.length() ==0) break;
//                String [] strs = str.split(" ");
//                for(int i = 0 ; i<strs.length ; i++){
//                    set.add(strs[i]);
//                }
//            }while(sc.hasNextLine());
//
//            int index = 0 ;
//            Iterator<String> it =  set.iterator();
//            while(it.hasNext()){
//                it.next();
//                index++;
//            }
//            System.out.println(index);
//        }



//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int arrs [][] = new int[n][m];
//
//            int [] arr = new int[n*m];
//
//            for(int i = 0 ; i< n ; i++){
//                for(int j = 0 ; j<m ;j++){
//                    arrs[i][j] = sc.nextInt();
//                }
//            }
//            int niu = 0 ;
//            int index = 0 ;
//
//            for(int i = 0 ; i<n ; i++){
//                for(int j = 0 ; j<m ;j++){
//                    arr[index++] = arrs[i][j];
//                }
//            }
//
//            Arrays.sort(arr);
//            System.out.println(arr[n-15]);
//
//
//
//        }

















    }
}
