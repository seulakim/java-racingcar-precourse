package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

	Car car;

	@BeforeEach
	void beforeEach() {
		car = new Car("car");
	}

	@Test
	void 자동차_생성() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Car("banana"));

		assertThatCode(() -> new Car("apple"))
			.doesNotThrowAnyException();
	}

	@Test
	void 자동차_이름_길이제한() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> car.validateLength("carName"));

		assertThatCode(() -> car.validateLength("car"))
			.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@CsvSource(value = {"-1:false", "0:false", "3:false", "4:true", "9:true", "10:false"}, delimiter = ':')
	void 자동차_전진_멈춤(int num, boolean expected) {
		assertThat(car.run(num)).isEqualTo(expected);
	}
}
