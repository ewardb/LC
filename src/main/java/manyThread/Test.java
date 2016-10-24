package manyThread;

import java.nio.charset.Charset;

/**
 * Created by wq on 16-8-19.
 */
public class Test {


    public static String sub1(String str , int byteLen) {
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        int index = 0;
        int point = 0;
        while (index <= byteLen && point < length) {
            if ((str.charAt(point) - 0) >= 0 && (str.charAt(point) - 0) <= 255) {
                if (index < byteLen) {
                    sb.append(str.charAt(point));
                    index++;
                }
            } else {
                int s = index + 2;
                if (s <= byteLen) {
                    sb.append(str.charAt(point));
                }
                index = s;
            }
            point++;
        }
        return sb.toString();
    }



    public static void main(String args[]){












//        String str = "我ABC和def";
//        String str = "我ABC";
//        String str = "abcdefg我ABC";
//        System.out.println(sub1(str, 9));


//        MyList mylist = new MyList();
//
//        MyThreadA a = new MyThreadA(mylist);
//        a.setName("A");
//        a.start();
//
//        MyThreadB b = new MyThreadB(mylist);
//        b.setName("B");
//        b.start();









//        System.out.println(Charset.defaultCharset());
//        String s = "hell我o";
//        System.out.println(s.length());
//        System.out.println(3+ "   "+ s.charAt(3));   //l
//        System.out.println(4+ "   " + s.charAt(4) +" "+ (s.charAt(4)-0));  //我
//        System.out.println(5+ "   "+ s.charAt(5));  //o
//        byte [] bytes = s.getBytes();
//        System.out.println(bytes.length);
//        for(int i = 0 ; i<bytes.length ; i++){
//            System.out.print(bytes[i]+"    ");
//        }
//        System.out.println();
//        System.out.println(bytes.length);





























//        try {
//            MyThread thread = new MyThread();
////            thread.setDaemon(true);
//            thread.start();
//            Thread.sleep(5000);
//            System.out.println("ÎÒÀë¿ªthread¶ÔÏóÒ²²»ÔÙŽòÓ¡ÁË£¬Ò²ŸÍÊÇÍ£Ö¹ÁË£¡");
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }


//
//        try {
//            MyThread thread = new MyThread();
//            thread.start();
//            Thread.sleep(2000);
//            thread.interrupt();
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }
//        System.out.println("end!");
//







//        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());

//        MyThread t1 = new MyThread("t1");
//        MyThread t2 = new MyThread("t2");
//        MyThread t3 = new MyThread("t3");
//        t1.start();
//        t2.start();
//        t3.start();


//        MyThread myThread = new MyThread("a");
//
//        Thread t1 = new Thread(myThread,"A");
//        Thread t2 = new Thread(myThread,"b");
//        Thread t3 = new Thread(myThread,"c");
//        Thread t4 = new Thread(myThread,"d");
//        Thread t5 = new Thread(myThread,"e");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();


//        try {
//            MyThread thread = new MyThread();
//            thread.start();
////            Thread.sleep(2000);
//            System.out.println(thread.isInterrupted());
//            thread.interrupt();
//            System.out.println(thread.isInterrupted());
//        } catch (Exception e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }

//        try {
//            MyThread thread = new MyThread();
//            thread.start();
//            Thread.sleep(1000);
//            thread.interrupt();
//            //Thread.currentThread().interrupt();
//            System.out.println("ÊÇ·ñÍ£Ö¹1£¿="+thread.interrupted());
//            System.out.println("ÊÇ·ñÍ£Ö¹2£¿="+thread.interrupted());
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }
//        System.out.println("end!");
//


//
//        Thread.currentThread().interrupt();
//        System.out.println("ÊÇ·ñÍ£Ö¹1£¿=" + Thread.interrupted());
//        System.out.println("ÊÇ·ñÍ£Ö¹2£¿=" + Thread.interrupted());
//        System.out.println("end!");


//        try{
//            MyThread mythread = new MyThread();
//            mythread.setName("Mythread");
//            mythread.start();
//            for(int i = 0 ; i< 10 ; i++){
//                int time = (int) (Math.random()*1000);
//                Thread.sleep(time);
//                System.out.println("main         "+ Thread.currentThread().getName());
//            }
//
//
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
}
