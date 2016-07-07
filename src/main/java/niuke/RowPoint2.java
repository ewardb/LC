package niuke;

import java.util.*;

import static net.mindview.util.Print.*;
/**
 * Created by wq on 16-6-7.
 */
public class RowPoint2 {

    //========================================
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
     * @param node
     */

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2Min = new Stack();

    public void push(int node) {
        stack1.push(node);
        if(stack2Min.empty()){
            stack2Min.add(node);
        }else{
            if(node<stack2Min.peek()){
                stack2Min.push(node);
            }else{
                stack2Min.push(stack2Min.peek());
            }
        }
    }

    public void pop() {
        if(stack1.empty()){
            throw new RuntimeException("stack empty");
        }else{
            stack2Min.pop();
            stack1.pop();
        }
    }

    public int top() {
        if(!stack1.empty()){
            return stack1.peek();
        }else{
            throw new RuntimeException("stack empty");
        }
    }

    public int min() {
        if(!stack2Min.empty()){

            return stack2Min.peek();
        }else{
            throw new RuntimeException("stack empty");
        }
    }
    //========================================


    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null){
            return false;
        }else if (pushA.length == 0||  popA.length ==0 ){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        if(pushA !=null && popA !=null){
            int indexPush = 0;
            int indexPop = 0 ;
            while(indexPush<pushA.length){
                if(stack.empty()){
                    stack.push(pushA[indexPush++]);
                }else if(!stack.empty() && (stack.peek() != popA[indexPop])){
                    stack.push(pushA[indexPush++]);
                }else{
                    while(!stack.empty() && (stack.peek() == popA[indexPop])){
                        stack.pop();
                        indexPop++;
                    }
                }
            }

            while(!stack.empty()){
                if(stack.pop() != popA[indexPop++]) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    ArrayList<Integer> arrayList = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null){
            return arrayList;
        }
        arrayList.add(root.val);
        if(root.left !=null) queue.add(root.left);
        if(root.right !=null) queue.add(root.right);
        PrintFromTopToBottom(queue.poll());
        return arrayList;
    }


    /**
     * 输入一个整数数组，
     * 判断该数组是不是某!!!!二叉搜索树!!!的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }

        int root = sequence[sequence.length-1];
        int i = 0;
        for(; i<sequence.length-1;i++){
            if(sequence[i]>root){
                break;
            }
        }

        int j = i ;
        for(; j<sequence.length -1 ; j++){
            if(sequence[j] < root) return false;
        }

        boolean left = true;
        if(i>0){
            left = VerifySquenceOfBST(sub(sequence,0,i));
        }

        boolean right = true;
        if(i<sequence.length-1){
            right = VerifySquenceOfBST(sub(sequence,i,sequence.length-1));
        }

        return left&&right;


    }

    public static int[] sub(int [] arr,int start ,int stop){
        int [] a  = new int[stop-start];
        int index = 0;
        for(int i = start ; i<stop ; i++){
            a[index++] = arr[i];
        }
        return a;
    }

    int res= 0;
    public int Sum_Solution(int n) {
        check(n);
        return res;
    }
    public boolean check(int n){
        res += n;
        return check(n-1) && n!=0;
    }


    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1,int num2) {
        int move = 1;
        int jin = 0;
        int sum = 0;
        int index = 0 ;
        while(index<32){
            int ss = 0 ;
            if(jin ==0 ){
                if( ((num1&move) != 0 ) && ((num2&move) == 0) ){
                    ss = move;
                    jin = 0 ;
                }else if( ((num1&move) != 0) && ((num2&move) != 0) ){
                    ss = 0 ;
                    jin = 1;
                }else if( ((num1&move) == 0) && ((num2&move) == 0) ){
                    ss = 0 ;
                    jin =0 ;
                }else{
                    ss = move;
                    jin = 0 ;
                }
            }else{
                if( ((num1&move) != 0) && ((num2&move) == 0) ){
                    ss = 0;
                    jin = 1 ;
                }else if( ((num1&move) != 0) && ((num2&move) != 0) ){
                    ss = move ;
                    jin = 1;
                }else if( ((num1&move) == 0) && ((num2&move) == 0) ){
                    ss = move ;
                    jin =0 ;
                }else{
                    ss = 0;
                    jin = 1 ;
                }
            }
            move<<=1;
            index++;
            sum = sum | ss;
        }
        return sum ;
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
//    public boolean duplicate(int numbers[],int length,int [] duplication) {
//
//    }


    /**
     * 求出1~13的整数中1出现的次数,
     * 并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
     * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
     * @param n
     * @return
     */

    public static int NumberOf1Between1AndN_Solution(int n) {





        return 1;
    }



    public static void main(String args[]){


    }
//        Math
}

//RowPoint2 rp = new RowPoint2();
//rp.push(3);
//        rp.push(3);
//        rp.push(2);
//        rp.push(2);
//        rp.push(2);
//        rp.push(3);
//        rp.push(3);
//        rp.push(0);
//        Stack<Integer> stack =  new Stack<Integer>();
//        print(stack.peek());

//        int [] pushA = {1,2,3,4,5};
//        int [] popA = {4,5,3,2,1};
//        int [] popA2 = {4,3,5,1,2};
//        print(IsPopOrder(pushA,popA));

//    print(Add(11, 9));
//        int[] arr = {5,7,6,9,11,10,8};
//        print(VerifySquenceOfBST(arr));





//
//TreeNode treeNode10 = new TreeNode(10);
//TreeNode treeNode5 = new TreeNode(5);
//TreeNode treeNode12 = new TreeNode(12);
//TreeNode treeNode4 = new TreeNode(4);
//TreeNode treeNode7 = new TreeNode(7);
//treeNode10.left = treeNode5;
//        treeNode10.right = treeNode12;
//        treeNode5.left = treeNode4;
//        treeNode5.right = treeNode7;
//        FindPath(treeNode10, 15);