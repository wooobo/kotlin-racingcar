package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NodeTest {
    @ParameterizedTest
    @CsvSource("1,1,2", "2,3,5", "3,4,7")
    fun `덧셈을 한다`(
        a: Int,
        b: Int,
        expected: Int,
    ) {
        val node = Node.OperandNode(a)
        val operator = Node.OperatorNode(Operation.PLUS)

        val actual = operator.calculate(node, Node.OperandNode(b))

        assertThat(actual).isEqualTo(Node.OperandNode(expected))
    }

    @ParameterizedTest
    @CsvSource("1,1,0", "2,3,-1", "3,4,-1")
    fun `뺄셈을 한다`(
        a: Int,
        b: Int,
        expected: Int,
    ) {
        val node = Node.OperandNode(a)
        val operator = Node.OperatorNode(Operation.MINUS)

        val actual = operator.calculate(node, Node.OperandNode(b))

        assertThat(actual).isEqualTo(Node.OperandNode(expected))
    }

    @ParameterizedTest
    @CsvSource("1,1,1", "2,3,6", "3,4,12")
    fun `곱셈을 한다`(
        a: Int,
        b: Int,
        expected: Int,
    ) {
        val node = Node.OperandNode(a)
        val operator = Node.OperatorNode(Operation.MULTIPLY)

        val actual = operator.calculate(node, Node.OperandNode(b))

        assertThat(actual).isEqualTo(Node.OperandNode(expected))
    }

    @ParameterizedTest
    @CsvSource("1,1,1", "8,4,2", "4,4,1")
    fun `나눗셈을 한다`(
        a: Int,
        b: Int,
        expected: Int,
    ) {
        val node = Node.OperandNode(a)
        val operator = Node.OperatorNode(Operation.DIVIDE)

        val actual = operator.calculate(node, Node.OperandNode(b))

        assertThat(actual).isEqualTo(Node.OperandNode(expected))
    }

    @ParameterizedTest
    @CsvSource("1,2,+,3", "2,3,+,5", "3,4,+,7")
    fun `OperatorNode 계산 가능하다`(
        a: Int,
        b: Int,
        operation: String,
        expected: Int,
    ) {
        val operator = Node.OperatorNode(Operation.ofSymbol(operation))

        val actual = operator.calculate(Node.OperandNode(a), Node.OperandNode(b))

        assertThat(actual).isEqualTo(Node.OperandNode(expected))
    }
}
