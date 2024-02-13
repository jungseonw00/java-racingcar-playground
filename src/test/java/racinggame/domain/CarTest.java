package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 이동() {
	    // given
	    Car car = new Car("pobi");
		car.move(4);
	    assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void 이동안함() {
		// given
		Car car = new Car("pobi");
		car.move(3);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	void namingCar() {
		assertThat(new Car("람보르기니")).isEqualTo((new Car("람보르기니")));
	}

	@Test
	void namingCar_fail() {
	    // given
	    assertThatThrownBy(() -> new Car("람보르기니우루스")).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
	}
}