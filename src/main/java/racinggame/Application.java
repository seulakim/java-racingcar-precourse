package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = Console.readLine();

        InputUtil inputUtli = new InputUtil();
        String[] carArray = inputUtli.splitString(carNames);

        for (String car : carArray) {
            inputUtli.validateStringLength(car);
        }
    }
}
