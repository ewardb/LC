package leetCode.L228;

/**
 * Created by wq on 16-2-25.
 */
public class SolutionDeleteNodeInLink {
    public void deleteNode(ListNode node) {
        ListNode n1 = null;
        n1 = node.next ;
        if(n1 != null){
            node.val = n1.val ;
            node.next = n1.next ;

        }
    }
}
//        n1          n1.next
//node node.next node.next.next
