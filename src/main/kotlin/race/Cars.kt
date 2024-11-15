package race

class Cars(private val cars: List<Car>) : List<Car> by cars {
    companion object {
        private val MOVE_CONDITION = PositiveNumber(4)

        fun from(positiveNumber: PositiveNumber): Cars {
            return Cars(List(positiveNumber.value) { Car(PositiveNumber(1)) })
        }
    }

    fun move(
        moveCar: Car,
        moveCondition: PositiveNumber,
    ) {
        if (moveCondition.isGreaterThanOrEqual(MOVE_CONDITION)) {
            moveCar.move()
        }
    }

    fun moveAll(moveConditions: List<PositiveNumber>) {
        cars.forEachIndexed { index, car ->
            move(car, moveConditions[index])
        }
    }
}
