package race

class RaceBoard(
    private val carCount: Int,
    private val retryCount: Int,
) {
    companion object {
        private const val RANDOM_START = 0
        private const val RANDOM_END = 9
    }

    fun start(): RaceResult {
        val randomGenerate = RandomGenerate(RANDOM_START, RANDOM_END)
        val cars = Cars.from(PositiveNumber(carCount))

        val rounds = mutableListOf<RaceRound>()

        repeat(retryCount) {
            val moveConditions: List<PositiveNumber> = List(carCount) { randomGenerate.generate() }
            cars.moveAll(moveConditions)

            rounds.add(RaceRound(cars.map { it.movedPosition }))
        }

        return RaceResult(rounds)
    }
}
