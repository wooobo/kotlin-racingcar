package race

typealias InputReader = () -> String

class InputView(
    private val readInput: InputReader = ::readln,
) {
    fun processInput(message: String): String {
        println(message)
        return readInput()
    }
}
