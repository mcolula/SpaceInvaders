
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mcolula/Documentos/Play/SpaceInvaders/conf/routes
// @DATE:Thu Jun 02 22:22:40 CDT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Game_1: controllers.Game,
  // @LINE:12
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Game_1: controllers.Game,
    // @LINE:12
    Assets_0: controllers.Assets
  ) = this(errorHandler, Game_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Game_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Game.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """score/$name<.+>""", """controllers.Game.score(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """socket/$name<.+>""", """controllers.Game.gameSocket(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Game_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Game_index0_invoker = createInvoker(
    Game_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Game",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Game_score1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("score/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_Game_score1_invoker = createInvoker(
    Game_1.score(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Game",
      "score",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """score/$name<.+>"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Game_gameSocket2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("socket/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_Game_gameSocket2_invoker = createInvoker(
    Game_1.gameSocket(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Game",
      "gameSocket",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """socket/$name<.+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Game_index0_route(params) =>
      call { 
        controllers_Game_index0_invoker.call(Game_1.index)
      }
  
    // @LINE:7
    case controllers_Game_score1_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Game_score1_invoker.call(Game_1.score(name))
      }
  
    // @LINE:8
    case controllers_Game_gameSocket2_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_Game_gameSocket2_invoker.call(Game_1.gameSocket(name))
      }
  
    // @LINE:12
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_0.versioned(path, file))
      }
  }
}