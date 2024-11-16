package race

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.provider.EmptySource
import race.domain.CarName

class CarNameTest {
    @Test
    fun `6자 초과시 예외발생`() {
        assertThrows<IllegalArgumentException> {
            CarName("1234567")
        }
    }

    @Test
    @EmptySource
    fun `빈 문자열 입력시 예외발생`() {
        assertThrows<IllegalArgumentException> {
            CarName("")
        }
    }
}
