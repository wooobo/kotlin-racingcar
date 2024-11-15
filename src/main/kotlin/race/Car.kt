package race

data class Car(var position: PositiveNumber) {
    constructor(position: Int) : this(PositiveNumber(position))

    companion object {
        private const val MOVE_POSITION = 1
    }

    fun move() {
        this.position += PositiveNumber(MOVE_POSITION)
    }
}
