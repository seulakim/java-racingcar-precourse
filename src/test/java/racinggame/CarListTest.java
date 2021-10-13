package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarListTest {

	CarList carList;
	List<Car> cars;

	@BeforeEach
	void beforeEach() {
		carList = new CarList();

		cars = new ArrayList<>();
		cars.add(new Car("car"));
		cars.add(new Car("car"));
	}

	@Test
	void 자동차_리스트_생성() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new CarList("banana,banana"));

		assertThatCode(() -> new CarList("apple,bana,car"))
			.doesNotThrowAnyException();
	}

	@Test
	void 자동차_이름_분리() {
		assertThat(carList.splitString("apple,banana"))
			.isEqualTo(new String[] {"apple", "banana"});
	}

	@Test
	void 자동차_이름_중복() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> carList.validateDuplicate(cars));
	}

	@Test
	void 자동차_이름() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> carList.validateDuplicate(cars));
	}
}
