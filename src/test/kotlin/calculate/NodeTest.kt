package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NodeTest {
    @Test
    fun `연산자를 찾는다`() {
        val node = Node("+")

        val actual = node.findOperation()

        assertThat(actual).isEqualTo(Operation.PLUS)
    }

    @Test
    fun `덧셈을 한다`() {
        val node = Node("2")

        val actual = node.calculate(Operation.PLUS, Node("3"))

        assertThat(actual).isEqualTo(Node("5"))
    }

    @Test
    fun `뺄셈을 한다`() {
        val node = Node("5")

        val actual = node.calculate(Operation.MINUS, Node("3"))

        assertThat(actual).isEqualTo(Node("2"))
    }

    @Test
    fun `곱셈을 한다`() {
        val node = Node("2")

        val actual = node.calculate(Operation.MULTIPLY, Node("3"))

        assertThat(actual).isEqualTo(Node("6"))
    }

    @Test
    fun `나눗셈을 한다`() {
        val node = Node("6")

        val actual = node.calculate(Operation.DIVIDE, Node("3"))

        assertThat(actual).isEqualTo(Node("2"))
    }
}
