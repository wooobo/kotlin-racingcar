package race.domain

class Cars(private val cars: List<Car>) : List<Car> by cars {
    init {
        require(cars.isNotEmpty()) { "최소 1대 이상 입력 해주세요." }
    }

    constructor(carCount: PositiveNumber) : this(List(carCount.value) { Car("a", 1) })
    constructor(carNames: CarNames) : this(carNames.map { Car(it.name, 1) })

    fun moveAll(moveConditions: MoveConditions) {
        validMoveCondition(moveConditions)

        cars.zip(moveConditions.values)
            .forEach { (moveCar, moveCondition) ->
                move(moveCar, moveCondition)
            }
    }

    fun deepCopy(): Cars {
        val copiedCars = cars.map { car -> car.copy() }
        return Cars(copiedCars)
    }

    private fun move(
        moveCar: Car,
        moveCondition: MoveCondition,
    ) {
        if (moveCondition.shouldMove()) {
            moveCar.move()
        }
    }

    private fun validMoveCondition(moveConditions: MoveConditions) {
        require(moveConditions.size == size) { "Car의 갯수와 moveCondition의 갯수가 다릅니다." }
    }
}
