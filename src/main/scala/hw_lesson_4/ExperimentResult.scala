package hw_lesson_4

case class ExperimentResult(
                             ballsCount: Int,
                             whiteBallsCount: Int,
                             whiteBallsPercent: Double
                           ) {
  override def toString: String =
    s"""
       | Total balls   : $ballsCount
       | White balls   : $whiteBallsCount
       | White balls % : $whiteBallsPercent
       |""".stripMargin
}
