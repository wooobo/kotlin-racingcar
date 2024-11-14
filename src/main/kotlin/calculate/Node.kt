package calculate

data class Node(val value: String) {
    fun calculate(
        operation: Operation,
        operand: Node,
    ): Node {
        val result = operation.apply(toInt(), operand.toInt())
        return Node(result.toString())
    }

    fun findOperation(): Operation {
        return Operation.ofSymbol(value)
    }

    private fun toInt(): Int {
        return value.toInt()
    }
}
