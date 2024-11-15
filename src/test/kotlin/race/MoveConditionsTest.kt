package race

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class MoveConditionsTest {
    @Test
    fun `MoveConditions 은 갯수만큼 생성한다`() {
        assertDoesNotThrow { MoveConditions(3) { PositiveNumber(1) } }
    }
}
