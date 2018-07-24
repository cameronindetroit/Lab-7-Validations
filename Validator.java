package invalidInput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validator {

	/*
	 * VALIDATE NAME METHOD
	 */

	public static String getName(Scanner scnr, String prompt) {
		// Method variables
		boolean isValid = false;
		String userInput = scnr.next();
		char firstLetter = userInput.charAt(0);

		// Do loop to continue until valid entry
		do {

			// conditional for valid string (all letters),(first Letter is uppercase), (less
			// then 30 characters)
			if (userInput.matches("[a-zA-Z]+") && Character.isUpperCase(firstLetter) && userInput.length() < 30) {
				isValid = true;
				scnr.nextLine();
				// System.out.println("Name is valid");

			} else {
				isValid = false;
				System.out.println("Name is not valid: Please use only letters, and a capital first letter");
				return getName(scnr, prompt);
			}

		} while (isValid == false);

		// return
		// System.out.println(userInput);
		return userInput;

	}

	/*
	 * VALIDATE EMAIL METHOD
	 */

	public static String getEmail(Scanner scnr, String prompt) {

		// Method variables
		boolean isValid = false;
		String userInput = " ";
		char commercialAt = '@';
		String firstString;
		String middleString;
		String lastString;
		String validEmail = " ";

		// SPLIT EMAIL INTO TWO STRINGS, VALIDATE EVERYTHING BEFORE THE @ SYMBOL AND
		// AFTER

		do {
			System.out.println(prompt);
			userInput = scnr.next();

			if (userInput.contains("@")) {
				// Split email by into three part by @ symbol
				firstString = userInput.substring(0, userInput.indexOf(commercialAt));
				middleString = userInput.substring(userInput.indexOf(commercialAt), userInput.indexOf(commercialAt));
				lastString = userInput.substring(userInput.indexOf(commercialAt), userInput.length());
				// System.out.println("Vaild email");
				// System.out.println(firstString);

				if (firstString.matches("[a-zA-Z0-9]") && (firstString.length() > 4) && (firstString.length() < 31))
					scnr.nextLine();
				// System.out.println(firstString);

				if (lastString.matches("[a-zA-Z \\.]"))
					scnr.nextLine();
				validEmail = (firstString + middleString + lastString);
				// System.out.println(validEmail);
				isValid = true;

			} else {
				isValid = false;
				System.out.print("Enter an email formatted .....@...com: ");
			}

		} while (!isValid == true);

		return userInput;

	}

	/*
	 * VALIDATE PHONE NUMBER METHOD
	 */

	public static String getNumber(Scanner scnr, String prompt) {
		String userNum;
		boolean isValid = false;

		do {
			System.out.println(prompt);

			userNum = scnr.next();

			if (userNum.matches("^[0-9].*")) {
				isValid = true;
				userNum = String.valueOf(userNum).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");

			} else {
				isValid = false;
				System.out.println("Please enter a valid phone number with 10 digits: digits only");
			}

		} while (isValid == false);
		return userNum;

	}

	/*
	 * VALIDATE DATE METHOD
	 */

	public static String getDate(Scanner scnr, String prompt) {
		// To take the input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Date ");

		String date = scanner.next();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = null;
		try {
			// Parsing the String
			date2 = dateFormat.parse(date);
		} catch (ParseException exception) {
			System.out.println("Enter a valid date: dd-MM-yyyy");

			scnr.nextLine();
			// return getDate(scnr, prompt);
		}
		// System.out.println(date2);
		return date.toLowerCase();
	}
}
