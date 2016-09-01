
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mcolula/Documentos/Play/SpaceInvaders/conf/routes
// @DATE:Thu Jun 02 22:22:40 CDT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
