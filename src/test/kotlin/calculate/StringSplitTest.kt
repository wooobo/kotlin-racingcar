package calculate

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIOException
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.IOException

class StringSplitTest {
    @Test
    fun `문자열 구분자로 나눌수있다`() {
        val input = "1 + 1"

        val result = input.split(" ")

        assertThat(listOf("1", "+", "1")).isEqualTo(result)
    }

    @Test
    fun `다중 구분자 나눠보기`() {
        val input = "1+1-1/13"

        val actual1 = input.split("+")
        val actual2 = actual1[1].split("-")
        val actual3 = actual2[1].split("/")

        assertAll(
            { assertThat(listOf("1", "1-1/13")).isEqualTo(actual1) },
            { assertThat(listOf("1", "1/13")).isEqualTo(actual2) },
            { assertThat(listOf("1", "13")).isEqualTo(actual3) },
        )
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "\t", "\n"])
    fun isBlank_ShouldReturnTrueForNullOrBlankStrings(input: String) {
        assertTrue(input.isBlank())
    }

    @ParameterizedTest
    @CsvSource(value = ["1+1|+", "1-1|-"], delimiter = '|')
    fun `CsvSource 활용해보기`(
        input: String,
        operator: String,
    ) {
        val actual = input.split(operator)

        assertThat(listOf("1", "1")).isEqualTo(actual)
    }

    @Test
    fun `예외발생 검증해보기`() {
        val input = "1+1"

        val actual = input.split(" ")

        assertThatThrownBy { actual[1] }
            .isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasMessage("Index: 1, Size: 1")
        assertThatExceptionOfType(java.lang.IndexOutOfBoundsException::class.java)
            .isThrownBy {
                actual[1]
            }.withMessage("Index: 1, Size: 1")
        assertThatIOException().isThrownBy {
            throw IOException("IO 에러 발생!")
        }
    }
}
