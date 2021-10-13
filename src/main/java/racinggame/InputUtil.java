package racinggame;

import java.util.List;

public class InputUtil {

	public int validateNumber(String s) {
		if (s.isEmpty()) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}
		
		if (!s.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException("숫자만 입력해주세요.");
		}
		return Integer.parseInt(s);
	}

	public String ListToString(List<String> stringList, String regex) {
		String toString = "";

		for (String s : stringList) {
			toString += regex + s;
		}

		return toString.replaceFirst(regex, "");
	}
}
