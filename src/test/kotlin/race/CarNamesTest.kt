package race

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import race.domain.CarName
import race.domain.CarNames

class CarNamesTest {
    @Test
    fun `CarNames 는 이름을 가지고 있다`() {
        val actual = CarNames.from(listOf("a", "b", "c"))

        val expected = CarNames(listOf(CarName("a"), CarName("b"), CarName("c")))

        assertEquals((actual), expected)
    }

    @Test
    fun `CarNames 는 중복된 이름을 가질 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            CarNames.from(listOf("a", "b", "a"))
        }
    }
}
