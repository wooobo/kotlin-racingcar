package race

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
    fun `start 실행시 문제없이 작동하여야 한다`(
        carCount: Int,
        retryCount: Int,
    ) {
        val raceBoard = RaceBoard(carCount, retryCount)

        raceBoard.start()
    }
}
