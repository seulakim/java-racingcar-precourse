package racinggame;

public class InputUtil {

	public int validateNumber(String s) {
		if (!s.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException("숫자만 입력해주세요.");
		}
		return Integer.parseInt(s);
	}
}
