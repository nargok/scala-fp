# README

## メソッドと関数の違い

- defで始まるものはメソッド
- メソッドは第一級の値ではない
- 関数は第一級の値である

## 高階関数
- 関数を引数にとったり関数を返すメソッドや関数のこと

## 再帰関数
- 末尾再帰最適化
  - 再帰処理で落ちないようにする工夫
  - 再帰関数の呼び出しが必ず関数の末尾になるように記述する
  - 内部的にループ処理に変換してくれる
  - @tailrecで末尾再起最適化をチェックできる
  
## サンプルコード
```scala
// Scalaでは関数の引数は22個まで
val add = new Function2[Int, Int, Int] {
  def apply(x: Int, y: Int): Int = x + y
}

// 無名関数
val add = (x: Int, y: Int) => x + y

// curry 1
val addCurried = (x: Int) => ((y:Int) => x + y)

// curry 2
def addCurried(x: Int)(y: Int): Int = x + y

// 高階関数
def double(n: Int, f: Int => Int): Int = {
  f(f(n))
}

// 高階関数の呼び出し
double(1, m => m * 2)
double(2, m => m * 3)
double(3, m => m * 4)

```