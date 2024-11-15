package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RaceBoardTest {
    @ParameterizedTest
    @CsvSource(
        "4, 9",
        "5, 3",
        "1, 2",
        delimiter = ',',
    )
    fun `start 시도횟수 만큼 라운드를 반환한다`(
        carCount: Int,
        retryCount: Int,
    ) {
        val raceBoard = RaceBoard(carCount, retryCount) { PositiveNumber(1) }

        val actual = raceBoard.start()

        assertThat(actual.rounds).hasSize(retryCount)
    }
}
