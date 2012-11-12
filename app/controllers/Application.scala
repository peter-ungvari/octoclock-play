package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.time())
  }

  def time = Action {
    Ok(views.html.index())
  }

}