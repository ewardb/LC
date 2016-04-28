import huff._

/**
 * Created by wq on 16-4-25.
 */
object Test extends App{
  val huff = new Huffman()
  val s = "aabbccddeeff"
  val nodes:List[Node] = huff.getListFromString(s,"")
  val node = huff.createHuffmanTree(nodes)
  val hashMap = huff.createHuffmanCode(node,"",new Node("",0))
  val (handledHashMap,handledDecodeHashMap) = huff.handleHashMap(hashMap)
  val code = huff.getHuffCode(s,"",handledHashMap)
  println(code)
  val deCode = huff.getDeHuffCode(code,handledDecodeHashMap)
  println(deCode)
  println(deCode.equals(s))
}
