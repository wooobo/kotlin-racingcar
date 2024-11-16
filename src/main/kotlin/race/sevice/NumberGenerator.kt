package race.sevice

import race.domain.PositiveNumber

typealias NumberGenerator = () -> PositiveNumber

data class RandomGenerator(
    val generate: NumberGenerator = { PositiveNumber((RANDOM_START..RANDOM_END).random()) },
) {
    companion object {
        private const val RANDOM_START = 0
        private const val RANDOM_END = 9
    }
}
