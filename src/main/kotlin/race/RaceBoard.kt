package race

class RaceBoard(
    private val carCount: Int,
    private val retryCount: Int,
    private val numberGenerate: NumberGenerator,
) {
    fun start(): RaceResult {
        val cars = Cars(PositiveNumber(carCount))

        return RaceResult(
            (1..retryCount).map {
                val moveConditions = MoveConditions(carCount) { numberGenerate() }

                cars.moveAll(moveConditions)
                RaceRound(cars.map { it.position })
            },
        )
    }
}
