package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import static net.mindview.util.Print.*;
/**
 * Created by wq on 16-6-3.
 */


public class RowPoint {
    public boolean Find(int [][] array,int target) {
        if(array==null){
            return false;
        }
        int row = 0 ;
        int col = array[0].length -1;
        while(row < array.length && col>-1 ){
            if(array[row][col] == target){
                return true;
            }else if(array[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static String replaceSpace(StringBuffer str){
//        if(str == null && str.length() ==0 ){    //33ms
//            return "";
//        }
//        System.out.println(str.indexOf(" "));
//        while(str.indexOf(" ")>=0){
//            int i = str.indexOf(" ");
//            str.replace(i,i+1,"%20");
//        }
//        return str.toString();

        if(str==null)   //20ms
        {
            return null;
        }
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(c==' ')
            {
                str.replace(i,i+1,"%20");
            }
        }
        String newstr = str.toString();
        return newstr;


    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrList =  new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode !=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            arrList.add(stack.pop());
        }
        return arrList;

    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }

        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i =0 ; i<in.length ; i++){  //保存中續數組的值與 下標
            hashMap.put(in[i],i);
        }
        TreeNode head = preIn(pre,0,pre.length-1,in,0,in.length-1,hashMap);
        System.out.print("aaaaaaaaaaaaaaaaaaaaaaaa");

        return head;
    }

    public static TreeNode preIn(int [] pre , int pStart, int pStop,int [] in , int nStart , int nStop ,HashMap<Integer,Integer> map){
        if(pStart > pStop){
            return null;
        }

        TreeNode head  = new TreeNode(pre[pStart]);
        int headIndex = map.get(head.val);
        head.left = preIn(pre,pStart+1,headIndex+pStart-nStart,in,nStart,headIndex-1,map);
        head.right = preIn(pre,pStart+headIndex-nStart+1,pStop,in,headIndex+1,nStop,map);
        return head;

    }


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
            if(stack2.isEmpty() && stack1.isEmpty()){
                throw new RuntimeException("kong");
            }else if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
    }


    public static int Fibonacci(int n) {
        if(n==1) return 1;
        if(n == 0) return 0 ;

        int sum = 0 ;
        int minOne = 1;
        int minTwo = 0 ;

        for(int i = 2; i<=n;i++){
            sum = minOne + minTwo;
            minTwo = minOne;
            minOne = sum ;
        }
        return sum ;



    }

    public static int flag(int n){
        if(n==1) return 1 ;
        if(n==2) return 2;

        int sum = 0 ;
        int minOne = 2;
        int minTwo = 1;

        for(int i = 3 ; i<=n ; i++){
            sum = minOne + minTwo;
            minTwo = minOne;
            minOne = sum;
        }
        return sum ;

    }


    public static int JumpFloorII(int target) {
//        if(target == 1) return 1;
//        int [] minT = new int[target];
//        minT[0] =1 ;
//        int sum = 0 ;
//
//        int index = 1 ;
//        while(index < target){
//            int ss = 0 ;
//            for(int i = 0 ; i<index ; i++){
//                minT[index] += minT[i];
//            }
//            minT[index]+=1;
//            index++;
//        }
//
//        return minT[target-1];
//


        //由公式推出，f（n）  = 2*f(n-1)  所以 用遞歸也好做
        if(target == 1 || target == 0){
            return  1;
        }
        return 2 * JumpFloorII(target-1);


    }

    public static int RectCover(int target) {
        if(target==1) return 1 ;
        if(target==2) return 2;

        int sum = 0 ;
        int minOne = 2;
        int minTwo = 1;

        for(int i = 3 ; i<=target ; i++){
            sum = minOne + minTwo;
            minTwo = minOne;
            minOne = sum;
        }
        return sum ;
    }

    public static int  NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while(flag!=0){
//            print(n&flag);
            if((n&flag) !=0){
                count++;
            }
            flag<<=1;
        }
        return count;
    }



    public static int  goodNumberOf1(int n) {
        int count = 0 ;
        while(n!=0){
            n = n &(n-1);
            count++;
        }
        return count;
    }


    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if(exponent == 0){
            return 1 ;
        }else if(base == 0){
            return 0;
        }
        int a = exponent>0 ? 1 : -1;
        exponent = Math.abs(exponent);
        double result = Power(base,exponent>>1);
        result*=result;
        if((exponent & 1)==1){
            result *= base;
        }
        return a<0 ? 1/result : result;
    }


    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分。！！！
     * @param array
     */
    public static void reOrderArray1(int [] array) {
        if(array == null || array.length == 0 ){
            return ;
        }

        int start = 0 ;
        int stop = array.length -1;
        while(start<stop){
            while((array[start] & 1) ==1){
                start++;
            }
            while((array[stop] & 1)==0){
                stop--;
            }
            if(start<stop){
                int temp = array[start];
                array[start] = array[stop];
                array[stop] = temp;
            }
        }
        print("ok!!!!!!!!!!!!1");

    }

    public static void exchange(int [] array , int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
//    public static void reOrderArray(int [] array) {
//        for(int i= 0;i<array.length-1;i++){
//            for(int j=0;j<array.length-1-i;j++){
//                if(array[j]%2==0&&array[j+1]%2==1){
//                    int t = array[j];
//                    array[j]=array[j+1];
//                    array[j+1]=t;
//                }
//            }
//        }
//        print("ok!!!!!!!!!!!!1");
//    }



    public static void reOrderArray(int [] array) {
        print("aaaaaaaaaa");
        for(int i = 0 ; i<array.length-1 ; i++){
            for(int j = 0 ; j<array.length-1-i ; j++){
                if(array[j]%2==0 && array[j+1]%2 ==1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        print("ok!!!!!!!!!!!!1");
    }

    public static int [] minArray(int [] arr){
        if(arr == null || arr.length ==0 || arr.length ==1){
            return arr;
        }
        int count = 0 ;
        for(int i = 0 ; i<arr.length-1 ; i++){
            if((arr[i]^arr[i+1]) == 0 ){
                count++;
            }
        }
        int [] a = new int[arr.length -count];
        a[0] = arr[0];
        int ind = 1;
        for(int i = 1 ; i<arr.length ; i++){
            if((arr[i]^arr[i-1]) !=0){
                a[ind++] = arr[i];
            }
        }
        print("ok");
        return a;
    }


    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return head;
        }
        if(k == 0){
            return null;
        }
        int index = 1 ;
        ListNode listNode1 = head;
        ListNode listNode2 =null;
        while(index<=k-1){
            listNode1 = listNode1.next;
            index++;
            if(listNode1 == null){
                return null;
            }
        }
        while(listNode1 !=null){
            listNode1 = listNode1.next;
            if(listNode2 == null){
                listNode2 = head;
            }else{
                listNode2 = listNode2.next;
            }
        }
        return listNode2;


    }

    /**
     * 输入一个链表，反转链表后，输出链表的所有元素。
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode tail = null;

        ListNode p1 =head;
        if(p1.next == null)return head;
        ListNode p2 = p1.next;
        while(p2 != null){
            p1.next = tail;
            tail = p1;
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = tail;
        print("a");
        return p1;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 ==null){
            return null;
        }
        if(list1 == null && list2 != null) return list2;
        if(list1 != null && list2 == null) return list1;

        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode l1 = list1 == head ? list1 : list2;   //讓l1 指向有頭的listNode 主！！！
        ListNode l2 = list1 ==head ? list2 : list1;     //次！！！
        ListNode pre = null;
        ListNode next = null;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre = l1 ;
                l1 = l1.next;
            }else{
                next = l2.next;
                pre.next = l2 ;
//                l1 = l1.next;
                l2.next = l1;
                pre = l2;
                l2 = next;
            }
        }

        pre.next = l1==null ? l2 : l1;
//        print("aaaa");
        return head;

    }


    /**
     * 输入两颗二叉树A，B，判断B是不是A的子结构。
     * @param root1
     * @param root2
     * @return
     */

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return check(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public static boolean check(TreeNode node1 , TreeNode node2){
        if(node2 == null){
            return true;
        }
        if(node1 == null || node1.val != node2.val){
            return false;
        }

        return check(node1.left,node2.left) && check(node1.right,node2.right);
    }

    public static void mirror(TreeNode root){
        if(root == null){
            return ;
        }
        exchange(root,root.left,root.right);
        if(root.left !=null){
            mirror(root.left);
        }
        if(root.right != null){
            mirror(root.right);
        }
    }

    public static void exchange(TreeNode root ,TreeNode node1, TreeNode node2){
        if(node1 ==null && node2 ==null) return ;
        if(node1!=null && node2!=null){
            TreeNode temp = node1;
            node1 = node2;
            node2 = temp ;
            root.left = node1;
            root.right = node2;
        }
        if(node1 == null && node2 != null){
            root.left = node2 ;
            root.right = null;
        }
        if(node2 == null && node1 != null){
            root.right = node1;
            root.left = null;
        }
    }


    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length ;
        int cols = matrix[0].length;
        int a = 0 ;
        int b = 0 ;
        int c = rows-1;
        int d = cols-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(a<=c && b<=d){
            printM(list,matrix,a++,b++,c--,d--);
        }
        System.out.println("aaaa");
        return list;
    }

//    public static void printMatrixClockwisely(int [][] arr){
//        int rows = arr.length ;
//        int cols = arr[0].length;
//        int a = 0 ;
//        int b = 0 ;
//        int c = rows-1;
//        int d = cols-1;
//
//        while(a<=c && b<=d){
//          printM(arr,a++,b++,c--,d--);
//        }
//    }

    public static void printM(ArrayList<Integer> list,int [][] arr,int a ,int b ,int c , int d){
        if(a == c ){
            for (int i = a ; i<=d ; i++){
                list.add(arr[a][i]);
            }
        }else if(b ==d ){
            for(int i = a ; i<=c ;i++){
                list.add(arr[i][b]);
            }
        }else{
            for(int i = b ; i<=d ; i++){
                list.add(arr[a][i]);
            }
            for(int i = a+1; i<=c ; i++ ){
                list.add(arr[i][d]);
            }
            for(int i = d-1 ; i>=b ; i--){
                list.add(arr[c][i]);
            }
            for(int i = c-1 ; i>a ; i--){
                list.add(arr[i][b]);
            }
            a++;
            b++;
            c--;
            d--;
        }
    }





    public static void main(String []args){
//        int [] pre = {1,2,4,7,3,5,6,8};
//        int [] in = {4,7,2,1,5,3,8,6};

        int [] pre = {1,2,4,5,8,9,3,6,7};
        int [] in = {4,2,8,5,9,1,6,3,7};

        int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] arr1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int [][] arr2 = {{1,2,3,4}};
        int [][] arr3 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

//        printMatrixClockwisely(arr2);
        printMatrix(arr1);
    }

}





























//ListNode node1 = new ListNode(1);
//ListNode node2 = new ListNode(2);
//ListNode node3 = new ListNode(3);
//ListNode node4 = new ListNode(4);
//ListNode node5 = new ListNode(5);
//ListNode node6 = new ListNode(6);
//ListNode node7 = new ListNode(7);
//node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        System.out.println(printListFromTailToHead(node1));





//ListNode node1 = new ListNode(1);
//ListNode node2 = new ListNode(2);
//ListNode node3 = new ListNode(3);
//ListNode node4 = new ListNode(4);
//ListNode node5 = new ListNode(5);
//ListNode node6 = new ListNode(6);
//node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//
//
//        ListNode node21 = new ListNode(1);
//        ListNode node22 = new ListNode(3);
//        ListNode node23 = new ListNode(5);
//        ListNode node24 = new ListNode(7);
//        ListNode node25 = new ListNode(9);
//        ListNode node26 = new ListNode(11);
//
//        node21.next = node22;
//        node22.next = node23;
//        node23.next = node24;
//        node24.next = node25;
//        node25.next = node26;
//        print(FindKthToTail(node1,1).val);
//        print(FindKthToTail(node1,2).val);
//        print(FindKthToTail(node1,3).val);
//        print(FindKthToTail(node1,4).val);
//        print(FindKthToTail(node1,5).val);
//        print(FindKthToTail(node1,6).val);
//        print(FindKthToTail(node1,7).val);
//        print(ReverseList(node1));
//        Merge(node1,node21);




//JumpFloorII
//        reConstructBinaryTree(pre,in);
//        System.out.print("aaaaaaaaaaaaaaaaaaaaaaaa");


//        System.out.println(flag(5));
//        System.out.println(Fibonacci(5));
//        print(JumpFloorII(5));
//        print(NumberOf1(100));
//        print(goodNumberOf1(100));
//        print(NumberOf1(-100));
//        print(goodNumberOf1(-100));

//        print(Power(2, -3));
//        int [] arr = {1,2,3,4,5,6,7,8,9,10};
//        reOrderArray1(arr);
//        int arr[] = {1,3,6,4,2,7};
//        reOrderArray(arr);
//        int a[] = {1,1,2,2,3,3,4,4,5,5,5,5,5,6,6,7,7};
//
//        minArray(a);

//        int a = -128 ;
//        System.out.format("%x",a);
//        System.out.println("");
//        a>>=1;
//        System.out.format("%x",a);
//        print(a);
//        System.out.println("");
//        int b = -128;
//        b>>>=1;
//        print(b);
//        System.out.format("%x",b);

//        a>>>=1;
//        int b =(a>>1);
//        print("%d",a);
//        print(b);

//        double d1=-0.4;
//        System.out.println("Ceil d1="+Math.ceil(d1));
//        System.out.println("floor d1="+Math.floor(d1));
//        int i=0;
//        Integer j = new Integer(0);
//        System.out.println(i==j);
//        System.out.println(j.equals(i));