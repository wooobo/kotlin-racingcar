package calculate

class Nodes(values: List<String>) {
    private val nodes = values.map { Node(it) }

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
        var result = firstNode()

        nodes.drop(1)
            .chunked(CHUNK_SIZE)
            .forEach { chunk ->
                val (operationNode, rightNode) = chunk
                result = result.calculate(operationNode.findOperation(), rightNode)
            }

        return result
    }

    private fun firstNode() = nodes.firstOrNull() ?: throw IllegalStateException("No nodes available")
}
