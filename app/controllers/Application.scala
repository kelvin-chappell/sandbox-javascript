package controllers

import play.api.mvc._
import play.api.templates.Html
import scala.Predef._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def show(script: String) = Action {
    val view: (String) => Html = script match {
      case "jquery" => views.html.jquery(_)
      case "interceptLinks" => views.html.interceptLinks(_)
      case "lookup" => views.html.lookup(_)
      case _ => throw new IllegalArgumentException
    }
    Ok(view(script))
  }

}
