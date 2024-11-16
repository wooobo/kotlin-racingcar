package race.domain

data class CarName(val name: String) {
    init {
        require(name.isNotBlank()) { "공백이 아닌 문자열 이어야 합니다." }
        require(name.length <= MAX_NAME_LENGTH) { "{$MAX_NAME_LENGTH}자 이하로 입력해주세요." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
