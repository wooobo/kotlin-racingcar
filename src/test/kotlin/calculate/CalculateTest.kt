package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculateTest {
    @Test
    fun `숫자를 순서대로 계산한다`() {
        val expression = "2 + 3 * 4 / 2".trim().replace(" ", "")

        var currentResult = 0
        var secondOperand = 0
        var pendingOperation = Operation.NONE
        for ((index, currentChar) in expression.withIndex()) {
            if (index == 0) {
                currentResult = currentChar.toString().toInt()
                continue
            }

            if (currentChar.isDigit()) {
                val number = currentChar.toString().toInt()
                if (currentResult == 0) {
                    currentResult = number
                } else {
                    secondOperand = number
                }

                currentResult = pendingOperation.calculate(currentResult, secondOperand)
                secondOperand = 0
                pendingOperation = Operation.NONE
            } else {
                pendingOperation = Operation.findBy(currentChar.toString())
            }
        }

        assertThat(currentResult).isEqualTo(10)
    }
}
