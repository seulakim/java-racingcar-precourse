package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
