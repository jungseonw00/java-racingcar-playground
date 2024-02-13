package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void positionTest() {
	    // given
	    assertThatThrownBy(() -> {
			new Position(-3);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("position은 음수 값을 가질 수 없습니다.");
	}
}
