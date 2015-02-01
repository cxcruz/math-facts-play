package models

case class Level(id: Long, status: String, title: String, description: String = "") {
  
  lazy val completedPercentage: Int = 55;
  
  lazy val factsQty: Int = facts.length
  
  def facts: List[MathFact] = MathFact("*", 1, 2, "inactive") :: MathFact("*", 1, 4, "seed") :: MathFact("*", 1, 5, "plant") :: Nil
}
