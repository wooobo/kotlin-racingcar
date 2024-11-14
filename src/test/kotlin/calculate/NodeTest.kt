package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NodeTest {
    @Test
    fun `덧셈을 한다`() {
        val node = Node.OperandNode(2)
        val operator = Node.OperatorNode(Operation.PLUS)

        val actual = operator.calculate(node, Node.OperandNode(3))

        assertThat(actual).isEqualTo(Node.OperandNode(5))
    }

    @Test
    fun `뺄셈을 한다`() {
        val node = Node.OperandNode(5)
        val operator = Node.OperatorNode(Operation.MINUS)

        val actual = operator.calculate(node, Node.OperandNode(3))

        assertThat(actual).isEqualTo(Node.OperandNode(2))
    }

    @Test
    fun `곱셈을 한다`() {
        val node = Node.OperandNode(2)
        val operator = Node.OperatorNode(Operation.MULTIPLY)

        val actual = operator.calculate(node, Node.OperandNode(3))

        assertThat(actual).isEqualTo(Node.OperandNode(6))
    }

    @Test
    fun `나눗셈을 한다`() {
        val node = Node.OperandNode(6)
        val operator = Node.OperatorNode(Operation.DIVIDE)

        val actual = operator.calculate(node, Node.OperandNode(3))

        assertThat(actual).isEqualTo(Node.OperandNode(2))
    }

    @Test
    fun `OperatorNode 계산 가능하다`() {
        val operator = Node.OperatorNode(Operation.PLUS)

        val actual = operator.calculate(Node.OperandNode(1), Node.OperandNode(2))

        assertThat(actual).isEqualTo(Node.OperandNode(3))
    }
}
