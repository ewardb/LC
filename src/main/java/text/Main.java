package text;

import java.util.*;

interface B {
    default void fun(){

    }
}
/**
 * Created by wq on 16-8-2.
 */
public class Main {
    public static int getMinMoney(int [] arr , int sum){
        int [] a = new int[sum+1];
        Arrays.sort(arr);
        a[0] =0;
        for(int i = 1 ; i<arr[0] ; i++){
            a[i] = -1 ;
        }
        for(int i = arr[0]; i<=sum ; i++){
            int e = getMin(a,arr,i);
            if(e==-1){
                a[i] = -1;
            }else{
                a[i] = e+1;
            }
        }
        return a[sum];
    }

    public static int getMin(int a [] ,int [] arr, int l){
        int len = arr.length ;
        int min = Integer.MAX_VALUE ;
        for(int i =0 ; i<len ; i++){
            if(l-arr[i] >= 0 && a[l-arr[i]]!=-1){
                min = Math.min(a[l-arr[i]],min);
            } else{

            }
        }
        return min==Integer.MAX_VALUE ? -1 : min ;
    }



    public static void main(String args[]) throws Exception{
        int arr[] = {5,3};
        int s  = getMinMoney(arr,2);
        System.out.println(s);


//        FileWriter fw = new FileWriter("/home/wq/aaaaaaha.txt", true);
//        fw.write("h442");
//        fw.write("\t\n");
//        fw.write("wor66");
//        fw.write("\n");
//        fw.flush();
//        fw.close();
//        Scanner sc = new Scanner(System.in);
//        Set<String> set = new HashSet<>();
//        while(sc.hasNext()){
//            do{
//                String str = sc.nextLine();
//                if(str == null || str.length() ==0) break;
//                String [] strs = str.split(" ");
//                for(int i = 0 ; i<strs.length ; i++){
//                    set.add(strs[i]);
//                }
//            }while(sc.hasNextLine());
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
//            for(int i = 0 ; i<n ; i++){
//                for(int j = 0 ; j<m ;j++){
//                    arr[index++] = arrs[i][j];
//                }
//            }
//            Arrays.sort(arr);
//            System.out.println(arr[n-15]);
//        }

//        char [] chars = {'a','b','c'};
//        String path = "";
//        fun(chars,path);
//        func(chars,0);
//        getHuiWen("abdcb");
    }

    public static void fun(char []chars,String path){
        if(chars.length == 0 ){
            System.out.println(path);
            return ;
        }

        for(int i = 0 ; i<chars.length ; i++){
            char [] temp = new char[chars.length-1];
            int index = 0 ;
            for(int j = 0 ; j<chars.length; j++){
                if(j==i){
                    continue;
                }else{
                    temp[index++] = chars[j];
                }
            }
            fun(temp, path + chars[i]);
        }
    }

    public static void func(char [] chars,int start){
        if(start>=chars.length){
            for(int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
            return ;
        }
        for(int i = start ; i<chars.length ;i++){
            exchange(chars,i,start);
            func(chars,start+1);
            exchange(chars,i,start);
        }
    }

    public static void exchange(char [] chars, int i ,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp ;
    }


    public static void getHuiWen(String str){
        int len = str.length();
        String ss = "";
        char [] cha = str.toCharArray();
        for(int i = cha.length-1 ; i>=0 ; i--){
            ss+=cha[i];
        }


        int [][] chars = new int[len+1][len+1];
        for(int i = 0 ; i< len+1 ; i++){
            chars[0][i] = 0;
            chars[i][0] = 0;
        }

        for(int i = 1; i<len+1 ; i++){
            for(int j =1 ; j <len+1 ; j++){
                if(str.charAt(j-1) == ss.charAt(i-1)){
                    chars[i][j] = chars[i-1][j-1] +1 ;
                }
            }
        }

        int max = 0 ;
        for(int i = 0 ; i<len+1 ; i++){
            for(int j = 0 ; j<len+1 ; j++){
                if(chars[i][j] > max){
                    max = chars[i][j];
                }
            }
        }
        System.out.println(max);
    }

















//    public static void fun(char chars[] , String path){
//        int length = chars.length;
//
//        if(length  == 0) {
//            System.out.println(path);
//            return ;
//        }
//        for(int i = 0 ; i < length ; i++) {
//            int index = 0 ;
//            char tmpStr[] = new char[length -1];
//            for(int j = 0 ; j < length ; j++) {
//                if(j == i) {
//                    continue;
//                } else {
//                    tmpStr[index++] = chars[j];
//                }
//            }
//            fun(tmpStr , path + chars[i]);
//        }
//    }




}
