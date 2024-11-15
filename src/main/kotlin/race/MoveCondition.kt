package race

class MoveCondition(private val value: PositiveNumber) {
    companion object {
        private val MOVE_CONDITION = PositiveNumber(4)
    }

    fun shouldMove(): Boolean {
        return value.isGreaterThanOrEqual(MOVE_CONDITION)
    }
}
