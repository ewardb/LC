package niuke.stackAndQueue;

import java.util.Stack;

/**
 * Created by wq on 16-5-18.
 */

//用兩個Stack 來實現一個隊列 Queue

public class MyQueue {

    private Stack<Integer> stackPush ;
    private Stack<Integer> stackPop ;

    public MyQueue(){
        stackPush =new Stack<Integer>();
        stackPop =new Stack<Integer>();
    }

    public void add(int t){
        this.stackPush.add(t);
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }else if(!stackPush.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("queue is empty");
        }else if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }




}
