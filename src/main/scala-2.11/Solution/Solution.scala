package Solution

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Created by wq on 16-4-28.
 */
object Solution {
  def reverseString(str:String):String = str.reverse

  def countBits(i:Int):Array[Int] = {
    val result = new ArrayBuffer[Int]()
    result(0) = 0
    for(j<- 1 to i){
      result(j) = result(j&(j-1)) +1
    }
    result.toArray
  }

  def topKFrequent(nums:List[Int],k:Int):List[Int] = {
    val hashMap:mutable.HashMap[Int,Int] = new mutable.HashMap[Int,Int]()
    nums.foreach{
      i=>
        val hz:Int = hashMap.getOrElse(i,0)+1
        hashMap+=(i->hz)
    }









    List(1)
  }

  def main(args: Array[String]) {
    println(reverseString("abcdefg"))
  }



}
