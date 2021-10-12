package racinggame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputUtilTest {

	InputUtil inputUtil;

	@BeforeEach
	void beforeEach() {
		inputUtil = new InputUtil();
	}

	@Test
	void 문자열_분류() {
		assertArrayEquals(new String[] {"apple", "banana", "carrot"}, inputUtil.splitString("apple,banana,carrot"));
	}

	@ParameterizedTest
	@CsvSource(value = {"apple:true", "banana:false", "123:true", "자동차:true"}, delimiter = ':')
	void 문자열_유효성_검사(String inputValue, boolean expected) {
		assertEquals(expected, inputUtil.validateStringLength(inputValue));
	}

	@ParameterizedTest
	@CsvSource(value = {"10:true", "123:true", "apple:false", "자동차:false"}, delimiter = ':')
	void 숫자_검사(String inputValue, boolean expected) {
		assertEquals(expected, inputUtil.validateNumber(inputValue));
	}
}
