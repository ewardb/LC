package leetCode.L53;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by wq on 16-5-3.
 */
public class SolutionAnagram {
    public static boolean isAnagram(String s, String t) {   //112ms
//        if(s.length()!=t.length() || s==null || t==null){
//            return false;
//        }
//        int [] charMap = new int[65536];
//        int f = (2<<15);
//        System.out.println(f);
//
//        char [] ss = s.toCharArray();
//        char [] tt = t.toCharArray();
//
//        for(char c :ss){
//            charMap[c]++;
//        }
//        for(char c:tt){
//            charMap[c]--;
//        }
//        for(int c:charMap){
//            if(c!=0){
//                return false;
//            }
//        }
//        return true;


//        if(s.length()!=t.length()){
//            return false;
//        }
//        String [] ss = s.split("");
//        String [] tt = t.split("");
//        HashMap<String,Integer> sHash = new HashMap<String,Integer>();
//        HashMap<String,Integer> tHash = new HashMap<String,Integer>();
//
//        for(int i=0 ; i<ss.length ;i++){
//            sHash.put(ss[i],sHash.getOrDefault(ss[i],0)+1);
//            tHash.put(tt[i],tHash.getOrDefault(tt[i],0)+1);
//        }
//        System.out.println("abc");
//        for(String keys : sHash.keySet()){
//            if(tHash.containsKey(keys) && sHash.get(keys).equals(tHash.get(keys)) ){
//            }else{
//                return false;
//            }
//        }
//        return true;

//        if(s==null || t==null || s.length() !=t.length()){
//            return false;
//        }
//
//
//
//        char [] sc = s.toCharArray();
//        char [] tc = t.toCharArray();
//        Arrays.sort(sc);
//        Arrays.sort(tc);
//        if(new String(sc).equals(new String(tc))){
//            return true ;
//        }else{
//            return false;
//        }



//  只用於小寫字符串！
        int [] charMap = new int['z'-'a' +1];
        for(char c:s.toCharArray()){
            int pos = c - 'a';
            charMap[pos]++;
        }

        for(char c:t.toCharArray()){
            int pos = c- 'a';
            charMap[pos]--;
        }

        for(int count:charMap){
            if(count!=0){
                return false;
            }
        }

        return true;

    }

    public static void main(String args[]){
        String s = "at" ;
        String t = "at";
        int [] charMap = new int[65536];
//        for(int i=0 ;i<65536;i++){
//            charMap[i] = i;
//        }
//        System.out.println();
//        for(int i :charMap){
//            System.out.print((char) i);
//            System.out.print("  ");
//        }
//        char c = '網';
        System.out.println(isAnagram(s,t));
    }

}
