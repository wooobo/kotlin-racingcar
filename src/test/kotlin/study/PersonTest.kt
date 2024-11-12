package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", nickname = "길동", age = 20)

        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.nickname).isEqualTo("길동")
        assertThat(actual.age).isEqualTo(20)
    }

    @Test
    fun `널 타입`() {
        val actual = Person("Jack", 99, null)

        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "Jack", age = 99)

        assertThat(actual.nickname).isEqualTo("Jack")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("Jack", 99)
        val person2 = Person("Jack", 99)

        assertThat(person1).isEqualTo(person2)
    }
}
