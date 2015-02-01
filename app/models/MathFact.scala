package models

case class MathFact(opType: String, lhs: Int, rhs: Int, status: String) {

  lazy val value: Int = Operator.operators(opType)(lhs, rhs)
  
  val review: String = "11 days" // 6 days or 3 hours , etc
  
  type Operator = (Int, Int) => Int

  object Operator {
    val operators: Map[String, Operator] =
      Map("+" -> { _ + _ },
        "-" -> { _ - _ },
        "*" -> { _ * _ },
        "/" -> { _ / _ })
    val tokens = operators map { _.swap }
    def unapply(token: String): Option[Operator] = operators.get(token)    
     
  }
  
  override def toString() = lhs + " " + opType + " " + rhs
}