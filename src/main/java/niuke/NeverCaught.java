package niuke;

/**
 * Created by wq on 16-5-27.
 */
public class NeverCaught {



    static int s = 5 ;
    static {
        System.out.print("static init" + s);

    }
    static void f(){
        throw new RuntimeException("form f()");
    }

    static void g(){
       f();
    }


    public static void main(String args[]){
        g();

    }
}
