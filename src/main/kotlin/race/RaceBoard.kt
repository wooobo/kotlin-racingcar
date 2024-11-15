package race

class RaceBoard(
    private val carCount: Int,
    private val retryCount: Int,
    private val randomGenerate: RandomGenerate,
) {
    companion object {
        private const val RANDOM_START = 0
        private const val RANDOM_END = 9

        fun create(
            carCount: Int,
            retryCount: Int,
        ) = RaceBoard(carCount, retryCount, RandomGenerate(RANDOM_START, RANDOM_END))
    }

    fun start(): RaceResult {
        val cars = Cars.from(PositiveNumber(carCount))

        return RaceResult(
            (1..retryCount).map {
                val moveConditions: List<PositiveNumber> = List(carCount) { randomGenerate.generate() }
                cars.moveAll(moveConditions)
                RaceRound(cars.map { it.movedPosition })
            },
        )
    }
}
