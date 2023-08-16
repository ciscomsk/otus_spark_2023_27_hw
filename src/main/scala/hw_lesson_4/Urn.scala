package hw_lesson_4

import scala.annotation.tailrec
import scala.util.Random

case class Urn(balls: IndexedSeq[Ball]) {
  def takeBalls(number: Int = 2): IndexedSeq[Ball] = {
    val rnd: Random = new Random()

    @tailrec
    def loop(
              balls: IndexedSeq[Ball] = balls,
              ballsToTake: Int = number,
              acc: IndexedSeq[Ball] = IndexedSeq.empty
            ): IndexedSeq[Ball] = {

      if (ballsToTake == 0) {
        acc
      } else {
        val ballIdx: Int = rnd.nextInt(balls.length)
        val ball: Ball = balls(ballIdx)
        val ballsRemaining: IndexedSeq[Ball] = balls.zipWithIndex.filter(_._2 != ballIdx).map(_._1)

        loop(ballsRemaining, ballsToTake - 1, acc :+ ball)
      }
    }

    loop()
  }
}

object Urn {
  /**
    можно проще - shuffle
    https://www.scala-lang.org/api/2.13.11/scala/util/Random$.html#shuffle[T,C](xs:IterableOnce[T])(implicitbf:scala.collection.BuildFrom[xs.type,T,C]):C
   */
  def fillUrn(number: Int = 6, limit: Int = 3): IndexedSeq[Ball] = {
    val rnd: Random = new Random()

    @tailrec
    def loop(
              ballsToAdd: Int = number,
              whiteBallsCount: Int = 0,
              blackBallsCount: Int = 0,
              acc: IndexedSeq[Ball] = IndexedSeq.empty
            ): IndexedSeq[Ball] = {

      if (ballsToAdd == 0) {
        acc
      } else if (whiteBallsCount == limit) {
        val blackBallsToAdd: IndexedSeq[Ball] = (1 to (limit - blackBallsCount)).map(_ => Black)
        acc ++ blackBallsToAdd
      } else if (blackBallsCount == limit) {
        val whiteBallsToAdd: IndexedSeq[Ball] = (1 to (limit - whiteBallsCount)).map(_ => White)
        acc ++ whiteBallsToAdd
      } else {
        val ball: Ball = if (rnd.nextBoolean()) White else Black

        if (ball == White) {
          loop(ballsToAdd - 1, whiteBallsCount + 1, blackBallsCount, acc :+ ball)
        } else {
          loop(ballsToAdd - 1, whiteBallsCount, blackBallsCount + 1, acc :+ ball)
        }
      }
    }

    loop()
  }
}
