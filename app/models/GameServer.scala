package models

import akka.actor._

class GameServer extends Actor {

  var clients = List[(String, ActorRef)]()

  def receive = {
    
    case Connect(username) => {
      clients = (username, sender) :: clients
      context.watch(sender)
    }
    
    case Broadcast(msg) => {
      val username = getUsername(sender)
      broadcast(NewMsg(username, msg))
    }
    
    case Terminated(client) => {
      val username = getUsername(client)
      clients = clients.filter(sender != _._2)
    }
    
  }

  def broadcast(msg: Msg) {
    clients.foreach(x => x._2 ! msg)
  }

  def getUsername(actor: ActorRef): String = {
    clients.filter(actor == _._2).head._1
  }
  
}