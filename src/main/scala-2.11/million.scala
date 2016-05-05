/**
 * Created by wq on 16-4-28.
 */
object million{
  def main(args: Array[String]) {
    var profit = 0.0 ;
    var money = 1000.0;
    var i = 1;
    while(money<10000000){
      money += 1000 + (money * 0.18 / 12) ;
      i+=1
    }
    println(i/12)

  }


}
