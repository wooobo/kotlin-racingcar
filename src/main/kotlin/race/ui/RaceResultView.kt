package race.ui

import race.sevice.RaceResult
import race.sevice.RaceRound

object RaceResultView {
    fun printResult(result: RaceResult) {
        println("실행 결과")

        result.rounds.forEach {
            progressPrint(it)
            println()
        }

        println("${result.winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun progressPrint(it: RaceRound) {
        val progressUnit = "-"
        it.positions.forEach {
            println("${it.displayName}: ${progressUnit.repeat(it.progress)}")
        }
    }
}
