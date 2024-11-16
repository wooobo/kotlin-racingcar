package race.sevice

import race.domain.CarName
import race.domain.CarNames
import race.domain.Cars
import race.domain.MoveConditions

class RaceBoard(
    inputNames: List<String>,
    private val retryCount: Int,
    private val numberGenerate: NumberGenerator,
) {
    private val carNames: CarNames = CarNames(inputNames.map { CarName(it) })

    fun start(): RaceResult {
        val cars = Cars(carNames)

        return RaceResult(
            (1..retryCount).map {
                val moveConditions = MoveConditions(carNames.size) { numberGenerate() }

                cars.moveAll(moveConditions)
                RaceRound(cars.deepCopy())
            },
        )
    }
}
