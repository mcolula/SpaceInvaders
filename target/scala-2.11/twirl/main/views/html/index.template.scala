
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.52*/("""

"""),_display_(/*3.2*/main("Space Invaders")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""
  """),format.raw/*4.3*/("""<div class='container'>
    <div class='row row-centered'>
      <div class='col-md-12 col-centered'>
        <canvas id='canvas' class='gamescreen' width='1000' height='600'></canvas>
      </div>
    </div>
  </div>
""")))}/*11.2*/(request)),format.raw/*11.11*/("""
"""))
      }
    }
  }

  def render(message:String,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(message)(request)

  def f:((String) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (message) => (request) => apply(message)(request)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Wed Aug 31 20:49:03 CDT 2016
                  SOURCE: /home/mcolula/Documentos/Play/SpaceInvaders/app/views/index.scala.html
                  HASH: fb1470d8899feb8fdce08af7fb03d97c23f225ea
                  MATRIX: 541->1|686->51|714->54|744->76|783->78|812->81|1049->300|1079->309
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|35->11|35->11
                  -- GENERATED --
              */
          