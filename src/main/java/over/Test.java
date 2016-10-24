package over;

/**
 * Created by wq on 16-9-13.
 */

class A{
    static {
        System.out.println("AAAAAAAAA");
    }
    public static final String a = "aa";
    public static String b = "sss";

}


public class Test {
    public static void main(String args[]){
//        Human h1 = new Man();
//        Human h2 = new Human();
//        System.out.println(A.a);
        final String a= "ddd";
        System.out.println(A.b);
    }
}
