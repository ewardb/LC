package huff

import scala.collection.mutable
import scala.collection.mutable._


/**
 * Created by wq on 16-4-25.
 */
class Huffman {
//  navbar-right
  /**
   * 將給定的字符串通過分割參數進行分割，計算權重，得出Node 的集合
   * @param str 字符串
   * @param reg 分割參數
   * @return List<Node>集合
   */
  def getListFromString(str:String,reg:String):List[Node] = {
    val list:scala.collection.mutable.LinkedHashSet[Node] = new mutable.LinkedHashSet
    val map:scala.collection.mutable.HashMap[String,Int] = new HashMap[String,Int]()
    str.split(reg).foreach{
      i=> val hz:Int = map.getOrElse(i,0)+1
        map+=(i->hz)
    }
    for((k,v)<-map){
      list+=(new Node(k,v))
    }
    println("構建Hz  List《Node》完成！！！！！！")
    list.toList
  }

  /**
   * 對List<Node> 進行排序  排序規則在Node 中已經實現了Comparable中的compareTo方法
   * @param nodes 接收一個Node的集合
   * @return 一個List集合
   */
  def sortNode(nodes:List[Node]):List[Node] = {
    val sortList =nodes.sorted
//    sortList.foreach(i=> println(i.data + "  " + i.weight))
    sortList
  }

  /**
   * 構建霍夫曼樹時，構建新List集合
   * @param nodes 接收一個Node的集合
   * @return 一個List集合
   */
  def replaceNode(nodes:List[Node]):List[Node] = {
    val list = sortNode(nodes)
    val weight = list(0).weight + list(1).weight
    val newNode = new Node("N"+weight,weight)
    newNode.leftNode = list(0)
    newNode.rightNode = list(1)
    newNode :: list.drop(2)
  }

  /**
   * 在霍夫曼編碼前 需要構建霍夫曼樹
   * @param nodes  接收一個Node的集合
   * @return  返回霍夫曼樹的根節點
   */
  def createHuffmanTree(nodes:List[Node]):Node = {
    if(nodes.length ==0){
      throw new Exception("nodes 長度爲0")
    }
    val nodeList = if(nodes.length>1) replaceNode(nodes) else nodes(0) ::Nil
    if(nodeList.length == 1){
      nodeList(0)
    }else{
      createHuffmanTree(nodeList)
    }
  }

  val hashMap:scala.collection.mutable.HashMap[String,String] = new HashMap[String,String]()


  def createHuffmanCode(ele:Node,s:String,parent:Node):mutable.HashMap[String,String] ={
    if(ele !=null){
      val ss = parent.data
//      val parentString = if(hashMap.contains(ss)) hashMap(ss) else ""
      val parentString = hashMap.getOrElse(ss,"")
      hashMap+=(ele.data->(parentString+s))
      if(ele.leftNode!=null) createHuffmanCode(ele.leftNode,"0",ele)
      if(ele.rightNode!=null) createHuffmanCode(ele.rightNode,"1",ele)
    }
    hashMap
  }


  def handleHashMap(hashMap:HashMap[String,String]):Tuple2[HashMap[String,String],HashMap[String,String]] = {
    val handledHashMap:HashMap[String,String] =hashMap.filterNot(kv=>kv._1.contains("N"))
    val handledDecodeHashMap = for((k,v)<-handledHashMap) yield (v,k)
    (handledHashMap,handledDecodeHashMap)
  }

  /**
   * 計算得出編碼
   * @param s 要進行編碼的字符串
   * @param hashMap 用於爲對象的編碼hashMap
   * @return 編碼序列
   */
  def getHuffCode(s:String,reg:String,hashMap:HashMap[String,String]):String ={
    val sb = new scala.StringBuilder()
    s.split(reg).foreach{
      i=>
        sb.append(hashMap(i))
    }
    sb.toString
  }

  val sb = new scala.StringBuilder()
  def getDeHuffCode(str:String,dehashMap:HashMap[String,String]):String ={
    if(str.isEmpty){
    }else{
      val len = getdeCodeListLength(dehashMap)
      for(i<-len){
        val key = if(i<=str.length) str.take(i) else ""   //  !!!!!!!!!!!!!!!!!千萬注意！！！！！！！！！！！！！！
        if(dehashMap.contains(key)){
          sb.append(dehashMap(key))
          getDeHuffCode(str.drop(i),dehashMap)
        }
      }
    }
    sb.toString
  }

  def getdeCodeListLength(dehashMap:HashMap[String,String]) = dehashMap.keySet.map(i=>i.length).filter(i=>i!=0).toList.sortWith(_<_)
}

object Huffman{

}