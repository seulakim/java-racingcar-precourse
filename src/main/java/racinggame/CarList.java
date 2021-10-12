package racinggame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarList {

	static final String SPLIT_REGEX = ",";

	private List<Car> carList;

	public CarList() {}

	public CarList(String cars) {
		this(makeCarList(cars));
	}

	public CarList(List<Car> carList) {
		validateDuplicate(carList);
		this.carList = carList;
	}

	private static List<Car> makeCarList(String cars) {
		List<Car> carList = new ArrayList<>();

		String[] carArray = splitString(cars);
		for (String car : carArray) {
			carList.add(new Car(car));
		}

		return carList;
	}

	public static String[] splitString(String s) {
		return(s.split(SPLIT_REGEX));
	}

	public void validateDuplicate(List<Car> cars) {
		Set<String> nonDuplicateCars = new HashSet<String>(makeNameList(cars));
		if (nonDuplicateCars.size() != cars.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
		}
	}

	private List<String> makeNameList(List<Car> carList) {
		List<String> nameList = new ArrayList<>();

		for (Car car : carList) {
			nameList.add(car.getName());
		}

		return nameList;
	}
}
