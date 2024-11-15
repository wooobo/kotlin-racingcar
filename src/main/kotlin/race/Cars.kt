package race

class Cars(private val cars: List<Car>) : List<Car> by cars {
    init {
        require(cars.isNotEmpty()) { "최소 1대 이상 입력 해주세요." }
    }

    companion object {
        private val MOVE_CONDITION = PositiveNumber(4)

        fun from(positiveNumber: PositiveNumber): Cars {
            return Cars(List(positiveNumber.value) { Car(PositiveNumber(1)) })
        }
    }

    fun moveAll(moveConditions: List<PositiveNumber>) {
        cars.forEachIndexed { index, car ->
            move(car, moveConditions[index])
        }
    }

    private fun move(
        moveCar: Car,
        moveCondition: PositiveNumber,
    ) {
        if (moveCondition.isGreaterThanOrEqual(MOVE_CONDITION)) {
            moveCar.move()
        }
    }
}
