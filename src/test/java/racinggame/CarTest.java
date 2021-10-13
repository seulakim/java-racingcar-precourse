package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	void 현재_스코어_출력() {
		assertThat(car.getStatus()).isEqualTo("car : ");

		car.setScore(3);
		assertThat(car.getStatus()).isEqualTo("car : ---");
	}

	@Test
	void 해당_점수인_자동차이름() {
		List<String> winnerList = new ArrayList<>();

		car.setScore(2);
		assertThat(car.getNameByScore(winnerList, 3)).isEqualTo(winnerList);

		car.setScore(3);
		winnerList.add(car.getName());
		assertThat(car.getNameByScore(winnerList, 3)).isEqualTo(winnerList);
	}
}
