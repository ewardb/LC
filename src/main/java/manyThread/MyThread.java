package manyThread;

/**
 * Created by wq on 16-8-19.
 */
public class MyThread extends Thread {
//    private int i = 5;

    public MyThread(){

    }

    public MyThread(String name){
        super();
        this.setName(name);
    }

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    @Override
//    public void run() {
//        super.run();
//        try {
//            for (int i = 0; i < 500000; i++) {
//                if (this.interrupted()) {
//                    System.out.println("ÒÑŸ­ÊÇÍ£Ö¹×ŽÌ¬ÁË!ÎÒÒªÍË³öÁË!");
//                    throw new InterruptedException();
//                }
//                System.out.println("i=" + (i + 1));
//            }
//            System.out.println("ÎÒÔÚforÏÂÃæ");
//        } catch (InterruptedException e) {
//            System.out.println("œøMyThread.javaÀàrun·œ·šÖÐµÄcatchÁË£¡");
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void run() {
//        super.run();
//        for (int i = 0; i < 500000; i++) {
//            if (this.interrupted()) {
//                System.out.println("ÒÑŸ­ÊÇÍ£Ö¹×ŽÌ¬ÁË!ÎÒÒªÍË³öÁË!");
//                break;
//            }
//            System.out.println("i=" + (i + 1));
//        }
//        System.out.println("ÎÒ±»Êä³ö£¬Èç¹ûŽËŽúÂëÊÇforÓÖŒÌÐøÔËÐÐ£¬Ïß³Ì²¢ÎŽÍ£Ö¹£¡");
//    }

//    @Override
//    public void run() {
//        super.run();
//        for (int i = 0; i < 500000; i++) {
//            if (this.interrupted()) {
//                System.out.println("ÒÑŸ­ÊÇÍ£Ö¹×ŽÌ¬ÁË!ÎÒÒªÍË³öÁË!");
//                break;
//            }
//            System.out.println("i=" + (i + 1));
//        }
//    }




//
//    @Override
//    public void run() {
//        super.run();
//        for (int i = 0; i < 500; i++) {
//            System.out.println("i=" + (i + 1));
//        }
//    }
//    @Override
//    synchronized public void run(){
//        super.run();
//        i--;
//
//        System.out.println("run " + this.currentThread().getName() + " i=     "+i);
//
//
//
//
////        try {
////            for(int i  = 0 ; i<10 ; i++){
////                int time = (int) (Math.random()*1000);
////                Thread.sleep(time);
////                System.out.println("run          " + Thread.currentThread().getName());
////            }
////        }catch (InterruptedException e){
////            e.printStackTrace();
////        }
//    }
}
