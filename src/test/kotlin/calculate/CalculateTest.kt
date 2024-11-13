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
        var result = nodes[0].toInt()

        for (i in nodes.indices step 2) {
            if (i == nodeSize - 1) break
            val operation = nodes[i + 1]
            val second = nodes[i + 2].toInt()
            result = performCalculation(result.toString(), operation, second.toString()).toInt()
        }

        assertThat(result).isEqualTo(10)
    }

    private fun performCalculation(
        first: String,
        operation: String,
        second: String,
    ): String {
        return when (operation) {
            "+" -> (first.toInt() + second.toInt()).toString()
            "-" -> (first.toInt() - second.toInt()).toString()
            "*" -> (first.toInt() * second.toInt()).toString()
            "/" -> (first.toInt() / second.toInt()).toString()
            else -> throw IllegalArgumentException("Unknown operation: $operation")
        }
    }
}
