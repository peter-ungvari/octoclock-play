package controllers

import play.api.mvc._
import hu.globit.octoclock.Octoclock
import java.text.SimpleDateFormat
import java.util.Date

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.time())
  }

  def time = Action {
    val oc = new Octoclock
    val fullTime = oc.getTime
    val days = fullTime.substring(3,8);
    val hours = fullTime.substring(8,12);
    val conventional = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date)
    Ok(views.html.index(days, hours, conventional))
  }

}