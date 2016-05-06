package leetCode.linkedList;

/**
 * Created by wq on 16-5-6.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}



public class SolutionReverseList {
    public static ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode p = head;
        ListNode q = head.next;

        while(q!=null){
            head.next = null;
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;

//        ListNode prev = null;
//
//        while(head !=null){
//            ListNode next = head.next;
//            head.next = prev;
//            prev = head;
//            head = next;
//        }
//
//        return prev;


    }


    public static void main(String args[]){
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(3);
        root1.next = root2;
        root2.next = root3;
        ListNode f = reverseList(root1);
        while(f!=null){
            System.out.println(f.val);
            f = f.next;
        }
    }
}
