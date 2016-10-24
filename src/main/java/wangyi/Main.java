package wangyi;

import java.util.Scanner;

/**
 * Created by wq on 16-8-17.
 */
public class Main {
    final int a = 0 ;

    public static void main(String args[]){
        Scanner cin =  new Scanner(System.in);

        while(cin.hasNext()){
//            int a = cin.nextInt();
            int a = Integer.valueOf(cin.nextLine());
            int [] arr= new int[a];
            for(int i = 0 ; i<a ; i++){
                arr[i] = Integer.parseInt(cin.nextLine());
            }
            for(int i = 0 ; i<arr.length ; i++){
                getReal(arr[i]);
            }
        }
    }

    public static void getReal(int len){
        System.out.println(len);
    }

    public static void getReal1(int len){
        int [] arr = new int[len];
        int lena = 1;
        int arrIndex = 1;
        while(lena<=len){
            while(arr[arrIndex] !=0){
                arrIndex++;
                arrIndex%=len;
            }
            arr[arrIndex] = lena++;
            arrIndex++;
            arrIndex%=arrIndex;
            while(arr[arrIndex]!=0){
                arrIndex++;
                arrIndex%=len;
            }
        }
        for(int i = 0 ; i<arr.length-1 ; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.print(arr[arr.length-1]);
    }
}
