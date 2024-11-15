package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NodeTest {
    /**
     * @see Operation 요소가 추가 되었을 때, 테스트 코드를 추가 해야 한다.
     */
    @ParameterizedTest
    @CsvSource("1,PLUS,1,2", "2, MINUS, 1, 1", "3, MULTIPLY, 2, 6", "4, DIVIDE, 2, 2")
    fun `사칙연산 가능하다`(
        a: Int,
        operator: Operation,
        b: Int,
        expected: Int,
    ) {
        val node = Node.OperandNode(a)
        val operatorNode = Node.OperatorNode(operator)

        val actual = operatorNode.calculate(node, Node.OperandNode(b))

        assertThat(actual).isEqualTo(Node.OperandNode(expected))
    }
}
