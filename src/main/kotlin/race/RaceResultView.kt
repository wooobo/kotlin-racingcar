package race

class RaceResultView {
    companion object {
        private const val PROGRESS_UNIT = "-"
    }

    fun printResult(result: PositiveNumber) {
        repeat(result.value) {
            print(PROGRESS_UNIT)
        }
        nextLine()
    }

    fun nextLine() {
        println()
    }
}
