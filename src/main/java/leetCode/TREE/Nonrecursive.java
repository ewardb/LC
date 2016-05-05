package leetCode.TREE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wq on 16-5-5.
 */


public class Nonrecursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.empty()){
            TreeNode r = stack.pop();
            list.add(r.val);

            if(r.right !=null){
                stack.push(r.right);
            }
            if(r.left !=null){
                stack.push(r.left);
            }
        }

        return list;
    }




    public List<Integer> inorderTraversal(TreeNode root){  // 左 根 右
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        while(root !=null || !stack.empty()){
            while(root !=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty()){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root ==null) return list;
        stack1.push(root);
        while(!stack1.empty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left !=null) stack1.push(root.left);
            if(root.right !=null) stack1.push(root.right);
        }
        while(!stack2.empty()){
            root = stack2.pop();
            list.add(root.val);
        }
        return list;
    }


    public static void main(String args[]){
        Nonrecursive aa = new Nonrecursive();
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        node2.left = node3;
        node3.left = node1;
        List<Integer> ll = aa.inorderTraversal(node2);
        for(int i : ll){
            System.out.println(i);
        }
}

}
