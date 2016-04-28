package huff;

/**
 * Created by wq on 16-4-23.
 */
public class Node2<E> implements Comparable<Node2<E>> {
    E data;
    Node2<E> leftNode;
    Node2<E> rightNode;
    double weight;

    public Node2(E data,double weight){
        this.data = data;
        this.weight = weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public int compare(Node2 x, Node2 y) {
        return (x.getWeight() < y.getWeight()) ? -1 : ((x.getWeight() == y.getWeight()) ? 0 : 1);
    }

    public int compareTo(Node2 node){
        return compare(this,node);
    }

}



