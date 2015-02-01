package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def facts(id: Long) = Action {
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
    Ok(views.html.index("Your new application is ready."))
  }

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