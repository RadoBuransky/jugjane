package models.domain.gym

import java.net.URL
import models.domain.grade._
import models.Color
import models.domain.route.{FlagTag, CategoryTag}
import java.util.Locale

case class DemoGrade(val from: Grade, val to: Grade, val color: Color, val name: String, val id: String)
  extends IntervalGrade with SingleColorGrade with NamedGrade with IdGrade

object DemoGradingSystem extends GradingSystem[DemoGrade]("Demo", Set(Discipline.Bouldering),
  DemoGrade(Hueco.V0, Hueco.V1, Color(0, 0, 0), "Entry", "demo1") ::
  DemoGrade(Hueco.V1, Hueco.V3, Color(0, 0, 0), "Beginner", "demo2") ::
  DemoGrade(Hueco.V3, Hueco.V5, Color(0, 0, 0), "Intermediate", "demo3") ::
  DemoGrade(Hueco.V5, Hueco.V7, Color(0, 0, 0), "Expert", "demo4") ::
  Nil)

/**
 * Created with IntelliJ IDEA.
 * User: rado
 * Date: 13/11/13
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
object Demo extends Gym {
  import models.domain.gym.ColoredHolds._

  def name = "Mystery Crack Gym"
  val url = new URL("http://www.mysterycrack.com/")
  def handle = "demo"
  def secret = "123"
  def gradingSystem = DemoGradingSystem
  def disciplines = Set(Discipline.Bouldering)
  def holdColors = Set(Color.Red, Color.Green, Color.Blue, (Color.Yellow, Color.Blue),Color.Purple,
    Color.White, Color.Yellow)
  def tags = CategoryTag("TNT", Color.White) :: Nil
  def address = Address("Marie Curie Sklodowskej 39", "Bratislava", Locale.forLanguageTag("sk-sk"))
}
