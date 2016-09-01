
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mcolula/Documentos/Play/SpaceInvaders/conf/routes
// @DATE:Thu Jun 02 22:22:40 CDT 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseGame Game = new controllers.ReverseGame(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseGame Game = new controllers.javascript.ReverseGame(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
