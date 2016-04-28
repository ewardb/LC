package leetCode.L32;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wq on 16-3-2.
 */
//                       1
//                    2      3
//                4        6    7
//                  9          13
//     1 3 7 13 6 2 4 9
//     9 4 2 6 13 7 3 1
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    后续遍历  左右根！
public class SolutionBinaryTreeInorderTraversal {
    List<Integer> list =  new ArrayList<>();



    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if(root==null) return list;

        stack.push(root);
        TreeNode temp ;
//        while(!stack.empty()){
//            temp = stack.pop();
//            list.add(temp.val);
//            if(temp.left!=null){
//                stack.push(temp.left);
//            }
//            if(temp.right!=null){
//                stack.push(temp.right);
//            }
//        }

        while(root.right!=null){
            stack.push(root.right);

        }




        return list;

    }
    public static void main(String args[]){
        SolutionBinaryTreeInorderTraversal aa = new SolutionBinaryTreeInorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node13 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node6;
        node3.right = node7;
        node4.right = node9;
        node7.right = node13;
        List<Integer>  ll  =  aa.inorderTraversal(node1);
        for(int i : ll){
            System.out.println(i);
        }
    }
}
