package racinggame;

import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class PlayGame {

	CarList carList;
	int roundNum;

	public boolean inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

		try {
			carList = new CarList(Console.readLine());
			return carList.getSize() > 0;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return false;
		}
	}

	public boolean inputRoundNum() {
		System.out.println("시도할 회수는 몇회인가요?");

		try {
			roundNum = new InputUtil().validateNumber(Console.readLine());
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return false;
		}
	}

	public void play() {
		System.out.println("\n실행 결과");

		int score = roundNum;
		while (score > 0) {
			carList.createRandomNum();
			carList.printScore();

			score--;
		}

		System.out.println("최종 우승자는 " + carList.getWinner(roundNum) + " 입니다.");
	}
}
