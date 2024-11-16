package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import race.domain.PositiveNumber
import race.sevice.RandomGenerator

class NumberGeneratorTest {
    @Test
    fun `랜덤값 반환 타입은 PositiveNumber`() {
        val randomGenerate = RandomGenerator()

        assertAll(
            { assertThat(randomGenerate.generate()).isInstanceOf(PositiveNumber::class.java) },
        )
    }
}
