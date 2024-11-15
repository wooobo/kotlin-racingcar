package race

class RaceBoard(
    private val carCount: Int,
    private val retryCount: Int,
    private val resultView: RaceResultView,
) {
    companion object {
        private const val RANDOM_START = 0
        private const val RANDOM_END = 9
    }

    fun start() {
        val randomGenerate = RandomGenerate(RANDOM_START, RANDOM_END)
        val cars = Cars.from(PositiveNumber(carCount))

        repeat(retryCount) {
            val moveConditions: List<PositiveNumber> = List(carCount) { randomGenerate.generate() }
            cars.moveAll(moveConditions)
            recordRaceRound(cars)
        }
    }

    private fun recordRaceRound(cars: Cars) {
        repeat(cars.size) { index ->
            resultView.printResult(cars[index].position)
        }

        resultView.nextLine()
    }
}
