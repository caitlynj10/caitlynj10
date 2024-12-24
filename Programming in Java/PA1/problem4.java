package PA1;

import java.util.Scanner;

public class problem4 {
	
	public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Caitlyn Jones
	 * COSI 12b, Spring 2023
	 * Programming Assignment #1
	 * 
	 * This method takes an String and an int. For each
	 * letter in the String, the method will rotate the
	 * letter by the int number in the alphabet and
	 * display the output in all caps.
	 * Ex: input is abc and 3, the output is DEF
	 * @param message
	 * @param key
	 * @return the final message after the program runs
	 */
	public static String finalMessage(String message, int key) {

		String finalMess = ""; //finalMess = final message

		for(int i = 0; i<message.length(); i++) {

			char oldChar = message.charAt(i); //variable to make code more readable; holds the char we are shifting

			int charMess = alpha.indexOf(oldChar); //charMess = char message; finds the location of the char in the final variable
			if(charMess == -1) { //if the char is a space, it's not in alpha (-1), so add a space to the final in its place
				finalMess += " ";
			}
			else {
				int shiftChar = (charMess + key) % 26; //for when the coding key goes past z; still works if coding key is less than z

				char newCharMess = alpha.charAt(shiftChar);

				finalMess += newCharMess;
			}




		}


		return finalMess.toUpperCase();

	}


	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a message: ");
		String mess = console.nextLine(); //mess = message
		System.out.println("Encoding key? ");
		int code = console.nextInt();
		System.out.println(finalMessage(mess,code));


	}

}
