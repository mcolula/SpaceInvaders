package models

import akka.actor._
import play.api.libs.iteratee.Concurrent._

class Client(username: String, server: ActorRef, channel: Channel[String]) extends Actor {

  server ! Connect(username)
   
  def receive = {
    
    case NewMsg(from, msg) => {
      channel.push(s"[$from]$msg")
    }
    
    case Send(msg) => {
      server ! Broadcast(msg)
    }
    
    case Info(msg) => {
      channel.push(s"$msg") 
    }
    
    case Disconnect => {
      self ! PoisonPill
    }
    
  } 

}

object Client {
  def apply(username: String, server: ActorRef, channel: Channel[String]) =
    new Client(username, server, channel)
}

