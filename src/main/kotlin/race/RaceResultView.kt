package race

class RaceResultView {
    fun printResult(result: PositiveNumber) {
        repeat(result.value) {
            print("-")
        }
        nextLine()
    }

    fun nextLine() {
        println()
    }
}
