package callback;

/**
 * Created by wq on 16-10-24.
 */
public class Test {
    public static void main(String args[]){
        Li li = new Li();
        Wang wa = new Wang(li);
        wa.askQuestion("1+1=");

    }
}
