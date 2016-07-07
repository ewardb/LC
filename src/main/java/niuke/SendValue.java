package niuke;

/**
 * Created by wq on 16-5-27.
 */
public class SendValue {
        public String str="6";
        public static void main(String[] args) {
            SendValue sv=new SendValue();
            sv.change(sv.str);
            System.out.println(sv.str);//6
        }
        public void change(String str) {
            str="10";
        }
//        public static void main(String[] args) {
//            SendValue sv=new SendValue();
//            sv.str = "10";
//            System.out.println(sv.str); //10
//        }
}
