package calculate

data class Node(val value: String) {
    fun calculate(
        first: Node,
        second: Node,
    ): Node {
        val result = findOperation().apply(first.toInt(), second.toInt())
        return Node(result.toString())
    }

    private fun findOperation(): Operation {
        return Operation.ofSymbol(value)
    }

    private fun toInt(): Int {
        return value.toInt()
    }
}
