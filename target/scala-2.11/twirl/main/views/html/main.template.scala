
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.65*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE  html>

<html lang="es">
  <head>
    <title>"""),_display_(/*7.13*/title),format.raw/*7.18*/("""</title>
    
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

    <link rel="stylesheet" media="screen" href=""""),_display_(/*13.50*/routes/*13.56*/.Assets.versioned("bootstrap/css/bootstrap.min.css")),format.raw/*13.108*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*14.50*/routes/*14.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.97*/("""">
    <link rel="stylesheet" medie="screen" href=""""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("stylesheets/game.css")),format.raw/*15.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.55*/routes/*16.61*/.Assets.versioned("images/favicon.png")),format.raw/*16.100*/("""">
    
  </head>
  <body onload="init();">
    """),_display_(/*20.6*/content),format.raw/*20.13*/("""
    """),format.raw/*21.5*/("""<script src=""""),_display_(/*21.19*/routes/*21.25*/.Assets.versioned("javascripts/game.js")),format.raw/*21.65*/(""""></script>
    <script src=""""),_display_(/*22.19*/routes/*22.25*/.Assets.versioned("javascripts/gun.js")),format.raw/*22.64*/(""""></script>
    <script src=""""),_display_(/*23.19*/routes/*23.25*/.Assets.versioned("javascripts/player.js")),format.raw/*23.67*/(""""></script>
    <script src=""""),_display_(/*24.19*/routes/*24.25*/.Assets.versioned("javascripts/stage.js")),format.raw/*24.66*/(""""></script>
    <script src=""""),_display_(/*25.19*/routes/*25.25*/.Assets.versioned("javascripts/invader.js")),format.raw/*25.68*/(""""></script>
    <script src=""""),_display_(/*26.19*/routes/*26.25*/.Assets.versioned("javascripts/bunker.js")),format.raw/*26.67*/(""""></script>
    <script src=""""),_display_(/*27.19*/routes/*27.25*/.Assets.versioned("javascripts/space-gun.js")),format.raw/*27.70*/(""""></script>
    <script src=""""),_display_(/*28.19*/routes/*28.25*/.Assets.versioned("javascripts/text-message.js")),format.raw/*28.73*/(""""></script>
    <script src=""""),_display_(/*29.19*/routes/*29.25*/.Assets.versioned("javascripts/jquery-1.12.2.min.js")),format.raw/*29.78*/(""""></script>
    <script src=""""),_display_(/*30.19*/routes/*30.25*/.Assets.versioned("bootstrap/js/bootstrap.min.js")),format.raw/*30.75*/(""""></script>
    <script src=""""),_display_(/*31.19*/routes/*31.25*/.Assets.versioned("easeljs/lib/easeljs-0.8.2.min.js")),format.raw/*31.78*/(""""></script>
  </body>    
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(request)

  def f:((String) => (Html) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (request) => apply(title)(content)(request)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Wed Aug 31 20:43:50 CDT 2016
                  SOURCE: /home/mcolula/Documentos/Play/SpaceInvaders/app/views/main.scala.html
                  HASH: cad944d09ac525d5fe85e3b0c35c07c684eb511d
                  MATRIX: 544->1|702->64|730->66|812->122|837->127|1086->349|1101->355|1175->407|1254->459|1269->465|1331->506|1410->558|1425->564|1487->605|1571->662|1586->668|1647->707|1722->756|1750->763|1782->768|1823->782|1838->788|1899->828|1956->858|1971->864|2031->903|2088->933|2103->939|2166->981|2223->1011|2238->1017|2300->1058|2357->1088|2372->1094|2436->1137|2493->1167|2508->1173|2571->1215|2628->1245|2643->1251|2709->1296|2766->1326|2781->1332|2850->1380|2907->1410|2922->1416|2996->1469|3053->1499|3068->1505|3139->1555|3196->1585|3211->1591|3285->1644
                  LINES: 20->1|25->1|27->3|31->7|31->7|37->13|37->13|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|44->20|44->20|45->21|45->21|45->21|45->21|46->22|46->22|46->22|47->23|47->23|47->23|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|50->26|51->27|51->27|51->27|52->28|52->28|52->28|53->29|53->29|53->29|54->30|54->30|54->30|55->31|55->31|55->31
                  -- GENERATED --
              */
          