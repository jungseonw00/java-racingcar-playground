import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String parameter) {
		int sum = 0;
		String[] tokens;

		if (parameter == null || parameter.equals("")) {
			return 0;
		}

		if (parameter.matches("\\d")) {
			return Integer.parseInt(parameter);
		}

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(parameter);

		if (m.find()) {
			String customDelimiter = m.group(1);
			tokens = m.group(2).split(customDelimiter);
		} else {
			tokens = parameter.split(",|:");
			if (Arrays.stream(tokens).anyMatch(x -> !x.matches("\\d+"))) {
				throw new RuntimeException("숫자가 아닙니다.");
			}
		}

		for (String token : tokens) {
			sum += Integer.parseInt(token);
		}

		return sum;
	}
}