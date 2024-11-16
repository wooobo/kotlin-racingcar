package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import race.domain.PositiveNumber
import race.sevice.RaceBoard

class RaceBoardTest {
    @ParameterizedTest
    @CsvSource(
        "a,b| 9",
        "c,d| 3",
        "e,f| 2",
        delimiter = '|',
    )
    fun `start 시도횟수 만큼 라운드를 반환한다`(
        nameCsv: String,
        retryCount: Int,
    ) {
        val raceBoard = RaceBoard(nameCsv.split(","), retryCount) { PositiveNumber(5) }

        val actual = raceBoard.start()

        assertThat(actual.rounds).hasSize(retryCount)
    }
}
