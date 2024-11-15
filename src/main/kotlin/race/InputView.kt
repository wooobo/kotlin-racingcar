package race

typealias InputReader = () -> String

class InputView(
    private val message: String,
    private val readInput: InputReader = ::readln,
) {
    fun processInput(): String {
        println(message)
        return readInput()
    }

    fun processInputToInto(): Int {
        return processInput().toIntOrNull() ?: throw IllegalArgumentException("정수를 입력해주세요.")
    }
}
