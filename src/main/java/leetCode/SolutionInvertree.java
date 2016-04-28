package leetCode;

/**
 * Created by wq on 16-2-24.
 */
public class SolutionInvertree {
    public static TreeNode invertTree(TreeNode root) {
//        if(root == null) {
//            return root;
//        }
//        Stack<TreeNode> stack = new Stack<>();
////        Stack<Integer> sub = new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode node ;
//            TreeNode pop = stack.pop();
//            if(null != pop.left && null != pop.right){
//                node = pop.left ;
//                pop.left = pop.right;
//                pop.right = node ;
//                stack.push(pop.right);
//                stack.push(pop.left);
//            }else if(null != pop.left && null == pop.right){
//                pop.right = pop.left;
//                pop.left = null;
//                stack.push(pop.right);
//            }else if(null == pop.left && null != pop.right){
//                pop.left = pop.right;
//                pop.right = null;
//                stack.push(pop.left);
//            }else{
//
//            }
//
//        }
//        return root;


        if(root ==null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp ;

        invertTree(root.left);
        invertTree(root.right);

        return root;




    }

    public static void main(String args[]){
        invertTree(new TreeNode(3));
    }
}
