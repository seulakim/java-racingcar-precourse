package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputUtilTest {

	InputUtil inputUtil;

	@BeforeEach
	void beforeEach() {
		inputUtil = new InputUtil();
	}

	@Test
	void 숫자_검사() {
		assertThat(inputUtil.validateNumber("10")).isEqualTo(10);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> inputUtil.validateNumber("숫자"));
	}
}
