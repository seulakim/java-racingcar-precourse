package racinggame;

public class PlayGame {

	public void play(CarList carList, int roundNum) {
		while (roundNum > 0) {
			carList.createRandomNum();

			roundNum--;
		}
	}
}
