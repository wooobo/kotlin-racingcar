package race

fun main() {
    val carCountView = InputView("자동차 대수는 몇 대인가요?")
    val retryCountView = InputView("시도할 횟수는 몇 회인가요?")
    val resultView = RaceResultView()

    val raceRoundResult = RaceBoard(carCountView.processInputToInto(), retryCountView.processInputToInto())

    resultView.printResult(raceRoundResult)
}
