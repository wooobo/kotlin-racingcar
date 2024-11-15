package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest {
    @Test
    fun `생성자에 람다식 주입 가능`() {
        val testProcessor =
            InputView(
                "",
                readInput = { "5" },
            )

        val result = testProcessor.processInput()

        assertThat(result).isEqualTo("5")
    }
}
