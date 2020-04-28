import scala.annotation.tailrec

object Main {

  def series(n: Int): Int = {
    if (n == 0) {
      0
    } else {
      series(n - 1) + n
    }
  }
}


// Scalaでは関数の引数は22個まで
//val add = new Function2[Int, Int, Int] {
//  def apply(x: Int, y: Int): Int = x + y
//}

// 無名関数
//val add = (x: Int, y: Int) => x + y

// curry 1
//val addCurried = (x: Int) => ((y:Int) => x + y)

// curry 2
//def addCurried(x: Int)(y: Int): Int = x + y

// 高階関数
//def double(n: Int, f: Int => Int): Int = {
//  f(f(n))
//}
//
//// 高階関数の呼び出し
//double(1, m => m * 2)
//double(2, m => m * 3)
//double(3, m => m * 4)

