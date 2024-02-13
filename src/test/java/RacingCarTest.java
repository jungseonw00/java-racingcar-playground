import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

	@ParameterizedTest
	@ValueSource(strings = {"포르쉐", "벤츠", "BMW", "람보르기니"})
	@DisplayName("자동차 이름은 5자를 초과할 수 없다._성공 테스트")
	void specifyCarName(String carName) {
		RacingCar racingCar = new RacingCar();
		assertThat(racingCar.specifyCarName(carName)).isTrue();
	}

	@Test
	@DisplayName("자동차 이름은 5자를 초과할 수 없다._실패 테스트")
	void specifyCarName_fail() {
		String carName = "레인지로버 이보크";
		RacingCar racingCar = new RacingCar();
		assertThatThrownBy(() -> racingCar.specifyCarName(carName)).isInstanceOf(
			RuntimeException.class);
	}

	@Test
	@DisplayName("자동차 이름은 쉼표로 구분한다.")
	void createRandomValue() {
		RacingCar racingCar = new RacingCar();
		racingCar.specifyCarName("포르쉐, 벤츠, BMW");
		assertThat(racingCar.getCarName()).containsKeys("포르쉐", "벤츠", "BMW");
	}

	@Test
	void startCar() {
		// given
		RacingCar racingCar = new RacingCar();
		racingCar.specifyCarName("선우,미래,양현");
		racingCar.validateNumberOfMatches("5");
		racingCar.startCar();
	}

	@Test
	@DisplayName("num값 만큼 하이픈을 생성해 반환한다.")
	void drawHyphen() {
	    // given
		RacingCar racingCar = new RacingCar();
		String hyphen = racingCar.drawHyphen(10);
		assertThat(hyphen).hasSize(10);
	}
}
