package PA1;

import java.util.Scanner;

public class problem3 {
	/**
	 * Caitlyn Jones
	 * COSI 12b, Spring 2023
	 * Programming Assingment #1
	 * 
	 * This method takes in a number (no bigger than 4999),
	 * and displays it as a roman numeral.
	 * @param num
	 * @return roman numeral of the input int
	 */

	public static String romanNum(int num) {

		String romanNum = "";

		if(num > 4999) { //cannot be larger than 4999, so the program should not run at all
			System.out.println("Error: your program has stopped");
		}
		else {

			while(num >= 1000) {
				romanNum += "M";
				num -= 1000;
			}
			while(num >= 900) {
				romanNum += "CM";
				num -= 900;
			}

			while(num >= 500) {
				romanNum += "D";
				num -= 500;
			}
			while(num >= 400) {
				romanNum += "CD";
				num -= 400;
			}

			while(num >= 100) {
				romanNum += "C";
				num -= 100;
			}

			while(num >= 90) {
				romanNum += "XC";
				num -= 90;
			}

			while(num >= 50) {
				romanNum += "L";
				num -= 50;
			}

			while(num >= 40) {
				romanNum += "XL";
				num -= 40;
			}

			while(num >= 10) {
				romanNum += "X";
				num -= 10;
			}

			while(num >= 9) {
				romanNum += "IX";
				num -= 9;
			}
			while(num >= 5) {
				romanNum += "V";
				num -= 5;
			}

			while(num >= 4) {
				romanNum += "IV";
				num -= 4;
			}
			while(num >= 1) {
				romanNum += "I";
				num -= 1;
			}
		}
		return romanNum;

	}



	public static void main (String [] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a number to be written in Roman Numerals: ");
		int num = console.nextInt();
		System.out.println(romanNum(num));

	}

}
