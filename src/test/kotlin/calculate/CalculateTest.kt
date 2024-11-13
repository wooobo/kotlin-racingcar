package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculateTest {
    @Test
    fun `순차 계산한다`() {
        val query = "2 + 3 * 4 / 2"
        val delimiter = " "
        val nodes = query.split(delimiter)
        val nodeSize = nodes.size
        var result = Node(nodes[0])

        for (i in nodes.indices step 2) {
            if (i == nodeSize - 1) break
            val operationNode = Node(nodes[i + 1])
            val second = Node(nodes[i + 2])
            result = operationNode.calculate(result, second)
        }

        assertThat(result).isEqualTo(Node("10"))
    }
}
