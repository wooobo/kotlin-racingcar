package race.domain

data class Car(val carName: CarName, var position: PositiveNumber) {
    val progress: Int
        get() = position.value
    val displayName: String
        get() = carName.name

    constructor(name: String, position: Int) : this(CarName(name), PositiveNumber(position))

    fun move() {
        this.position += PositiveNumber(MOVE_POSITION)
    }

    companion object {
        private const val MOVE_POSITION = 1
    }
}
