package race

data class RandomGenerate(
    private val start: Int,
    private val end: Int,
) {
    init {
        require(start <= end) { "시작값은 종료값보다 클 수 없습니다" }
    }

    fun generate(): PositiveNumber {
        return PositiveNumber((start..end).random())
    }
}
