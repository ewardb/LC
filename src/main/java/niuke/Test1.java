package niuke;

/**
 * Created by wq on 16-4-28.
 */
class Base {
    public void method(){
        System.out.println("Base");

    }
}

class Son extends Base{
    public void method(){
        System.out.println("Base Son");

    }
    public void methodB(){
        System.out.println("methodB");
    }
}

public class Test1{
    public static void main(String args[]){
        Base base = new Son();
        base.method();
//        base.methodB();
    }
}
// ==  地址的比較
//  equals  內容的比較