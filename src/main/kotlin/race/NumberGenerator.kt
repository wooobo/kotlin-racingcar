package race

typealias NumberGenerate = () -> PositiveNumber

data class RandomGenerate(
    private val start: Int,
    private val end: Int,
    val generate: NumberGenerate = { PositiveNumber((start..end).random()) },
) {
    init {
        require(start <= end) { "시작값은 종료값보다 클 수 없습니다" }
    }
}
