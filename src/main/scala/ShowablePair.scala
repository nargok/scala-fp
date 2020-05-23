abstract class Show {
  def show: String
}

// 上位境界
class ShowablePair[T1 <: Show, T2 <: Show](val t1: T1, val t2: T2) extends Show {
  override def show: String = "(" + t1.show + "," + t2.show + ")"
}

/* -------------------------------------------------------------------- */

// こんなことができる
class StringShow(str: String) extends Show {
  override def show: String = str
}

//val s = new ShowablePair[StringShow, StringShow](new StringShow("a"), new StringShow("b"))
//s.show // return -> (a,b)

/* -------------------------------------------------------------------- */

// これはだめ
//class IntShow(i: Int) { def show: String = i.toString }

//new ShowablePair[IntShow, IntShow](new IntShow(1), new IntShow(2))

/* -------------------------------------------------------------------- */

// Showを継承すればOK
//class IntShow2(i: Int) extends Show { def show: String = i.toString }

//new ShowablePair[IntShow2, IntShow2](new IntShow2(1), new IntShow2(2))

