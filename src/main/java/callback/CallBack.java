package callback;

/**
 * Created by wq on 16-10-24.
 * 这是一个回调接口
 */
public interface CallBack {
    /**
     * 这是小李知道答案时要告诉调用的函数的小王，也就是回调函数。
     * @param result 是答案！
     */
    public void result(String result);
}

