package leetCode.L32;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wq on 16-3-2.
 */
public class SolutionBinaryTreePreorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root==null)return list;
        list.add(root.val);
//        stack.push(root);
        if(root.left!=null){
            preorderTraversal(root.left);
        }
        if(root.right!=null){
            preorderTraversal(root.right);
        }

        return list;



    }
// 1 2 4 9 3 6 7 13

    public static void main(String args[]){
        SolutionBinaryTreePreorderTraversal aa = new SolutionBinaryTreePreorderTraversal();
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
        List<Integer>  ll  =  aa.preorderTraversal(node1);
        for(int i : ll){
            System.out.println(i);
        }
    }
}

//        Stack<TreeNode> stack = new Stack<>();
//        if(root ==null){
//            return list;
//        }
//
//        stack.push(root);
//        TreeNode temp ;
//        while(!stack.empty()){
//            temp = stack.pop();
//            list.add(temp.val);
//            if(temp.right != null){
//                stack.push(temp.right);
//            }
//            if(temp.left !=null){
//                stack.push(temp.left);
//            }
//        }
//        return list;


//                       1
//                    2      3
//                4        6    7
//                  9          13

//     9 4 2 6 13 7 3 1