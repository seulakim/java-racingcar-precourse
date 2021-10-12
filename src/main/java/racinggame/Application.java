package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            CarList carList = new CarList(Console.readLine());

            System.out.println("시도할 회수는 몇회인가요?");
            int roundNum = new InputUtil().validateNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
