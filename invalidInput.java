package invalidInput;

import java.util.Scanner;

public class invalidInput {

	public static void main(String[] args) {
		// Scanner
		Scanner scnr = new Scanner(System.in);

		// Have user enter input name to check with method
		System.out.println("Enter your first name: Use capitalized first letter ");
		String userName = Validator.getName(scnr, "Enter you name: ");
		// System.out.println(userInput + ": Your name is vaild");

		// System.out.println("Enter you email address: ");
		String userEmail = Validator.getEmail(scnr, "Enter your email");

		String userNumber = Validator.getNumber(scnr, "Type in phone number");
		// System.out.println(userNumber);
		// System.out.println(userEmail + " is a valid email");

		System.out.println(
				"Username: " + userName + " \n" + "Email Address: " + userEmail + "\n" + "Phone Number: " + userNumber);

		scnr.close();
	}

}
