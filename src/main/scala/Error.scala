class Error {

}

//def divStr(target: Int, divider: Int): String = {
//  if (divider == 0) null else (target / divider).toString
//}

//val result = divStr(10, 0)
//val size = if (result == null) 0 else result.size

// という書き方もできるが、nullを使ったエラーハンドリングはシステム全体の品質を低下させる


def divStr(target: Int, divider: Int): String = {
  if (divider == 0) throw new IllegalArgumentException("dividerに0は利用できません")
  else (target / divider).toString
}

// 例外を使った書き方もできるが、例外を使うとコントロールが難しくなる
// 例外は非同期プログラミングではつかえない

// Optionで対処する
// nullの代替
// 値を一つだけ入れられるコンテナ Some or None

val o: Option[String] = Option(null)

o.get
o.isEmpty
o.isDefined

o.getOrElse("")

// getメソッドを使うことはめったにない、getOrElseをよく使う

// パターンマッチ

val s: Option[String] = Some("hoge")
s match {
  case Some(str) => println(str)
  case None => print("None")
}
s match {
  case Some(str) => println(str)
  case None => print("None")
}

// Optionはコレクションの性質がある
Some(3).map(_ * 3)


// foldを使えばNoneに対して関数実行の結果を定義できる
val n: Option[Int] = None
n.fold(0)(_ * 3)


// 入れ子の解消
val v1: Option[Int] = Some(3)
val v2: Option[Int] = Some(5)
v1.map(i1 => v2.map(i2 => i1 * i2))

v1.map(i1 => v2.map(i2 => i1 * i2)).flatten

v1.flatMap(i1 => v2.map(i2 => i1 * i2))

// for を利用したリファクタリング
val v3: Option[Int] = Some(7)
val v4: Option[Int] = None
for {i1 <- v1
     i2 <- v2
     i3 <- v3
     i4 <- v4
     } yield i1 * i2 * i3 * i4