import scala.annotation.tailrec

object Main {

  @tailrec
  def series(n: Int, acc: Int): Int = {
    if (n == 0) {
      acc
    } else {
      series(n - 1, acc + n)
    }
  }

  @tailrec
  def fact(n: Int, acc: Int): Int = if (n <= 1) acc else fact(n - 1, acc * n)

//  def twice(f: Int => Int): Int => Int = (x) => f(f(x))
  def twice(f: Int => Int): Int => Int = f.compose(f) // compose2つの関数を組み合わせてひとつにする
}
