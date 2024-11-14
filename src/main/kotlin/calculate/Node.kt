package calculate

sealed interface Node {
    data class OperandNode(val value: Int) : Node

    data class OperatorNode(val operation: Operation) : Node {
        fun calculate(
            left: OperandNode,
            right: OperandNode,
        ): OperandNode {
            val result = operation.apply(left.value, right.value)
            return OperandNode(result)
        }
    }
}
