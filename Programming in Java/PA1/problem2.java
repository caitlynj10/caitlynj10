package PA1;


import java.util.Scanner;

public class problem2 {
	

	/**
	 * Caitlyn Jones
	 * COSI 12b, Spring 2023
	 * Programming Assignment #1
	 * 
	 * This method takes a positive integer and prints the 
	 * digits line by line WITHOUT using Strings (only ints)
	 * @param num
	 */
	
	public static void printNums(int num) {

		//get the length of the number
		int number = num;
		int numLength = 0;
		int numPower = 1;
		while(number > 10) {
			number = number/10; //takes off last digit
			numLength++; 
			numPower *= 10; //the power of ten we will divide the number by, based on the length of the number
		}

		int tempA = num;
		int tempB = num;
		int rHold= 0; //rHold --> remainderHolder
		/**
		 * steps of this for-loop:
		 * 1. saves num in rHold
		 * 2. tempA becomes the original number without its starting digit
		 * 3. tempB becomes the closest power of ten to the original power of 10
		 * 4. tempA becomes tempB / numPower, which will get the first digit to print
		 * 5. reset the variables to the original rHold to begin process again 
		 */
		for(int i = 0; i <numLength + 1; i++) {
			//tracing this with 12,345
			rHold = tempA; //12345
			tempA = tempA % numPower; // 12345 % 10,000 --> 2345
			tempB = rHold - tempA; // 12345 - 2345 --> 10,000
			tempA = tempB / numPower; //10,000/10,000 --> 1
			System.out.println(tempA); //1
			rHold = rHold % numPower; //12345 % 10,0000 --> 2345
			tempA = rHold; //2345
			tempB = rHold; // 2345
			numPower = numPower/10; //1,000
		}
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int num = console.nextInt();
		printNums(num);

		

	}


}