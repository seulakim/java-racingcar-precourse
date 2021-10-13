package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

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

		carList.forEach(car -> {
			nameList.add(car.getName());
		});

		return nameList;
	}

	public int getSize() {
		return carList.size();
	}

	public void createRandomNum() {
		carList.forEach(car -> {
			car.run(Randoms.pickNumberInRange(0, 9));
		});
	}

	public void printScore() {
		carList.forEach(car -> {
			System.out.println(car.getStatus());
		});

		System.out.println();
	}

	public String getWinner(int score) {
		List<String> winnerList = new ArrayList<>();

		for (Car car : carList) {
			winnerList = car.getNameByScore(winnerList, score);
		}

		if (winnerList.size() > 0) {
			return new InputUtil().ListToString(winnerList, SPLIT_REGEX);
		}

		return getWinner(score - 1);
	}
}
