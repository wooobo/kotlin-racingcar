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
        carCount: String,
        retryCount: String,
    ) {
        val carCountView =
            InputView(
                "",
                readInput = { carCount },
            )
        val retryCountView =
            InputView(
                "",
                readInput = { retryCount },
            )

        val resultView = RaceResultView()
        val raceBoard = RaceBoard(carCountView, retryCountView, resultView)

        raceBoard.start()
    }
}
