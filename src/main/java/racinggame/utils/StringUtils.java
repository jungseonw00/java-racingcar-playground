package racinggame.utils;

public class StringUtils {

	public static boolean isBlank(String str) {
		if (str == null || str.equals("")) {
			return true;
		}
		if (str.replaceAll(" ", "").length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
		return false;
	}
}