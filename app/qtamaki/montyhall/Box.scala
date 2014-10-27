package qtamaki.montyhall

import scala.util.Random

sealed abstract class Content

case class Box(val box1: Content,
          val box2: Content, 
          val box3: Content) {
  def get(i:Int) = {
    i match {
      case 0 => box1
      case 1 => box2
      case 2 => box3
    }
  }
  def firstChoise(choise: Int):OpenedBox =  {
    OpenedBox(this.get(choise), (choise match {
      case 0 => (this.box2, this.box3)
      case 1 => (this.box1, this.box2)
      case 2 => (this.box2, this.box3)
    }) match {
      case (Box.Car, Box.Goat) => Box.Car
      case (Box.Goat, Box.Goat) => Box.Goat
      case (Box.Goat, Box.Car) => Box.Car
      case _ => ???
    })
  }
}
          
case class OpenedBox(val box1: Content, val box2: Content) {
  def lastChoise(change: Boolean): Content = {
    if (change) box2 else box1
  }
}


object Box{
  val box_size = 3
  case object Goat extends Content
  case object Car extends Content
  
  def createBox: Box = {
    Random.nextInt(box_size) match {
      case 0 => new Box(Car, Goat, Goat)
      case 1 => new Box(Goat, Car, Goat)
      case 2 => new Box(Goat, Goat, Car)
    }
  }
  
}
