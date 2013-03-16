package controllers

import play.api.mvc._
import hu.globit.octoclock.Octoclock
import java.text.SimpleDateFormat
import java.util.{TimeZone, GregorianCalendar}

object Application extends Controller {

  def index = Action {
    Ok(views.html.time())
  }

  def time = Action {
    val oc = new Octoclock
    val fullTime = oc.getTime
    val days = fullTime.substring(3,8).reverse
    val hours = fullTime.substring(8,12).reverse
    val fmt1 = new SimpleDateFormat("yyyy-MM-dd EEE")
    val fmt2 = new SimpleDateFormat("HH:mm (z)")
    val now = new GregorianCalendar(TimeZone.getTimeZone("UTC"))
    fmt1.setCalendar(now)
    fmt2.setCalendar(now)
    val conv1 = fmt1.format(now.getTime)
    val conv2 = fmt2.format(now.getTime)
    Ok(views.html.snippet(days, hours, conv1, conv2))
  }

}