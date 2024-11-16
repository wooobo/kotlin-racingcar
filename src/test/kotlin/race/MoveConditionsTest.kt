package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import race.domain.MoveConditions
import race.domain.PositiveNumber

class MoveConditionsTest {
    @Test
    fun `MoveConditions 은 갯수만큼 생성한다`() {
        val moveConditions = MoveConditions(3) { PositiveNumber(1) }

        val size = moveConditions.size

        assertThat(size).isEqualTo(3)
    }
}
