import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

	@Test
	void splitAndSum_작동_검증() {
		assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
		assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
		assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
		assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
		assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
		assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
