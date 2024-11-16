package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import race.domain.Car
import race.sevice.RaceResult
import race.sevice.RaceRound

class RaceResultTest {
    @Test
    fun `우승자 1명`() {
        val raceRound =
            RaceRound(
                listOf(
                    Car("a", 5),
                    Car("b", 4),
                    Car("c", 3),
                ),
            )
        val raceResult = RaceResult(listOf(raceRound))

        val actual = raceResult.winners

        assertThat(actual).containsExactly("a")
    }

    @Test
    fun `다중 우승자`() {
        val raceRound =
            RaceRound(
                listOf(
                    Car("a", 5),
                    Car("b", 5),
                    Car("c", 3),
                ),
            )
        val raceResult = RaceResult(listOf(raceRound))

        val actual = raceResult.winners

        assertThat(actual).containsExactly("a", "b")
    }
}
