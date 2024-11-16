package race

import race.sevice.RaceBoard
import race.sevice.RandomGenerator
import race.ui.InputView
import race.ui.RaceResultView

fun main() {
    val carNameView = InputView("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val retryCountView = InputView("시도할 횟수는 몇 회인가요?")

    val game =
        RaceBoard(
            carNameView.processInput().split(","),
            retryCountView.processInputToInto(),
        ) { RandomGenerator().generate() }

    RaceResultView.printResult(game.start())
}
