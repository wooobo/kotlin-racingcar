package race

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CarsTest {
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

    @Test
    fun `Cars는 최소 1대 이상 입력해야 한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Cars.from(PositiveNumber(0))
        }
    }
}
