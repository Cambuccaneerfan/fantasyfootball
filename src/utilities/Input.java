package utilities;

import java.util.Scanner;

public class Input {
	public static int validInt(int min, int max, Scanner keyboard) {
		int numInput;
		do {
			while (!keyboard.hasNextInt()) {
				keyboard.nextLine();
			}
			numInput = keyboard.nextInt();
			keyboard.nextLine();
		} while (numInput < min || numInput > max);
		return numInput;
	}

	public static String validString(int max, Scanner keyboard) {
		String textInput;
		do {
			textInput = keyboard.nextLine();
		} while (textInput.isEmpty() || textInput.length() > max);
		return textInput;
	}
}