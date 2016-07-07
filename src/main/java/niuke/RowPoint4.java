package niuke;

import java.util.ArrayList;
import java.util.*;

import static net.mindview.util.Print.*;
/**
 * Created by wq on 16-7-1.
 */
public class RowPoint4 {
    /**
     * 明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
     * @param sum
     * @return
     */

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>>  arrayLists = new ArrayList<>();
        int min = 1;
        int max = 2;
        int total = min + max ;
        while(min<=sum/2){
            if(total<sum){
                max++;
                total += max;
            }else if(total > sum ){
                total -= min++;
            }else{
                ArrayList arrayList = new ArrayList();
                for(int i = min ; i<=max ; i++){
                    arrayList.add(i);
                }
                arrayLists.add(arrayList);
                max++;
                total+=max;
            }
        }
        return arrayLists;
    }


    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     * @param array
     * @param sum
     * @return
     */

    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array == null || array.length == 0) return arrayList;

        int indexStart = 0;
        int start = array[indexStart];
        int indexStop = array.length -1;
        int stop = array[indexStop];
        int total = start + stop;
        while(total != sum){
            if(indexStart<indexStop){
                if(total>sum){
                    indexStop -- ;
                    total = total - stop + array[indexStop];
                    stop = array[indexStop];
                }else{
                    indexStart++;
                    total = total - start + array[indexStart];
                    start = array[indexStart];
                }
            }else{
                return arrayList;
            }
        }
        if(total == sum){
            arrayList.add(start);
            arrayList.add(stop);
        }
        return arrayList;
    }


    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
     * 是不是很简单？OK，搞定它！
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str,int n) {
        if(str == null || str.length()==0 || str.length()<n){
            return str;
        }
        char [] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        int index = 0 ;
        for(int i = n ; i<chars.length ; i++){
            sb.append(chars[i]);
        }
        for(int i = 0 ; i<n ; i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }


    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
     * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
     * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        if(str==null ){
            return str;
        }
        print("bbb");
        StringBuffer sb = new StringBuffer();
        String [] strs = str.split(" ");
        print("aaa");
        if(strs.length<=1) return str;
        for(int i = strs.length-1 ; i>0 ; i--){
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }

    /**
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
     * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
     * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
     * “So Lucky!”。LL决定去买体育彩票啦。
     * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
     * @param numbers
     * @return
     */
    public static boolean isContinuous(int [] numbers) {
        if(numbers ==null || numbers.length ==0 ){
            return false;
        }
        int zeroNum = 0;
        Arrays.sort(numbers);
        while(numbers[zeroNum]==0){
            zeroNum++;
        }
        if(zeroNum==4){
            return true;
        }
        int min = numbers[zeroNum];
        for(int i = zeroNum+1 ; i<numbers.length ; i++){
            while(numbers[i] != min +1){
                if(zeroNum!=0){
                    zeroNum--;
                    min++;
                }else{
                    return false;
                }
            }
            min = numbers[i];
        }
        print("aaa");
        return true;
    }


    /**
     * 每年六一儿童节,NowCoder都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
     * HF作为NowCoder的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
     * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
     * 每次喊到m的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
     * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
     * 可以不用表演,并且拿到NowCoder名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
     * 请你试着想下,哪个小朋友会得到这份礼品呢？
     * @param n
     * @param m
     * @return
     */

    public static int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1){
            return n;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0 ; i<n ; i++){
            queue.add(i);
        }
        int index = 1 ;
        int put = 0 ;
        while(!queue.isEmpty()){
            while(index!=m){
                queue.add(queue.poll());
                index++;
            }
            put = queue.poll();
            print(put);
            index=1;
        }

        return put;
    }


    /**
     * 一个链表中包含环，请找出该链表的环的入口结点。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        if(pHead == null){
            return null;
        }
        ListNode ru = pHead;
        while(!set.contains(ru)){
            set.add(ru);
            if(ru.next != null){
                ru = ru.next;
            }else{
                return null;
            }
        }
        return ru;
//        if(pHead == null || pHead.next == null)
//            return null;
//        ListNode p1 = pHead;
//        ListNode p2 = pHead;
//        while(p2 != null && p2.next != null ){
//            p1 = p1.next;
//            p2 = p2.next.next;
//            if(p1 == p2){
//                p2 = pHead;
//                while(p1 != p2){
//                    p1 = p1.next;
//                    p2 = p2.next;
//                }
//                if(p1 == p2)
//                    return p1;
//            }
//        }
//        return null;
    }


    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     * @param str
     * @param pattern
     * @return
     */


    public boolean match(char[] str, char[] pattern){
        int indexStr = 0 ;
        int indexPattern = 0;
        if(str == null || pattern == null){
            return false;
        }
        return matchCore(str,0,pattern,0);
    }

    public boolean matchCore(char [] str , int indexStr , char [] pattern , int indexPattern){
        if(str.length == indexStr && pattern.length == indexPattern) return true;

        if(str.length == indexStr && pattern.length !=indexPattern) return false;

        return true;
    }

    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * @param str
     * @return
     */

    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-')
            fuhao = 1;
        int sum = 0;
        for (int i = fuhao; i < a.length; i++)
        {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;


    }

    public int StrtoINt(String str){
        if(str== null || str.equals("")){
            return 0 ;
        }
        char [] a = str.toCharArray();
        int fuhao = 0 ;
        if(a[0] == '-'){
            fuhao = 1;
        }
        int sum = 0 ;
        for(int i = fuhao ;i<a.length ; i++){
            if(a[i]=='+') continue;
            if(a[i]<48 || a[i]>57){
                return 0 ;
            }
            sum = sum*10 + a[i]-48;

        }
        return fuhao==0 ? sum : sum * -1;
    }


    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,
    //                                                                          so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length<=1) return false;
        int [] a = new int[length];
        for(int i : numbers){
            a[i]++;
        }
        int index = 0;
        int indexDup = 0 ;
        while(index!=length){
            if(a[index]>1){
                duplication[indexDup] = index;
                return true;
            }
            index++;
        }
        return false;

//        duplication[0] = -1;
//        if(length<=1)
//            return false;
//        int[] flag = new int[length+1];
//
//        for(int i=0;i<length;i++) {
//            ++flag[numbers[i]];
//            if (flag[numbers[i]] >= 2) {
//                duplication[0] = numbers[i];
//                return true;
//            }
//        }
//        return false;
    }
    HashMap<Character, Integer> map=new HashMap();
    ArrayList<Character> list=new ArrayList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c='#';
        for(char key : list){
            if(map.get(key)==1){
                c=key;
                break;
            }
        }
        return c;
    }


    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     *              例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null||pHead.next == null) return pHead;
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;
        while(p != null && p.next !=null){
            if(p.val == p.next.val){
                int val = p.val;
                while(p!=null && p.val ==val){
                    p=p.next;
                }
                last.next = p;
            }else{
                last = p ;
                p = p.next;
            }
        }
        return first.next;
    }






    public static ListNode deleteDuplication1(ListNode pHead)
    {
        ListNode first = new ListNode(-1);//设置一个trick

        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p!= null&&p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        print('a');
        return first.next;

    }


    public static void main(String args[]){
//        FindContinuousSequence(15);
        int [] arr = {1,1,0,7,0};
//        int sum = 1111;
//        FindNumbersWithSum(arr,sum);
//        System.out.print(LeftRotateString("abcXYZdef", 3));
//        ReverseSentence(" ");
//        isContinuous(arr);
//        int s = LastRemaining_Solution(5,3);
//        print(s);
//        char [] chars = {'1','4'};
//        System.out.println(chars[0]-0);
//        System.out.print(chars[1]-0);
//        int [] arrr = {2,4,2,1,4};
//        int [] arrrr = new int [5];
//        duplicate(arrr,5,arrrr);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        deleteDuplication1(node1);
    }
}
