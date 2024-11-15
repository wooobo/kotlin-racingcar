package race

typealias NumberGenerator = () -> PositiveNumber

data class RandomGenerate(
    val generate: NumberGenerator = { PositiveNumber((RANDOM_START..RANDOM_END).random()) },
) {
    companion object {
        private const val RANDOM_START = 0
        private const val RANDOM_END = 9
    }
}
