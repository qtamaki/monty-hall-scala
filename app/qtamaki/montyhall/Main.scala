package qtamaki.montyhall

object Main {
  def main(args: Array[String]): Unit = {
    val sol = new Solver
    val changed = sol.solves(true, 100000)
    val nochange = sol.solves(false, 100000)
    println("Changed:" + format(changed) + "% " + changed)
    println("No change:" + format(nochange) + "% " + nochange)
  }
  
  private def format(x: (Int, Int)): String = {
    val (w, l) = x
    "%2.2f".format(w.toDouble / (w + l) * 100)
  }
  
}