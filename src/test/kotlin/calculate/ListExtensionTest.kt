package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ListExtensionTest {
    @Test
    fun `groupBy 그룹핑한다`() {
        val actual =
            listOf(1, 2, 3, 4, 5)
                .groupBy { it % 2 == 0 }

        assertAll(
            { assertThat(actual[true]).containsExactly(2, 4) },
            { assertThat(actual[false]).containsExactly(1, 3, 5) },
        )
    }

    @Test
    fun `partition 조건에 따라 리스트를 분할`() {
        val (actual1, actual2) =
            listOf(1, 2, 3, 4, 5)
                .partition { it % 2 == 0 }

        assertAll(
            { assertThat(actual1).containsExactly(2, 4) },
            { assertThat(actual2).containsExactly(1, 3, 5) },
            { assertThat(actual1::class).isEqualTo(java.util.ArrayList::class) },
            { assertThat(actual2::class).isEqualTo(java.util.ArrayList::class) },
        )
    }

    @Test
    fun `flatMap or flatten 함수 중첩 리스트 평탄화`() {
        val actual =
            listOf(listOf(1, 2), listOf(3, 4))
                .flatten() // .flatMap { it }

        assertAll(
            { assertThat(actual).containsExactly(1, 2, 3, 4) },
            { assertThat(actual::class).isEqualTo(java.util.ArrayList::class) },
        )
    }

    @Test
    fun `filterIndexed 함수 인덱스와 함께 필터링한다`() {
        val actual =
            listOf(1, 2, 3, 4, 5)
                .filterIndexed { index, value -> index % 2 == 0 && value % 2 == 1 }

        assertAll(
            { assertThat(actual).containsExactly(1, 3, 5) },
            { assertThat(actual::class).isEqualTo(java.util.ArrayList::class) },
        )
    }

    @Test
    fun `filterIsInstance 함수 타입에 맞는 요소만 남긴다`() {
        val actual =
            listOf(1, ",", 2, ",", 3)
                .filterIsInstance<Int>()

        assertAll(
            { assertThat(actual).containsExactly(1, 2, 3) },
            { assertThat(actual::class).isEqualTo(java.util.ArrayList::class) },
        )
    }

    @Test
    fun `filterNot 함수 조건 요소만 제외한다`() {
        val actual =
            listOf(1, 2, 3, 4, 5)
                .filterNot { it % 2 == 0 }

        assertAll(
            { assertThat(actual).containsExactly(1, 3, 5) },
            { assertThat(actual::class).isEqualTo(java.util.ArrayList::class) },
        )
    }

    @Test
    fun `filter 함수 조건 요소만 남긴다`() {
        val actual =
            listOf(1, 2, 3, 4, 5)
                .filter { it % 2 == 0 }

        assertAll(
            { assertThat(actual).containsExactly(2, 4) },
            { assertThat(actual::class).isEqualTo(java.util.ArrayList::class) },
        )
    }

    @Test
    fun `fold 함수를 사용하면 초기값을 부여할 수 있다`() {
        val words = listOf("How", "do")
        val sentence =
            words.fold("comment:") { acc, word ->
                "$acc $word"
            }.trim()

        assertThat(sentence).isEqualTo("comment: How do")
    }

    @Test
    fun `chunked 함수를 사용하면 리스트를 나눌 수 있다`() {
        val actual =
            listOf(1, 2, 3, 4, 5)
                .chunked(2)

        assertAll(
            { assertThat(actual[0]).containsExactly(1, 2) },
            { assertThat(actual[1]).containsExactly(3, 4) },
            { assertThat(actual[2]).containsExactly(5) },
        )
    }
}
