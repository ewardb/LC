package callback;

/**
 * Created by wq on 16-10-24.
 */
public class Wang implements CallBack {
    private Li li;
    public Wang(Li li){
        this.li = li;
    }

    public void askQuestion(String req){
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this,req);
            }
        }).start();
        //交给小李，去做别的事情
        play();
    }
    public void play(){
        System.out.println("小王逛街了");
    }


    @Override
    public void result(String result){
        System.out.println("小李告诉小王的答案是--->" +result);
    }
}
