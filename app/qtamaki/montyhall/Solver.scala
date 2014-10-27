package qtamaki.montyhall

import scala.util.Random

class Solver {
  // (Win count, Loose count)
  def solves(change: Boolean, play_count: Int): (Int, Int) = {
    0.to(play_count - 1).map({ i =>
      Box.createBox.firstChoise(Random.nextInt(Box.box_size)).lastChoise(change)
    }).foldLeft[(Int, Int)]((0, 0))((b, content: Content) => {
      val (x, y) = b
      content match {
        case Box.Car => (x + 1, y)
        case Box.Goat => (x, y + 1)
      }
    })
  }
}