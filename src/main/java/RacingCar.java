import static java.lang.Math.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class RacingCar {

	private HashMap<String, Integer> car = new HashMap<>();
	private int numberOfMatches;

	// 자동차 이름을 부여한다.
	public boolean specifyCarName(String carName) {
		String[] tokens = carName.replaceAll(" ", "").split(",");

		if (Arrays.stream(tokens).anyMatch(x -> x.length() > 5)) {
			throw new RuntimeException("자동차 이름은 5자가 초과하면 안됩니다.");
		}

		for (int i = 0; i < tokens.length; i++) {
			car.put(tokens[i] + " : ", 0);
		}

		return true;
	}

	// 경기수를 설정한다.
	public void validateNumberOfMatches(String num) {
		if (!num.matches("\\d+")) {
			throw new RuntimeException("숫자가 아닙니다.");
		}
		this.numberOfMatches = Integer.parseInt(num);
	}

	// 레이싱 게임을 시작한다.
	public void startCar() {
		System.out.println("실행 결과");
		for (int i = 0; i < numberOfMatches; i++) {
			insertRank();
			System.out.println();
		}
		Integer maxValue = Collections.max(car.values());
		List<String> list = car.entrySet()
			.stream()
			.filter(entry -> entry.getValue().equals(maxValue))
			.map(Entry::getKey)
			.collect(Collectors.toList());
		System.out.printf("%s가 최종 우승했습니다.", list.toString().replaceAll("\\[|\\]", ""));
	}

	private void insertRank() {
		for (String key : car.keySet()) {
			settingRank(key);
		}
	}

	private void settingRank(String key) {
		if (createRandomNum()) {
			car.put(key, car.get(key) + 1);
		}
		drawRacing(key);
	}

	private void drawRacing(String key) {
		System.out.printf("%s %s\n", key, drawHyphen(car.get(key)));
	}

	public Map<String, Integer> getCarName() {
		return car;
	}

	public String drawHyphen(int value) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < value; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	public boolean createRandomNum() {
		double num = random();
		int randomNum = (int) (num * 10);
		if (randomNum >= 4) {
			return true;
		}
		return false;
	}
}
