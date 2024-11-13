package calculate

enum class Operation(val symbol: String) {
    PLUS("+") {
        override fun apply(
            first: Int,
            second: Int,
        ): Int {
            return first + second
        }
    },
    MINUS("-") {
        override fun apply(
            first: Int,
            second: Int,
        ): Int {
            return first - second
        }
    },
    MULTIPLY("*") {
        override fun apply(
            first: Int,
            second: Int,
        ): Int {
            return first * second
        }
    },
    DIVIDE("/") {
        override fun apply(
            first: Int,
            second: Int,
        ): Int {
            return first / second
        }
    },
    NONE("") {
        override fun apply(
            first: Int,
            second: Int,
        ): Int = throw IllegalArgumentException("Unknown operation")
    }, ;

    abstract fun apply(
        first: Int,
        second: Int,
    ): Int

    companion object {
        fun ofSymbol(symbol: String): Operation {
            return entries.find {
                it.symbol == symbol
            }
                ?: NONE
        }
    }
}
