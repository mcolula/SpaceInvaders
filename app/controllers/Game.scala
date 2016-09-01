package controllers

import models._
import play.api._
import play.api.mvc._
import play.api.Play.current
import akka.actor._
import play.api.mvc._
import akka.actor._
import javax.inject._
import play.api.libs.iteratee._
import collection.mutable.PriorityQueue
import play.api.libs.concurrent.Execution.Implicits.defaultContext

@Singleton
class Game @Inject() (system: ActorSystem) extends Controller {
  
  
  val server = system.actorOf(Props[GameServer])
  
  
  var scoreBoard  = List[(String, Int)]()
  

  def index = Action { implicit request =>
    Ok(views.html.index("")(request))
  }
  
  
  def gameSocket(name: String) = WebSocket.using[String] { request =>
    val (out, channel) = Concurrent.broadcast[String]
    val actor = system.actorOf(Props(Client(name, server, channel)))
    val in = Iteratee.foreach[String] { msg => 
      var data = msg 
      if (data.contains("[start]"))
        scoreBoard = List[(String, Int)]()
      if (data.contains("[score]")) {
        println("Before replace: " + data)
        data = data.replace("[score]", "")
        println("After replace: " + data)
        val info = data.split("]")
        val user  = info(0).substring(1, info(0).size)
        val value = info(1).toInt
        scoreBoard = (user -> value) :: scoreBoard
        println(scoreBoard)
      }
      println(msg)
      actor ! Send(msg) 
    } map {
      _ => println("Closed") 
    }
    (in, out.andThen(Enumerator.eof))
  } 
  
  
  def score(name: String) = Action { implicit request =>
    scoreBoard = scoreBoard.sortBy{ _._2 }
    scoreBoard = scoreBoard.reverse                  
    Ok(views.html.score("ScoreBoard")(scoreBoard)(name))
  }
  
}
