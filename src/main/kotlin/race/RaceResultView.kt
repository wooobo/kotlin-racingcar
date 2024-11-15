package race

class RaceResultView {
    companion object {
        private const val PROGRESS_UNIT = "-"
    }

    fun printResult(raceBoard: RaceBoard) {
        val raceResult = raceBoard.start()
        println("실행 결과")

        raceResult.rounds.forEach {
            progressPrint(it)
            println()
        }
    }

    private fun progressPrint(it: RaceRound) {
        it.positions.forEach {
            println(PROGRESS_UNIT.repeat(it.value))
        }
    }
}
