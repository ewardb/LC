package callback;

/**
 * Created by wq on 16-10-24.
 */
public class Li {
    /**
     *
     * @param callBack
     * @param question 小王的问题
     */
    public void executeMessage(CallBack callBack, String question){
        System.out.println("王的问题是"+question);

        //模拟要做很长时间
        for(int i = 0; i<10000 ; i++){

        }
        String rs = "答案是2";
        callBack.result(rs);
    }

}
