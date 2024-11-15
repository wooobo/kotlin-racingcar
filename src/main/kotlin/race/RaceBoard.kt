package race

class RaceBoard(
    private val carCountView: InputView,
    private val retryCountView: InputView,
    private val resultView: RaceResultView,
) {
    fun start() {
        val randomGenerate = RandomGenerate(0, 10)
        val carCount = carCountView.processInputToInto()
        val retryCount = retryCountView.processInputToInto()
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
