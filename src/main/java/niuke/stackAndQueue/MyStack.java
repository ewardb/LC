package niuke.stackAndQueue;

import java.util.*;
import static net.mindview.util.Print.*;

/**
 * Created by wq on 16-5-18.
 */


// 用兩個Stack來 實現一個特殊的Stack. 可以得到stack中最小的元素。

public class MyStack<Integer> {
    private Stack<java.lang.Integer> stackData;
    private Stack<java.lang.Integer> stackMin;


    public MyStack(){
        this.stackData = new Stack<java.lang.Integer>();
        this.stackMin = new Stack<java.lang.Integer>();
    }

    public void push(int t){
        if(this.stackMin.isEmpty()){
            stackMin.push(t);
        }else if(t <= this.getMin()){
            stackMin.push(t);
        }
        stackData.push(t);
    }

    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if(value == this.stackMin.peek()){
            this.stackMin.pop();
        }
        return value;
    }

    public java.lang.Integer getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }else{
            return this.stackMin.peek();
        }
    }

    public static int getAndRemoveLastElement(Stack<java.lang.Integer> stack){
        int result  = stack.pop();
        if(stack.empty()){
            return result;
        }else{
            int s = getAndRemoveLastElement(stack);
            stack.push(result);
            return s ;
        }

    }

    public static void reverse(Stack<java.lang.Integer> stack){
        if(!stack.empty()){
            int i = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(i);
        }else{
            return ;
        }
    }


    public static void main(String args[]){
        Stack s = new Stack<java.lang.Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverse(s);
    }

}
