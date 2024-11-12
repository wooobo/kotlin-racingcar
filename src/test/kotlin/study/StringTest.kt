package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class StringTest {
    @Test
    fun isBlack() {
        val actual = "".isBlank()

        assertAll(
            { assertThat(actual).isTrue() },
            { assertThat("\n".isBlank()).isTrue() },
            { assertThat("\t".isBlank()).isTrue() },
            { assertThat("""\n""".isBlank()).isFalse() },
        )
    }
}
