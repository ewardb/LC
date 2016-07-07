package niuke;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * Created by wq on 16-6-13.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}



public class RowPoint3 {

    /**
     * 输入一颗二叉树和一个整数,打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * @param root
     * @param target
     * @return
     */
    static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        if(root!=null){
            return FindPath1(root,target,0,arrayList1);
        }else{
            return arrayLists;
        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target,int sum,ArrayList arrayLi) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(arrayLi);
        if(root == null){
            return null;
        }
        arrayList.add(root.val);
        sum+=root.val;
        if(root.left !=null) FindPath1(root.left,target,sum,arrayList);
        if(root.right !=null) FindPath1(root.right,target,sum,arrayList);
        if(root.left == null && root.right ==null){

            if(sum == target){
                arrayLists.add(arrayList);
            }
        }
        return arrayLists;
    }

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
     * @param pHead
     * @return
     */
    public static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return pHead;
        }
        HashMap<RandomListNode,RandomListNode> hashMap = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode temp =pHead;
        RandomListNode head = null;
        RandomListNode cur = head;
        while(temp != null){
            RandomListNode c = new RandomListNode(temp.label);
            if(head == null){
                head = c ;
            }else{
                cur.next = c ;
            }
            hashMap.put(temp,c);
            cur = c;
            temp = temp.next;
        }

        temp =pHead;
        cur = head;

        while(temp != null){
            RandomListNode tt = hashMap.get(temp.random);
            cur.random = tt;
            cur = cur.next;
            temp = temp.next;
        }
        return head;
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null ){
            return pRootOfTree;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(pRootOfTree,queue);
        if(queue.isEmpty()) return pRootOfTree;
        TreeNode head = queue.poll();
        TreeNode temp = head ;
        temp.left = null;
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            temp.right = cur;
            temp.left = temp;
            temp = cur;
        }
        temp.right = null;
        return head;

    }

//    public TreeNode Convert1(TreeNode pRootOfTree) {
//        if(pRootOfTree == null ){
//            return pRootOfTree;
//        }
//        if(pRootOfTree.left != null){
//            Convert(pRootOfTree.left);
//        }
//        pRootOfTree.left =  find(pRootOfTree.left,"max");
//        pRootOfTree.right = find(pRootOfTree.right,"min")==null ? pRootOfTree : find(pRootOfTree,"min");
//        if(pRootOfTree.right != null){
//            Convert(pRootOfTree.right);
//        }
//
//
//    }
//
//    public TreeNode find(TreeNode treeNode , String str){
//        if(treeNode == null){
//            return treeNode;
//        }
//        if(str.equals("max")){
//            TreeNode temp = treeNode;
//            while(temp.right != null){
//                temp = temp.right;
//            }
//            return temp;
//        }else if(str.equals("min")){
//            TreeNode temp = treeNode;
//            while(temp.left != null){
//                temp = temp.left;
//            }
//            return temp;
//        }else{
//            return treeNode;
//        }
//    }


//}

    public TreeNode Convert2(TreeNode pRootOfTree) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        if(pRootOfTree==null)return null;
//        if(pRootOfTree.left==null&&pRootOfTree.right==null)
//            return pRootOfTree;
//        TreeNode left=Convert(pRootOfTree.left);
//        TreeNode p=left;
//        while(p!=null&&p.right!=null) {
//            p=p.right;
//        }
//        if(left!=null) {
//            p.right=pRootOfTree;
//            pRootOfTree.left=p;
//        }
//        TreeNode right=Convert(pRootOfTree.right);
//        if(right!=null) {
//            pRootOfTree.right=right;
//            right.left=pRootOfTree;
//        }
//        return  left!=null?left:pRootOfTree;



        if(pRootOfTree == null) return null;
        if(pRootOfTree.left == null && pRootOfTree.right ==null){
            return pRootOfTree;
        }
        TreeNode left = Convert2(pRootOfTree.left);
        TreeNode p = left ;
        while(p!=null && p.right !=null){
            p = p.right;
        }
        if(left!=null){
            p.right = pRootOfTree;
            pRootOfTree.left = p ;
        }
        TreeNode right = Convert2(pRootOfTree.right);
        if(right !=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left!=null ? left:pRootOfTree;





    }


    public void inOrderToQueue(TreeNode root,Queue<TreeNode> queue){
        if(root == null){
            return ;
        }
        if(root != null) inOrderToQueue(root.left,queue);
        queue.add(root);
        if(root != null) inOrderToQueue(root.right,queue);
    }


    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
     * 输入描述:
     *          输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     * @param str
     * @return
     */

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>() ;
        if(str==null || str.length()==0) { return result ; }

        char[] chars = str.toCharArray() ;
        TreeSet<String> temp = new TreeSet<>() ;
        Permutation(chars, 0, temp);
        result.addAll(temp) ;
        return result ;
    }
    public static void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if(chars==null || chars.length==0 || begin<0 || begin>chars.length-1) { return ; }
        System.out.print(begin);
        System.out.println(chars);
        if(begin == chars.length-1) {
            result.add(String.valueOf(chars)) ;
        }else {
            for(int i=begin ; i<=chars.length-1 ; i++) {
                swap(chars, begin, i) ;
                System.out.print(begin + " " + i);
                System.out.println(chars);

                Permutation(chars, begin + 1, result);

                swap(chars, begin, i) ;
                System.out.print(begin + " " + i);
                System.out.println(chars);
            }
        }
    }

    public static void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }


    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int cur = array[0];
        int count = 0 ;
        for(int i = 1 ; i<array.length ; i++){
            if(count == 0){
                cur = array[i];
                count++;
            }else if(cur == array[i]){
                count++;
            }else{
                count--;
            }
        }

        int times = 0;
        for(int i = 0 ; i!=array.length ; i++){
            if(cur == array[i]){
                times++;
            }
        }
        if(times>=array.length/2){
            return cur;
        }else{
            return 0;
        }
    }


    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input ==null || input.length ==0 ){
            return arrayList;
        }
        if(input.length<k){
            for(int i = 0; i< input.length ; i++){
                arrayList.add(input[i]);
            }
            print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            return arrayList;
        }
        int [] heap = new int[k];
        for(int i = 0 ; i<k ;i++){
            heap[i] = input[i];
        }
        heap = getHeapArr(heap);
        for(int i = k ; i<input.length ; i++){
            if(heap[0]>input[i]){
                heap[0] = input[i];
                replateHeapElement(heap);
            }
        }
        for(int i : heap){
            arrayList.add(i);
        }
        print("aaaa");
        return arrayList;
    }

    public static int [] getHeapArr(int [] arr){
        int index = (arr.length)>>1;
        for(int i= index-1 ; i>=0 ; i--){
            int p = i;
            while(p <= arr.length/2){
                int left = 2*p +1;
                int right = 2*p +2;
                int largest = p ;
                if(arr[left] > arr[p]){
                    largest = left;
                }
                if(right <arr.length && arr[right]  > arr[largest]){
                    largest = right;
                }
                if(largest != p){
                    swap(arr,largest,p);
                }
                p = largest;
            }
        }
        return arr;
    }

    public static void replateHeapElement(int [] heap){
        int index = 0;
        int left = index*2 +1;
        int right = index*2+2;
        int largest = index ;
        while(left < heap.length){
            if(heap[left] > heap[index]){
                largest = left;
            }
            if(right < heap.length && heap[right] > heap[largest]){
                largest = right;
            }
            if(largest != index){
                swap(heap,largest,index);
            }else{
                break;
            }
            index = largest;
            left = index*2 +1;
            right = index*2 +2;

        }
    }
    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
    }

    /**
     * 连续子数组的最大和
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0 ){
            return 0 ;
        }
        int sum = array[0] ;
        int max = array[0] ;
        for(int i = 1 ; i<array.length ; i++){
            sum += array[i];
            if(sum > max){
                max = sum ;
            }else if(sum <0){
                sum = 0;
            }

        }
        return max;
    }


    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了.
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n==0 )return 0;
        int sum = 0 ;
        for(int i= 1 ; i<=n ; i++){
            sum += getOne(i);
        }
        return sum ;
    }

    public int getOne(int i){
        int index = 0 ;
        while(i!=0){
            int s = i%10;
            if(s==1){
                index++;
            }
            i/=10;
        }
        return index;
    }


    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *          例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */

    public static String PrintMinNumber(int [] numbers) {
        List<Integer> list=new ArrayList<Integer>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        // TODO Auto-generated method stub
                        String str1=o1+""+o2;
                        String str2=o2+""+o1;
                        return str1.compareTo(str2);
                    }
            });
        StringBuilder sb=new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }






    public static String PrintMinNumber1(int [] numbers) {  //you wen ti !!!
        if(numbers == null || numbers.length ==0 ){
            return "";
        }
        if(numbers.length ==1) return String.valueOf(numbers[0]);
        int maxIndex = 0 ;
        for(int i = 1 ; i<numbers.length ; i++){
            if(numbers[i]>numbers[maxIndex]){
                maxIndex = i;
            }
        }
        int bi = getBit(numbers[maxIndex]);
        int [] textArr = numbers.clone();
        for(int i = 0; i<numbers.length ; i++){
            int ge = getGe(textArr[i]);
            while(bi-getBit(textArr[i])>0){
                textArr[i] = textArr[i]*10+ge;
            }
        }
        int o[] = new int[numbers.length];
        Map<Integer,ArrayList<Integer>> treeMap = new TreeMap<>();
        for(int i= 0 ; i<textArr.length ; i++){
            if(treeMap.containsKey(textArr[i])){
                treeMap.get(textArr[i]).add(i);
            }else{
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                treeMap.put(textArr[i],arrayList);
            }
        }
//        Arrays.sort(textArr);
        StringBuffer sb = new StringBuffer();
        Set<Integer> set =  treeMap.keySet();
        for(int i : set){
            for(int j :treeMap.get(i)){
                sb.append(numbers[j]);
            }
        }
        return sb.toString();
    }

    public static int getBit(int i){
        int bit = 1;
        int bi = 0;
        while(bit <= i){
            bit*=10;
            bi++;
        }
        return bi;
    }

    public static int getGe(int i){
        return i%10;
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index==0)return 0;
        ArrayList<Integer> res=new ArrayList<Integer>();
        res.add(1);
        int n2 = 0 ;
        int n3 = 0 ;;
        int n5 = 0 ;
        while(res.size() < index){
            int m2 = res.get(n2)*2;
            int m3 = res.get(n3)*3;
            int m5 = res.get(n5)*5;
            int min = Math.min(m2,Math.min(m3,m5));
            res.add(min);
            if(min==m2) n2++;
            if(min==m3) n3++;
            if(min==m5) n5++;

        }
        return res.get(res.size()-1);
    }


    /**
     * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1。位置索引从0开始
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        if(str==null || str.length() == 0) return -1;
        char [] chars = str.toCharArray();
        int length = chars.length;
        Queue<Character> queue = new LinkedList<>();
        Map<Character,Integer> hashMap = new LinkedHashMap<>();
        for(int i = 0 ; i<length ; i++){
            if(!queue.contains(chars[i])){
                queue.add(chars[i]);
            }
            if(hashMap.containsKey(chars[i])){
                hashMap.put(chars[i],hashMap.get(chars[i]) +1);
            }else{
                hashMap.put(chars[i],1);
            }
        }
        char re = ' ';
        boolean reChange = false;
        boolean flag = true;
        while( flag && !queue.isEmpty()){
            char s = queue.poll();
            if(hashMap.get(s)==1){
                flag = false;
                re = s;
                reChange = true;
            }
        }
        if(reChange == true){
            int index = 0 ;
            boolean falg = true;
            while(falg && index<length){
                if(chars[index++] == re){
                    falg = false;
                }
            }
            if(index<=length){

                return index-1;
            }else{
                return -1;
            }
        }
        return -1;
    }



    public static int FirstNotRepeatingChar1(String str) {

        if(str == null || str.length()==0){
            return -1;
        }
        int [] arr = new int[256];
        char [] chars = str.toCharArray();
        for(char i :chars){
            arr[i] +=1;
        }

        for(int i = 0 ; i<chars.length ; i++){
             if(arr[chars[i]] == 1){
                 return i;
             }
        }

        return -1;
    }


    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2==null){
            return null;
        }
        int length1 = 0 ;
        int length2 = 0 ;
        ListNode listNode1 = pHead1;
        ListNode listNode2 = pHead2;
        while(listNode1 !=null){
            length1++;
            listNode1 =listNode1.next;
        }
        while(listNode2 !=null){
            length2++;
            listNode2 = listNode2.next;
        }
        int ss = Math.abs(length1-length2);
        listNode1 = pHead1;
        listNode2 = pHead2;
        boolean flag = false;
        if(length1 > length2) {
            for (int i = 0; i < ss; i++) {
                listNode1 = listNode1.next;
            }
            while(listNode1!=listNode2){
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }
        }else{
            for (int i = 0; i < ss; i++) {
                listNode2 = listNode2.next;
            }
            while(listNode1!=listNode2){
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }
        }

        if(listNode1==listNode2 ){
            return listNode1;
        }else{
            return null;
        }
    }


    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */

    public static int GetNumberOfK(int [] array , int k) {
        int start = 0 ;
        int stop = array.length-1 ;
        int mid = (start+stop)/2;
        int get = start;
        boolean flag = true;
        while(flag &&start<=stop ){
            if(array[mid]>k){
                stop = mid-1;
                mid = (start+stop)/2;
            }else if(array[mid]<k){
                start = mid+1;
                mid = (start+stop)/2;
            }else{
                get = mid;
                flag = false;
            }
        }
        if(flag == true){
            return 0;
        }
        int sum = 0;
        int leftIndex = mid;
        int rightIndex = mid;
        while(leftIndex >=0 && array[leftIndex--] == k){
            sum++;
        }
        while(rightIndex < array.length && array[rightIndex++] == k){
            sum++;
        }
        return sum-1;
    }


    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     * @param pRoot
     * @return
     */
    public static int TreeDepth(TreeNode pRoot) {
        if(pRoot == null){
            return 0 ;
        }
        return 1+Math.max(TreeDepth(pRoot.left),TreeDepth(pRoot.right));
    }

    /**
     * 平衡二叉樹
     * @param pRoot
     * @return
     */
    public static boolean isBalance(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        boolean [] res = new boolean[1] ;
        res[0] = true;
        getHigh(pRoot,1,res);
        return res[0];
    }


    public static int getHigh(TreeNode node , int depth , boolean [] booleans){
        if(node == null){
            return depth;
        }

        int left = getHigh(node.left,depth+1,booleans);
        if(!booleans[0]){
            return depth;
        }
        int right = getHigh(node.right,depth+1,booleans);
        if(!booleans[0]){
            return depth;
        }
        if(Math.abs(left-right)>1){
            booleans[0] = false;
        }
        return Math.max(left,right);
    }


    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0) return ;
        int a= array[0] ;
        for(int i = 1 ; i<array.length ; i++){
            a^=array[i];
        }
        int s = indexLastOne(a);
        for(int i =0 ; i<array.length ; i++){
            if((s&array[i]) != s){
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];
            }

        }
    }

    public int indexLastOne(int a){
        int temp = 1;
        while((a&temp) !=temp){
            temp= temp<<1;
        }
        return temp;
    }


    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，
     *          则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {


        return 1;
    }




    public static void main(String args[]){
        int [] arr = {1,2,3,4,4,4,4,5,5,5,6,6};

//        print(GetNumberOfK(arr,19));
//        TreeNode treeNode10 = new TreeNode(10);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode12 = new TreeNode(12);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode9 = new TreeNode(9);
//        treeNode10.left = treeNode5;
//        treeNode10.right = treeNode12;
//        treeNode5.left = treeNode4;
//        treeNode5.right = treeNode7;
//        treeNode4.left = treeNode9;
        print(TreeDepth(null));
    }
}
//TreeNode treeNode10 = new TreeNode(10);
//TreeNode treeNode5 = new TreeNode(5);
//TreeNode treeNode12 = new TreeNode(12);
//TreeNode treeNode4 = new TreeNode(4);
//TreeNode treeNode7 = new TreeNode(7);
//treeNode10.left = treeNode5;
//        treeNode10.right = treeNode12;
//        treeNode5.left = treeNode4;
//        treeNode5.right = treeNode7;
//        print(FindPath(treeNode10, 15));
//        print("hahahaha");
//        int [] a = {2,8,7,1,3,5,6,4};
//        Arrays.sort(a);
//        Permutation("abc");


//        GetLeastNumbers_Solution(arr,5);
//        int  i=0;
//        i= ++i;
//        print(i);
//        i++;
//        print(i);
//        int [] ss= {1,1,111,11};
//        print(PrintMinNumber(ss));
//        print(GetUglyNumber_Solution(5));

//        long start1 = System.currentTimeMillis();
//        print(FirstNotRepeatingChar1("aflkdjlkdfjkladsjadklfjdalkfjadhcdejlasdjflasdjfjddl;jkfasklfjdfladsklfjdklfjasdklfasdjkljljlksdjfklasdjfljf"));
//        long stop1 = System.currentTimeMillis();
//        print(stop1-start1);


//
//ListNode node1 = new ListNode(1);
//ListNode node2 = new ListNode(2);
//ListNode node3 = new ListNode(3);
//ListNode node4 = new ListNode(4);
//ListNode node5 = new ListNode(5);
//ListNode node6 = new ListNode(6);
//ListNode node7 = new ListNode(7);
//
//
//
//ListNode node8 = new ListNode(8);
//ListNode node9 = new ListNode(9);
//ListNode node10 = new ListNode(10);
//node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//
//        node8.next = node9;
//        node9.next = node10;
//        node10.next = node5;
//        System.out.println(FindFirstCommonNode(node1,node8));