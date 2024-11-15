package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CarsTest {
    @Test
    fun `Cars는 Car를 전진시킬수 있다`() {
        val car1 = Car(PositiveNumber(0))
        val car2 = Car(PositiveNumber(0))
        val cars = Cars(listOf(car1, car2))

        cars.move(car1, PositiveNumber(4))
        cars.move(car2, PositiveNumber(5))

        assertAll(
            { assertThat(car1).isEqualTo(Car(PositiveNumber(1))) },
            { assertThat(car2).isEqualTo(Car(PositiveNumber(1))) },
        )
    }

    @Test
    fun `moveAll은 주어진 이동 조건에 따라 움직인다`() {
        val cars = Cars.from(PositiveNumber(4))
        val moveConditions =
            listOf(
                PositiveNumber(4),
                PositiveNumber(3),
                PositiveNumber(5),
                PositiveNumber(2),
            )

        cars.moveAll(moveConditions)

        val expectedPositions = listOf(2, 1, 2, 1)
        cars.forEachIndexed { index, car ->
            assertThat(car).isEqualTo(Car(PositiveNumber(expectedPositions[index])))
        }
    }
}
