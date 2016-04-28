package leetCode;

/**
 * Created by wq on 16-1-26.
 */

public class SolutionMaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
//        int max = 0 ;
//        if(root == null ) {return 0 ;}
//        Stack<TreeNode> path = new Stack<>();
//        Stack<Integer> sub = new Stack<>();
//        path.push(root);
//        sub.push(1);
//        while(!path.isEmpty()){
//            TreeNode temp = path.pop();
//            int tempVal = sub.pop();
//            if(temp.left == null && temp.right == null ) {
//                max = Math.max(max,tempVal);
//            }else{
//                if(temp.left != null){
//                    path.push(temp.left);
//                    sub.push(tempVal+1);
//                }
//                if(temp.right != null){
//                    path.push(temp.right);
//                    sub.push(tempVal+1);
//                }
//            }
//        }
//        return max;
        if(root == null){ return 0 ;}
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

//    public static void main(String args[]){
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(-1);
//        TreeNode node10 = new TreeNode(9);
//        node1.left = node2 ;
//        node1.right = node3 ;
//        node2.left = node4 ;
//        node2.right = node5 ;
//        node3.left = node6;
//        node4.left = node8 ;
//        node6.left = node10;
//        System.out.println(maxDepth(node1));
//    }
}
