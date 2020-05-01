//class Stack {
//
//}

// [+T]とすると子孫クラスに
trait Stack[+T] {
  def pop: (T, Stack[T])

  def push[E >: T](e: E): Stack[E]

  def isEmpty: Boolean
}

// [E >: T]という型パラメータの書き方は、EはTの継承元であるという制約を示す
class NonEmptyStack[+T](private val top: T, private val rest: Stack[T]) extends Stack[T] {
  def push[E >: T](e: E): Stack[E] = new NonEmptyStack[E](e, this) // 新しい値をtopとするStackインスタンスを作成する, 再帰的に自分自身のconstructorを呼び出す

  def pop: (T, Stack[T]) = (top, rest)

  def isEmpty: Boolean = false
}

case object EmptyStack extends Stack[Nothing] {
  def pop: Nothing = throw  new IllegalArgumentException("empty stack") // Nothingはすべての方のサブクラスとなる

  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)

  def isEmpty: Boolean = true
}

object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}