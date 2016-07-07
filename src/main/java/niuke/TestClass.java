package niuke;

/**
 * Created by wq on 16-5-27.
 */
public class TestClass {
//    private static void testMethod(){
//        System.out.println("testMethod");
//    }
//    public static void main(String[] args) {
//        ((TestClass)null).testMethod();
//    }
}

//class Two{
//    byte x;
//}
//class PassO{
//    public static void main(String[] args){
//        PassO p=new PassO();
//        p.start();
//    }
//    void start(){
//        Two t=new Two();
//        System.out.print(t.x+" ");
//        Two t2=fix(t);
//        System.out.print(t.x+" " +t2.x);
//    }
//    Two fix(Two tt){
//        tt.x=42;
//        return tt;
//    }
//}



class Car extends Vehicle
{
    public static void main (String[] args)
    {
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
        new  Car(). run();
    }
    private final void run()
    {
        System. out. println ("Car");
    }


//
//    String str = new String("good");
//    char[] ch = { 'a', 'b', 'c' };
//
//    public static void main(String args[]) {
//        Car ex = new Car();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);
//    }
//
//    public void change(String str, char ch[])
//    {
//        str = "test ok";
//        ch[0] = 'g';
//    }


}
class Vehicle
{
    private final void run()
    {
        System. out. println("Vehicle");
    }
}















