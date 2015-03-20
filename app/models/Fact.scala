package models

import scalikejdbc._
//import org.joda.time._

case class Fact(id: Int, op1: Int, op2: Int)

object Fact extends SQLSyntaxSupport[Fact] {
  override val tableName = "facts"
   // cannot omit `columnNames` definition for NamedDB
  override val columnNames = Seq("id", "op1", "op2")
  def apply(rs: WrappedResultSet)(implicit session: DBSession = AutoSession) = new Fact(
      rs.int("id"), rs.int("op1"), rs.int("op2"))
}
