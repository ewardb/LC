package leetCode.L54;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wq on 16-5-4.
 * inorder序
 * 先序   根左右
 * 中序   左根右
 * 後續   左右根
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SolutionBinaryTreeInorderTraversal {
    List<Integer> preorderlist = new ArrayList<>();
    List<Integer> inorderlist = new ArrayList<>();
    List<Integer> postorderlist = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root){
        if(root !=null){
            preorderlist.add(root.val);
            if(root.left !=null){
                preorderTraversal(root.left);
            }
            if(root.right!=null){
                preorderTraversal(root.right);
            }
        }
        return preorderlist;
    }

    public List<Integer> inorderTraversal(TreeNode root){
            if(root !=null){
                if(root.left !=null){
                    inorderTraversal(root.left);
                }
                inorderlist.add(root.val);
                if(root.right !=null){
                    inorderTraversal(root.right);
                }
            }
            return inorderlist;
    }

    public List<Integer> postorderTraversal(TreeNode root){
        if(root !=null){
            if(root.left !=null){
                postorderTraversal(root.left);
            }
            if(root.right !=null){
                postorderTraversal(root.right);
            }
            postorderlist.add(root.val);
        }
        return postorderlist;
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
        List<Integer> ll = aa.inorderTraversal(node1);
        for(int i : ll){
            System.out.println(i);
        }
    }
}

//                       1
//                    2      3
//                4        6    7
//                  9          13
