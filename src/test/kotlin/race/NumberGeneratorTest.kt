package race

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5])
    fun `람다식 고정된 값 반환 확인`(value: Int) {
        val testGenerator: NumberGenerate = {
            PositiveNumber(value)
        }

        assertThat(testGenerator()).isEqualTo(PositiveNumber(value))
    }

    @Test
    fun `랜덤한 값 반환 확인`() {
        val randomGenerate = RandomGenerate(0, 5)

        assertAll(
            { assertThat(randomGenerate.generate()).isInstanceOf(PositiveNumber::class.java) },
            { assertTrue(randomGenerate.generate().value in 0..5) },
        )
    }

    @Test
    fun `시작값이 종료값보다 클 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            RandomGenerate(5, 0)
        }
    }
}
