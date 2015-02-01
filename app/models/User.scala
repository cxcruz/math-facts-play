package models

/**
 * @author cjcruz
 */
case class User(id: Long) {
  def getLearnedFacts(): Int = 70
  def getTotalFacts(): Int = 288
  def getLearnedFactsPercentage(): Int = getLearnedFacts().toFloat / getTotalFacts().toFloat * 100 toInt
  def getFactsInLongTermMemory(): Int = 66
  def noDifficultFacts(): String = "5" //instead of 0 return No
  def noFactsToReview(): Int = 10
  def getLevels(): List[Level] = {
    Level(2, "plant", "x2") :: Level(5, "plant", "x5") :: Level(10, "plant", "x10") :: Level(0, "plant", "x0") :: Level(1, "plant", "x1") :: Level(3, "plant", "x3", "Times 3") :: Level(4, "seed", "x4") :: Level(6, "inactive", "x6") :: Level(9, "inactive", "x9") :: Level(8, "inactive", "x8") :: Level(7, "inactive", "x7") :: Level(11, "inactive", "x11") :: Level(12, "inactive", "x12") :: Nil
  }
}
