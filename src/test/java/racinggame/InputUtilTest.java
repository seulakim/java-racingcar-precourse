package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	void 리스트를_문자열로() {
		List<String> stringList = new ArrayList<>();
		stringList.add("string1");
		stringList.add("string2");

		assertThat(inputUtil.ListToString(stringList, ","))
			.isEqualTo("string1,string2");
	}
}
