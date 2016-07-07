package niuke;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wq on 16-7-3.
 */
public class RowPoint5 {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * @param num
     */
    Queue<Integer> queue = new LinkedList<>();


    public void Insert(Integer num) {
        queue.add(num);
    }

    public Double GetMedian() {
        int length = queue.size();
        int [] arr = new int[length];
        int index=0;
        for(int q:queue){
            arr[index++] = q;
        }
        Arrays.sort(arr);
        if(length%2==0){
            return (double)(arr[length / 2] + arr[length/2 - 1])/2;
        }else{
            return (double)arr[length/2];
        }

    }


    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
     * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
     * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(num == null){
            return null;
        }
        if(size <1 ||num.length<size){
            return arrayList;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int [] res = new int[num.length-size+1];
        int index = 0 ;
        for(int i = 0 ; i< num.length ; i++){
            while(!qmax.isEmpty() && num[qmax.peekLast()]<=num[i]){
                qmax.pollLast();
            }
            qmax.add(i);
            if(qmax.peekFirst() == i-size){
                qmax.pollFirst();
            }
            if(i>= size-1){
                res[index++] = num[qmax.peekFirst()];
            }
        }

        for(int i : res){
            arrayList.add(i);
        }
        return arrayList;


    }


    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || str == null || matrix.length<str.length){
            return false;
        }
        int [] flag = new int[matrix.length];
        for(int i = 0 ; i<matrix.length ; i++){
            if(matrix[i] == str[0]){
                if(comm(matrix,rows,cols,str,1,i,flag)) {
                    return  true;
                }else{
                    flag[i]=0;
                }
            }
        }
        return false;
    }

    public static boolean comm(char []matrix , int rows , int cols , char [] str , int indexChar, int indexMatr, int [] flag ) {
        if(indexChar==str.length) return true;
        flag[indexMatr] = 1;
        // top
        if(indexMatr-cols >=0 && matrix[indexMatr-cols] == str[indexChar] && flag[indexMatr-cols] !=1){
            int top = indexMatr - cols;
            if(comm(matrix,rows,cols,str,indexChar+1,top,flag)){
                return true;
            }else{
                flag[top] =0 ;
            }
        }
        //left
        if(indexMatr % cols != 0 && matrix[indexMatr - 1] == str[indexChar] && flag[indexMatr - 1] !=1){
            int left = indexMatr - 1;
            if(comm(matrix,rows,cols,str,indexChar+1,left,flag)){
                return true;
            }else{
                flag[left] =0 ;
            }
        }
        //right
        if(indexMatr%cols !=cols-1 && matrix[indexMatr + 1] == str[indexChar] && flag[indexMatr + 1] !=1){
            int right = indexMatr + 1;
            if(comm(matrix,rows,cols,str,indexChar+1,right,flag)){
                return true;
            }else{
                flag[right] =0 ;
            }
        }
        //bottom
        if(indexMatr+cols < matrix.length && matrix[indexMatr + cols] == str[indexChar] && flag[indexMatr + cols] !=1){
            int butt = indexMatr + cols;
            if(comm(matrix,rows,cols,str,indexChar+1,butt,flag)){
                return true;
            }else{
                flag[butt] =0 ;
            }
        }
        return false;
    }
    /**
     * 最大公約數！！！
     * @param t
     * @param s
     * @return
     */

    public static int getMaxPub(int t , int s){
        return s==0 ? t : getMaxPub(s,t%s);
    }

    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子.
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols){
        if(threshold == 0){
            return 0;
        }
        int [] flag = new int[rows * cols];
        int sum =movingCountCore(threshold,rows,cols,0,0,flag);

        return sum;
    }

    public static int movingCountCore(int threshold,int rows,int cols,int row , int col, int []flag){
        int count = 0 ;
        if(check(threshold,rows,cols,row,col,flag)){
            flag[row*cols    +col] = 1;
            count  = 1 + movingCountCore(threshold,rows,cols,row-1,col,flag) + movingCountCore(threshold,rows,cols,row+1,col,flag) +
                         movingCountCore(threshold,rows,cols,row,col-1,flag) +movingCountCore(threshold,rows,cols,row,col+1,flag) ;
        }
        return count;
    }

    public static boolean check(int threshold,int rows,int cols,int row , int col, int []flag){
        if(row >= 0 && col >=0 && row<rows && col<cols && getDig(row,col)<= threshold && flag[row*cols + col]!=1){
            return true;
        }
        return false;
    }

    public static int getDig(int row , int col){
        int sum = 0 ;
        while(row>0){
            sum += row%10;
            row/=10;
        }
        while(col>0){
            sum += col%10;
            col/=10;
        }
        return sum;
    }

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     * @param root
     * @return
     */
    static StringBuilder res = new StringBuilder();
    public static String Serialize(TreeNode root) {
        if(root == null) return "#!";
        res.append(root.val);
        res.append("!");
        if(root.left != null) {
            Serialize(root.left);
        }else{
            res.append("#!");
        }
        if(root.right != null){
            Serialize(root.right);
        }else{
            res.append("#!");
        }
        return res.toString();
    }
    public static TreeNode Deserialize(String str) {
        String [] strings = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for(String s:strings){
            queue.add(s);
        }
        return DeserializeCore(queue);
    }

    public static TreeNode DeserializeCore(Queue<String> queue){
        String s = queue.poll();
        if(s!=null){
            if(s.equals("#")){
                return null;
            }
            TreeNode head = new TreeNode(Integer.valueOf(s));
            head.left = DeserializeCore(queue);
            head.right = DeserializeCore(queue);
            return head;
        }else{
            return null;
        }
    }

    /**
     * 给定一颗二叉搜索树，请找出其中的第k大的结点。
     *              例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
     * @param pRoot
     * @param k
     * @return
     */

    static List<TreeNode> arrayList = new ArrayList<>();
    public static TreeNode KthNode(TreeNode pRoot, int k){
        mid(pRoot,k);
        System.out.print("aaa");
        if(k<1 || k>arrayList.size()) return null;
        return  arrayList.get(k-1);
    }

    public static List<TreeNode> mid(TreeNode pRoot,int k ){
        if(pRoot == null){
            return null;
        }
        if(arrayList.size() >= k) return arrayList;
        if(pRoot.left != null) mid(pRoot.left,k);
        arrayList.add(pRoot);
        if(pRoot.right !=null) mid(pRoot.right,k);
        return arrayList;
    }

    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     *                      注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * @param pNode
     * @return
     */
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        // jiandan
        if(pNode.right == null && pNode.next.left == pNode) return pNode.next;
        //fuza yixia
        if(pNode.right == null && pNode.next.right == pNode) {
            TreeLinkNode temp = pNode.next;
            while(temp.next!=null && temp != temp.next.left){
                temp = temp.next;
            }
            return temp.next==null ? null : temp.next;
        }
        //zhong
        if(pNode.right !=null){
            TreeLinkNode temp = pNode.right;
            while(temp.left!=null){
                temp = temp.left;
            }
            return temp;
        }
        return null;
    }

    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical(TreeNode pRoot){
       return isSymmetrical(pRoot,pRoot);
    }

    public static boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1==null && pRoot2==null) return true;
        if(pRoot1 == null || pRoot2 == null) return false;
        if(pRoot1.val != pRoot2.val) return false;
        return isSymmetrical(pRoot1.left,pRoot2.right) && isSymmetrical(pRoot1.right,pRoot2.left);
    }

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Queue<TreeNode> arr = new LinkedList<>();
        if(pRoot==null) return arrayLists;
        arr.add(pRoot);
        while(arr.size()!=0){
            ArrayList<Integer> temp = new ArrayList<>();
            int size = arr.size();
            for(int i = 0 ; i<size ; i++){
                TreeNode t = arr.poll();
                if(t.left!=null) arr.add(t.left);
                if(t.right !=null) arr.add(t.right);
                temp.add(t.val);
            }
            arrayLists.add(temp);
        }
        return arrayLists;

    }

    /**
     * 请实现一个函数按照之字形打印二叉树，
     *              即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer> > PrintZhi(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Queue<TreeNode> arr = new LinkedList<>();
        if(pRoot==null) return arrayLists;
        arr.add(pRoot);
        int index = 0 ;
        while(arr.size()!=0){
            ArrayList<Integer> temp = new ArrayList<>();
            int size = arr.size();
            for(int i = 0 ; i<size ; i++){
                TreeNode t = arr.poll();
                if(t.left!=null) arr.add(t.left);
                if(t.right !=null) arr.add(t.right);
                temp.add(t.val);
            }
            arrayLists.add(temp);
        }
        for(int i = 0 ; i<arrayLists.size() ; i++){
            if(i%2!=0){
                reverse(arrayLists.get(i));
            }
        }
        return arrayLists;
    }

    // 好好 看看   arrayList 的特性！！！！！！！！！！！！！！！！！！！！！！！
    public static void reverse(ArrayList<Integer> arrayList){
        int size = arrayList.size();
        for(int i = 0 ,j = size-1 ; i<=j ; i++,j--){
            int start = arrayList.get(i);
            int stop = arrayList.get(j);
            arrayList.remove(i);
            arrayList.add(i, stop);
            arrayList.remove(j);
            arrayList.add(j,start);
        }
    }


    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     *      其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if(A == null || A.length<2) return null;
        int res []= new int[A.length];
        res[0] = A[0];
        for(int i = 1; i<A.length ; i++){
            res[i] = res[i-1] * A[i];
        }
        int tmp = 1;
        for(int i = A.length-1 ; i>0 ;i--){
            res[i] = res[i-1]*tmp;
            tmp *= A[i];
        }
        res[0] = tmp;
        return res;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        return 1;
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        return 1;
    }

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern){
        return false;
    }



    public static void main(String [] args){
//        String string = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
//        char [] chars = string.toCharArray();
//        char[] matrix = {'a','b','c','c','s','f','c','s','e','d','e','e'};
//        char[] str = {'b','c','c','e','d'};
//        int rows = 5;
//        int cols = 8;
//
//        System.out.print(hasPath(matrix, rows, cols, str));

//        System.out.print(movingCount(15,100,1));


//        TreeNode treeNode8 = new TreeNode(8);
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode10 = new TreeNode(10);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode9 = new TreeNode(9);
//        TreeNode treeNode11 = new TreeNode(11);
//        treeNode8.left = treeNode6;
//        treeNode8.right = treeNode10;
//        treeNode6.left = treeNode5;
//        treeNode6.right = treeNode7;
//        treeNode10.left = treeNode9;
//        treeNode10.right = treeNode11;
//        System.out.print(KthNode(treeNode8, 1).val);

//        PrintZhi(treeNode8);

//        ArrayList<Integer> temp = new ArrayList<>();
//        temp.add(0);
//        temp.add(1);
//        temp.add(2);
//        temp.add(3);
//        temp.add(4);
//        temp.add(5);
//        temp.add(6);
//
//




        int arr[] = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};

        minNumberInRotateArray(arr);










//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            int monsterCount = scanner.nextInt();
//            int initial = scanner.nextInt();
//
//            int [] a = new int[monsterCount];
//            for(int i =0 ;i<monsterCount ; i++){
//                a[i] = scanner.nextInt();
//            }
//            for(int i = 0 ; i<a.length ; i++){
//                if(initial >= a[i]){
//                    initial += a[i];
//                }else{
//                    initial += getMaxPub(a[i],initial);
//                }
//            }
//            System.out.println(initial);
//        }
//        scanner.close();
//
//
//        for(int i = 0 ; i<100 ; i++){
//            System.out.println((int)(Math.random()*5));
//        }






    }

}
