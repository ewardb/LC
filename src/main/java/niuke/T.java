package niuke;

import java.lang.System;
import static net.mindview.util.Print.*;
//import static net.*;

/**
 * Created by wq on 16-5-18.
 */
//:object/ShowProperties.java
class Foo {
    final int i;
    int j;

    public Foo(int i){
        this.i = i ;
    }
    public void doSomething() {
        System.out.println(++j + i);
    }
}

class Person {
    String name = "No name";
    public Person() {

    }
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        super();
        empID = id;
    }
}

public class T {
//    public static void main(String args[]){
//        System.getProperties().list(System.out);
//        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("java.library.path"));
//        print("aaa");
//        int[][] array = new int[3][]{ new int[3]{5,6,2},new int[5]{6,9,7,8,3},new int[2]{3,2} };
////        java.lang.Math.round(2);
//    }
//    String str = new String("good");
//    char[] ch = { 'a', 'b', 'c' };
//    int j = 0 ;
//    public static void main(String args[]) {
//        T ex = new T();
//        ex.change(ex.str, ex.ch,ex.j);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);
//        System.out.print(ex.j);
//    }
//
//    public void change(String str, char ch[],int i)
//    {
//        str = "test ok";
//        ch[0] = 'g';
//        short a = 130;
//        byte b = (byte)a;
//        System.out.println(b);
//    }

//    public static void main(String args[]) {
//        Employee e = new Employee("123");
//        System.out.println(e.empID);
//    }

    public final void s(){

    }
    public final void s(String s){

    }

}

enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
class EnumOne
{
    public static void main(String[]args)
    {
        int i = 1<<1;
        i>>>=1;
        System.out.println(AccountType.FIXED);
    }
}