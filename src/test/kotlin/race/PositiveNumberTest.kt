package race

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class PositiveNumberTest {
    @Test
    fun `음수를 입력하면 IllegalArgumentException이 발생한다`() {
        val negativeNumber = -1

        assertThatIllegalArgumentException().isThrownBy {
            PositiveNumber(negativeNumber)
        }
    }

    @Test
    fun `매개변수와 같거나 큰지 비교 가능 `() {
        val first = PositiveNumber(1)
        val second = PositiveNumber(2)

        val actual = first.isGreaterThanOrEqual(second)

        assertThat(actual).isFalse()
    }
}
