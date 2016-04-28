package huff

/**
 * Created by wq on 16-4-25.
 */
class Node(val data:String,val weight:Double) extends Comparable[Node]{
  var leftNode:Node=null
  var rightNode:Node=null

  def compare(x:Node,y:Node):Int ={
    val in:Int = if(x.weight<y.weight) -1 else if(x.weight == y.weight) 0 else 1
    in
  }

  override def compareTo(node:Node):Int = {
    val i = compare(this,node)
    i
  }
}