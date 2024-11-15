package calculate

enum class Operation(val symbol: String, val apply: (Int, Int) -> Int) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    MULTIPLY("*", { first, second -> first * second }),
    DIVIDE("/", { first, second -> first / second }),
    NONE("", { _, _ -> throw IllegalArgumentException("Unknown operation") }),
    ;

    companion object {
        fun ofSymbol(symbol: String): Operation {
            return entries.find {
                it.symbol == symbol
            }
                ?: NONE
        }
    }
}
