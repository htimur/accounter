package de.khamrakulov.accounter

import akka.actor.{ ActorSystem, Props }
import spray.routing.SimpleRoutingApp
import de.khamrakulov.accounter.oauth2.OAuth2Actor

object Boot extends App with SimpleRoutingApp {

  implicit val system = ActorSystem("on-spray-can")

  lazy val oauth = system.actorOf(Props[OAuth2Actor])

  startServer(interface = "localhost", port = 8080) {
    pathPrefix("oauth") { ctx => oauth ! ctx }
  }

}