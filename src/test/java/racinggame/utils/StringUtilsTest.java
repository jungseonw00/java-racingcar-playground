package racinggame.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racinggame.domain.RacingGame;

class StringUtilsTest {

	@Test
	void stringUtilsTest() {
		String name = "";
	    // given
		assertThatThrownBy(() ->
			new RacingGame(name, 0)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void exceedNameLength() {
		String name = "가나다라마바사";
	    // given
		assertThatThrownBy(() ->
			StringUtils.isBlank(name)).isInstanceOf(IllegalArgumentException.class);
	}
}