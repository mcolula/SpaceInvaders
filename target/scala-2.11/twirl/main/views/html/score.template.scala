
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object score_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class score extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,List[scala.Tuple2[String, Int]],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(score: List[(String, Int)])(name: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html lang="es">
  
  <head>
    <title>"""),_display_(/*8.13*/title),format.raw/*8.18*/("""</title>
    
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
  
    <link rel="stylesheet" media="screen" href=""""),_display_(/*14.50*/routes/*14.56*/.Assets.versioned("bootstrap/css/bootstrap.min.css")),format.raw/*14.108*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.97*/("""">
    <link rel="stylesheet" medie="screen" href=""""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("stylesheets/game.css")),format.raw/*16.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*17.55*/routes/*17.61*/.Assets.versioned("images/favicon.png")),format.raw/*17.100*/("""">
  </head>
  
  <body>
    <div class="row">
      <div class="col-xs-6 col-xs-offset-3 text-center">
        <h1>Ranking</h1>
      </div>
    </div>
    <br>
    <hr>
    <div class="row text-center">
      <div class="col-xs-6 col-xs-offset-3">
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <td>Lugar</td>
              <td>Nombre</td>
              <td>Puntuación</td>
            </tr>
          </thead>

          <tbody>
            """),_display_(/*40.14*/for((item, idx) <- score.zipWithIndex) yield /*40.52*/ {_display_(Seq[Any](format.raw/*40.54*/(""" 
              """),_display_(/*41.16*/if(item._1 == name)/*41.35*/ {_display_(Seq[Any](format.raw/*41.37*/("""
                """),format.raw/*42.17*/("""<tr class="info">
              """)))}/*43.17*/else/*43.22*/{_display_(Seq[Any](format.raw/*43.23*/("""
                """),format.raw/*44.17*/("""<tr>
              """)))}),format.raw/*45.16*/(""" 
                """),format.raw/*46.17*/("""<td>"""),_display_(/*46.22*/(idx + 1)),format.raw/*46.31*/("""</td>
                <td>"""),_display_(/*47.22*/item/*47.26*/._1),format.raw/*47.29*/("""  """),format.raw/*47.31*/("""</td>
                <td>"""),_display_(/*48.22*/item/*48.26*/._2),format.raw/*48.29*/("""  """),format.raw/*48.31*/("""</td>
              </tr>
            """)))}),format.raw/*50.14*/("""
          """),format.raw/*51.11*/("""</tbody>

        </table>
      </div>
    </div>
    <script src=""""),_display_(/*56.19*/routes/*56.25*/.Assets.versioned("javascripts/jquery-1.12.2.min.js")),format.raw/*56.78*/(""""></script>
    <script src=""""),_display_(/*57.19*/routes/*57.25*/.Assets.versioned("bootstrap/js/bootstrap.min.js")),format.raw/*57.75*/(""""></script>
  </body>
  
</html>"""))
      }
    }
  }

  def render(title:String,score:List[scala.Tuple2[String, Int]],name:String): play.twirl.api.HtmlFormat.Appendable = apply(title)(score)(name)

  def f:((String) => (List[scala.Tuple2[String, Int]]) => (String) => play.twirl.api.HtmlFormat.Appendable) = (title) => (score) => (name) => apply(title)(score)(name)

  def ref: this.type = this

}


}

/**/
object score extends score_Scope0.score
              /*
                  -- GENERATED --
                  DATE: Sun Apr 03 22:31:37 CDT 2016
                  SOURCE: /home/mcolula/Documentos/Play/SpaceInvaders/app/views/score.scala.html
                  HASH: 2137610d113cfe46307829db811b64bc474810bd
                  MATRIX: 566->1|718->58|746->60|830->118|855->123|1106->347|1121->353|1195->405|1274->457|1289->463|1351->504|1430->556|1445->562|1507->603|1591->660|1606->666|1667->705|2200->1211|2254->1249|2294->1251|2338->1268|2366->1287|2406->1289|2451->1306|2503->1340|2516->1345|2555->1346|2600->1363|2651->1383|2697->1401|2729->1406|2759->1415|2813->1442|2826->1446|2850->1449|2880->1451|2934->1478|2947->1482|2971->1485|3001->1487|3071->1526|3110->1537|3206->1606|3221->1612|3295->1665|3352->1695|3367->1701|3438->1751
                  LINES: 20->1|25->1|27->3|32->8|32->8|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|64->40|64->40|64->40|65->41|65->41|65->41|66->42|67->43|67->43|67->43|68->44|69->45|70->46|70->46|70->46|71->47|71->47|71->47|71->47|72->48|72->48|72->48|72->48|74->50|75->51|80->56|80->56|80->56|81->57|81->57|81->57
                  -- GENERATED --
              */
          