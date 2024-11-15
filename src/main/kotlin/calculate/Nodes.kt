package calculate

class Nodes(values: List<String>) {
    private val nodes: List<Node> =
        values.map {
            if (it.toIntOrNull() != null) {
                Node.OperandNode(it.toInt())
            } else {
                Node.OperatorNode(Operation.ofSymbol(it))
            }
        }

    companion object {
        private const val CHUNK_SIZE = 2
        private const val DELIMITER = " "
    }

    constructor(values: String) : this(
        if (values.isEmpty()) {
            throw IllegalArgumentException("values is empty")
        } else {
            values.split(DELIMITER)
        },
    )

    fun calculate(): Node {
        return nodes.drop(1)
            .chunked(CHUNK_SIZE)
            .fold(firstNode()) { acc, (leftOperand, rightOperand) ->
                when (leftOperand) {
                    is Node.OperatorNode -> leftOperand.calculate(acc as Node.OperandNode, rightOperand as Node.OperandNode)
                    else -> error("Invalid node")
                }
            }
    }

    private fun firstNode() = nodes.firstOrNull() ?: throw IllegalStateException("No nodes available")
}
