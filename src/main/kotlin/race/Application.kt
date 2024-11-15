package race

fun main() {
    val carCountView = InputView("자동차 대수는 몇 대 인가요?")
    val retryCountView = InputView("시도할 회수는 몇 회 인가요?")
    val resultView = RaceResultView()

    val raceBoard = RaceBoard(carCountView.processInputToInto(), retryCountView.processInputToInto(), resultView)
    raceBoard.start()
}
