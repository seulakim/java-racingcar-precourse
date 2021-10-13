package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        boolean receiveCarName = false;
        boolean receiveRoundNum = false;

        PlayGame playGame = new PlayGame();
        while (!receiveCarName) {
            receiveCarName = playGame.inputCarNames();
        }

        while (!receiveRoundNum) {
            receiveRoundNum = playGame.inputRoundNum();
        }

        playGame.play();
    }
}
