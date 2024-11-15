package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["0,1", "2,3"], delimiter = ',')
    fun `자동차 전진 가능`(
        position: Int,
        expected: Int,
    ) {
        val car = Car(PositiveNumber(position))

        car.move()

        assertThat(car).isEqualTo(Car(PositiveNumber(expected)))
    }
}
