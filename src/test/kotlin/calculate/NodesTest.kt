package calculate

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class NodesTest {
    @Test
    fun `순차 계산한다`() {
        val query = "2 + 3 * 4 / 2"
        val nodes = Nodes(query)

        val actual = nodes.calculate()

        assertThat(actual).isEqualTo(Node("10"))
    }

    @Test
    fun `빈 값은 에러 발생한다`() {
        val query = ""

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                Nodes(query)
            }
    }
}
