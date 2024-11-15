package race

class RaceResultView {
    companion object {
        private const val PROGRESS_UNIT = "-"
    }

    fun printResult(result: RaceResult) {
        println("실행 결과")

        result.rounds.forEach {
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
