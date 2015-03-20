package model.api

import play.api._
import play.api.mvc._
import scalikejdbc._
import org.joda.time.{ DateTime, LocalDate }
//import JsonStringOps._

object Stats {

  private val sql = """
  """
  // since(33, Some("2013-09-10 15:11:44.911-04")) => "{ ... }"
  def all(userid: Int)(implicit session: DBSession): String = 
    SQL(sql).bind(userid).map(_.string("json")).single.apply().getOrElse("{}")

}

