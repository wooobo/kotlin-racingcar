package calculate

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperationTest {
    @Test
    fun `덧셈 가능`() {
        val first = 1
        val second = 2
        val operation = Operation.PLUS

        val actual = operation.apply(first, second)

        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `뺄셈 가능`() {
        val first = 3
        val second = 2
        val operation = Operation.MINUS

        val actual = operation.apply(first, second)

        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `곱셈 가능`() {
        val first = 3
        val second = 2
        val operation = Operation.MULTIPLY

        val actual = operation.apply(first, second)

        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `나눗셈 가능`() {
        val first = 6
        val second = 2
        val operation = Operation.DIVIDE

        val actual = operation.apply(first, second)

        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `알 수 없는 연산자`() {
        val first = 1
        val second = 2
        val operation = Operation.NONE

        assertThatThrownBy { operation.apply(first, second) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Unknown operation")
    }
}
