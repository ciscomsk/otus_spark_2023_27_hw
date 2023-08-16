package hw_lesson_4

import hw_lesson_4.Urn.fillUrn

object Hw extends App {
  /**
   * Логика не соответствует задуманной в дз
   * https://otus.ru/learning/246743/?utm_source=email&utm_medium=email&utm_campaign=otus&utm_content=auto&utm_term=hw_accept&relogin=True#/homework-chat/23562/
   */
  private def doExperiment(iterationCount: Int = 10000, number: Int = 2): ExperimentResult = {
    val whiteBallsCount: Int =
      (1 to iterationCount)
        .map(_ => Urn(fillUrn()))
        .flatMap(_.takeBalls(number))
        .count(_ == White)

    val ballsCount: Int = iterationCount * number

    ExperimentResult(ballsCount, whiteBallsCount, 100 * whiteBallsCount.toDouble / ballsCount)
  }

  println(doExperiment())
}
