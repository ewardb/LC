package niuke.stackAndQueue;

import java.io.UnsupportedEncodingException;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * Created by wq on 16-5-18.
 */


// 用兩個Stack來 實現一個特殊的Stack. 可以得到stack中最小的元素。

public class MyStack<Integer> {
    static String sql = "";
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


    public static void sort(Stack<java.lang.Integer> stack){
        Stack<java.lang.Integer> help = new Stack();
        while(!stack.empty()){
            int cur = stack.pop();
            while(!help.empty() && help.peek()>cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.empty()){
            stack.push(help.pop());
        }

    }

//    public int hanoiProblem1(int num , String left , String mid , String right){
//
//    }
//

    //生成窗口最大值數組！
    public static int[] getMaxWidow(int [] arr,int w){
        if(arr == null || arr.length <w || w<1){
            return null;
        }
        int [] res = new int[arr.length -w +1];
        int index = 0 ;
        LinkedList<java.lang.Integer> qmax = new LinkedList<>();
        for(int i = 0 ;  i<arr.length ; i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.getFirst() == i - w){
                qmax.pollFirst();
            }
            if(i >= w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public void ss(){
        sql = "heeeee";
        System.out.println(sql);
    }

    public void tt(){
        Object obj = new Object();
        sql = "dfddfdfdf";
        System.out.println(sql);
    }

    public static void main(String args[]) throws UnsupportedEncodingException{
//        Stack s = new Stack<java.lang.Integer>();
//        MyStack a = new MyStack<>();
//        String str = "hello";
//        String str2 = new String("hello");
//        a.ss();
//        System.out.println(sql);
//        a.tt();
//        System.out.println(sql);
//        s.push(1);
//        s.push(5);
//        s.push(2);
//        s.push(7);
//        s.push(6);
//        s.push(3);
////        reverse(s);
//        sort(s);
//        int [] t = new int[10];
//        Cat [] cats = new Cat[10];
//        cats[0] = new Cat();
//        List<String>  list = new LinkedList<>();
//        System.out.println(System.getProperty("file.encoding"));
//        int [] s = {4,9,5,4,3,3,6,7};
//        print(Arrays.toString(getMaxWidow(s, 3)));
//        byte [] a = {1,2,3,4,5};
//        byte [] aa = "中國你好".getBytes("GBK");
//        print(Arrays.toString(aa));

//        String a="1234";
//        String b="1234";
//        String c = new String("1234");
//        System.out.println(a==b);
//        System.out.println(a==c);
//        System.out.println(a.equals(c));



        String s = null;
        if((s != null) && (s.length()>0)){
            System.out.println("adb");
        }


        if(42.0f == 42) print("a");
//        print("北京市".matches(".{9}"));
//        print("-1234".matches("-?\\d+"));
//        print("-+1234".matches("(-|\\+)*\\d+"));
        print("17947319918".matches("1[3,5]{1}[8,9]{1}[0-9]{8}"));

    }
}
