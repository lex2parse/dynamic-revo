package revo

import scala.scalajs.js
import org.scalajs.dom.document

object Main extends App {
  val shipit = document.createElement("p")
  shipit.innerHTML = "ship it"
  document.body.appendChild(shipit)
}
