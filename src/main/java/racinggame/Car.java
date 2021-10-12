package racinggame;

public class Car {
	final int CAR_NAME_LENGTH = 5;

	private String name;
	private int score;

	public Car(String name) {
		validateLength(name);
		this.name = name;
		this.score = 0;
	};

	public void validateLength(String name) {
		if (name.length() > CAR_NAME_LENGTH) {
			throw new IllegalArgumentException("각 " + CAR_NAME_LENGTH + "자 이하로 입력해주세요.");
		}
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
