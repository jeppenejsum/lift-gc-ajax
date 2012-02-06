package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http.js.JsCmd._
import net.liftweb.http._
import net.liftweb.common._
import net.liftweb.http.js._
import net.liftweb.http.js.JE._
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.js.jquery.JqJE._
import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml._

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  def onClick: JsCmd = {
    println("onClick")
    Alert("Clicked")
  }

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> SHtml.ajaxButton("Click me", () => {
    println("Button clicked");
    SetHtml("placeholder", <button id="placeholder">click me in 2+ min</button>) &
    (JqId("placeholder") ~> JsFunc("click", JsRaw("function() {"+ajaxCall(JsRaw("'x'"), s => onClick)._2.toJsCmd+"}"))).cmd
  })

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

