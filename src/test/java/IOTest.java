import static java.lang.System.in;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class IOTest {
	public static String systemIn(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner kb = new Scanner(in);
		return kb.nextLine();
	}
}
