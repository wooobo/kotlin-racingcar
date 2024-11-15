package race

class MoveConditions(val values: List<MoveCondition>) {
    val size: Int
        get() = values.size

    constructor(count: Int, generator: NumberGenerator) : this(List(count) { MoveCondition(generator()) })
}
