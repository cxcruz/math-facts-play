package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.ws._
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
import scalikejdbc._
import models.Fact

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def facts(id: Long) = Action {
    
    implicit val session = AutoSession
  sql"""
    select 1;
  """.execute.apply()    
    
    val facts: List[Fact] = sql"select * from facts".map(rs => Fact(rs)).list.apply()
    println(facts)
    
    val user = models.User(id)
    Ok(views.html.facts(user))
  }

  def details(userid: Long, levelid: Long) = Action {
    val user = models.User(userid)
    val level = user.getLevels().filter(level => level.id == levelid).head
    //val level = new models.Level(levelid, "plant", "title")
    Ok(views.html.details(user, level))
  }

  def difficult(userid: Long, levelid: Long) = Action {
    implicit request =>
      val searchType = request.getQueryString("searchType"); // null if not in URL
      val tmcUrl = s"http://www.nba.com"

      WS.url(tmcUrl).withQueryString("k1" -> "v1")

      Ok(views.html.index("Your new application is ready."))
  }

/*
  def test() = Action {
    implicit request =>
      Async {
        val searchType = request.getQueryString("searchType"); // null if not in URL
        val tmcUrl = s"http://www.nba.com"

        val mu = WS.url(tmcUrl).withQueryString("k1" -> "v1", "k2" -> "v2").get().map {
          response => Ok(response.json)
        }
        mu
      }
    // mu.value.get.toOption.getOrElse(Ok("failure"))
  }
*/
  def sayHello = Action(parse.json) { implicit request =>
    (request.body \ "name").asOpt[String].map { name =>
      Ok(Json.toJson(
        Map("status" -> "OK", "message" -> ("Hello " + name))))
    }.getOrElse {
      BadRequest(Json.toJson(
        Map("status" -> "KO", "message" -> "Missing parameter [name]")))
    }
  }

}