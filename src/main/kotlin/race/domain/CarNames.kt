package race.domain

data class CarNames(val names: List<CarName>) : List<CarName> by names {
    init {
        require(names.size == names.distinct().size) { "중복된 이름이 있습니다." }
    }

    companion object {
        fun from(names: List<String>): CarNames {
            return CarNames(names.map { CarName(it) })
        }
    }
}
