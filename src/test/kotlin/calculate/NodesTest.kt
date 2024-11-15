package calculate

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource

class NodesTest {
    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, 10",
        "2 - 3, -1",
        "2 * 3, 6",
        "6 / 2, 3",
    )
    fun `순차 계산한다`(
        query: String,
        expected: Int,
    ) {
        val nodes = Nodes(query)

        val actual = nodes.calculate()

        assertThat(actual).isEqualTo(Node.OperandNode(expected))
    }

    @Test
    fun `잘못된 값은 에러 발생한다`() {
        assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                Nodes("2 3 3").calculate()
            }
    }

    @ParameterizedTest
    @EmptySource
    fun `빈 값은 에러 발생한다`(query: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                Nodes(query)
            }
    }
}
