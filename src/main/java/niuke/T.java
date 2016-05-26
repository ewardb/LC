package niuke;

import java.lang.System;
import static net.mindview.util.Print.*;
//import static net.*;

/**
 * Created by wq on 16-5-18.
 */
//:object/ShowProperties.java

public class T {
    public static void main(String args[]){
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
        print("aaa");
//        java.lang.Math.round(2);
    }
}
