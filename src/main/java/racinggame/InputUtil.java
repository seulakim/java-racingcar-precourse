package racinggame;

public class InputUtil {

	final String SPLIT_REGEX = ",";
	final int CAR_NAME_LENGTH = 5;

	public String[] splitString(String s) {
		return(s.split(SPLIT_REGEX));
	}

	public boolean validateStringLength(String s) {
		if (s.length() > CAR_NAME_LENGTH) {
			printErrorMessage("각 " + CAR_NAME_LENGTH + "자 이하로 입력해주세요.");

			return false;
		}
		return true;
	}

	public boolean validateNumber(String s) {
		if (!s.matches("[+-]?\\d*(\\.\\d+)?")) {
			printErrorMessage("숫자만 입력해주세요.");

			return false;
		}
		return true;
	}

	public void printErrorMessage(String msg) {
		System.out.println("[ERROR] " + msg);
	}
}
