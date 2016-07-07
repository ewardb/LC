package niuke.stackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by wq on 16-6-1.
 */
public class MaxTree {
    public Node getMaxTree(int [] arr){
        Node head=null;
        Node [] nodes = new Node[arr.length];
        for(int i = 0 ; i<arr.length ; i++){
            nodes[i] = new Node(arr[i]);
        }

        HashMap<Node,Node> lBig = new HashMap<>();
        HashMap<Node,Node> rBig = new HashMap<>();
        Stack<Node> stack = new Stack<Node>();

        for(int i = 0 ; i<nodes.length ;i++){
            Node curNode = nodes[i];
            while((!stack.isEmpty() && stack.peek().value < curNode.value)){
                popStackSetMap(stack,lBig);
            }
            stack.push(curNode);
        }

        while(!stack.empty()){
            popStackSetMap(stack,lBig);
        }

        for(int i = nodes.length-1 ; i>=0 ;i--){
            Node curNode = nodes[i];
            while((!stack.isEmpty() && stack.peek().value < curNode.value)){
                popStackSetMap(stack,rBig);
            }
            stack.push(curNode);
        }

        while(!stack.isEmpty()){
            popStackSetMap(stack,rBig);
        }

        for(int i =0 ;i<nodes.length ; i++){
            Node curNode = nodes[i];
            Node left = lBig.get(curNode);
            Node right = rBig.get(curNode);
            if(left == null && right == null){
                head = curNode;
            }else if(left ==null){
                if(right.left ==null){
                    right.left = curNode;
                }else{
                    right.right = curNode;
                }
            }else if(right == null){
                if(left.left ==null){
                    left.left = curNode;
                }else{
                    left.right = curNode;
                }
            }else{
                Node parent = left.value < right.value ? left : right;
                if(parent.left == null){
                    parent.left = curNode;
                }else{
                    parent.right = curNode;
                }
            }
        }
        return head;
    }


    public void popStackSetMap(Stack<Node> stack , HashMap<Node,Node> map){
        Node popNode  = stack.pop();
        if(stack.isEmpty()){
            map.put(popNode,null);
        }else{
            map.put(popNode,stack.peek());
        }

    }
}
