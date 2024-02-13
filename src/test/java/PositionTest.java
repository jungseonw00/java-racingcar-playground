import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racinggame.domain.Position;

public class PositionTest {

	@Test
	void create() {
		Position position = new Position(3);
		assertThat(position).isEqualTo(new Position(3));
	}

	@Test
	void valid() {
		assertThatThrownBy(() -> {
			new Position(-1);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
