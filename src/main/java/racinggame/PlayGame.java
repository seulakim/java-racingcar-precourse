package racinggame;

public class PlayGame {

	public void play(CarList carList, int roundNum) {

		System.out.println("\n실행 결과");

		while (roundNum > 0) {
			carList.createRandomNum();
			carList.printScore();

			roundNum--;
		}
	}
}
