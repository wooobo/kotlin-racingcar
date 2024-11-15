package race

class Car(var position: PositiveNumber) {
    fun move() {
        position += PositiveNumber(1)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return position == other.position
    }

    override fun hashCode(): Int {
        return position.hashCode()
    }
}
