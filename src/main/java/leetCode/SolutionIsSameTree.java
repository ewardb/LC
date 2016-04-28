package leetCode;

/**
 * Created by wq on 16-2-25.
 */
public class SolutionIsSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
//        Stack<TreeNode> path1 = new Stack<>();
//        Stack<TreeNode> path2 = new Stack<>();
//        if(p == null ^ q == null){
//            return false ;
//        }
//        if(p!=null && q!=null) {
//            path1.push(p);
//            path2.push(q);
//        }
//        while(!path1.isEmpty() && !path2.isEmpty()){
//            TreeNode node1 = path1.pop();
//            TreeNode node2 = path2.pop();
//            if(node1.val != node2.val){
//                System.out.print("f");
//                return false ;
//            }else if(node1.right == null && node2.right != null){
//                System.out.print("f");
//                return false;
//            }else if(node1.left == null && node2.left != null) {
//                System.out.print("f");
//                return false;
//            }else if(node1.right != null && node2.right == null){
//                System.out.print("f");
//                return false;
//            }else if(node1.left != null && node2.left == null){
//                System.out.print("f");
//                return false;
//            }else{
//                if(node1.left !=null && node2.left !=null){
//                    path1.push(node1.left);
//                    path2.push(node2.left);
//                }
//                if(node1.right !=null && node2.right !=null){
//                    path1.push(node1.right);
//                    path2.push(node2.right);
//                }
//
//            }
//        }
//        System.out.print("t");
//        return true;

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!牛叉叉  ！！  看不懂


//        if(p==null && q==null) {
//            return true;
//        }
//
//        if(p==null || q==null) {
//            return false;
//        }
//
//        if(p.val == q.val) {
//            boolean left = isSameTree(p.left, q.left);
//            boolean right = isSameTree(p.right, q.right);
//            return (left & right);
//        }
//
//        return false;


        if(p == null && q == null){
            return true ;
        }
        if(p!=null && q != null){
            return (p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right ,q.right));
        }
        return false ;















    }

    public static void main(String args[]){
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(0);
        TreeNode leaf1 = new TreeNode(5);
        TreeNode leaf2 = new TreeNode(5);
        TreeNode leaf3 = new TreeNode(8);
        TreeNode leaf4 = new TreeNode(8);
        root1.left = leaf1 ;
        root2.left = leaf2 ;
        leaf1.left = leaf3;
        leaf2.left = leaf4;
        isSameTree(root1,root2);
    }
}
