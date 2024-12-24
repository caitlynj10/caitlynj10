package PA1;
import java.util.Scanner;


public class problem1 {
	/**
	 * Caitlyn Jones
	 * COSI 12b, Spring 2023
	 * Programming Assignment #1
	 * 
	 * This method takes in a positive integer. If the number is even,
	 * it divides in half. If it's odd, it multiplies by 3 and adds 1.
	 * The method repeats this process until the value is 1; the method
	 * should print out the total number of operations performed during 
	 * the execution.
	 * @param num 
	 * @return total number of operations performed
	 */

	public static int numberOfOps(int num) {
		int counter = 0;

		if(num == 1) {
			counter = -1; //when it's 1, the number of operations is 0, so set counter to -1
		}
		else {
			while(num != 2) {
				if(num%2 == 0) {
					num = num/2;
					counter++;
					System.out.println("Next value is: " + num);
				}
				else {
					num = (num*3) + 1;
					counter++;
					System.out.println("Next value is: " + num);
				}

			}
		}
		return counter+1; //because it stops before it hits 1, the counter will be off by one, so we need to add one at the end

	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Intial value is: ");
		int val = console.nextInt();
		if(val == 0) { //if the input is 0, the program should not even run
			System.out.println("Error: your program has stopped");
		} 
		else {
			System.out.println("Final value 1, number of operations performed: " + numberOfOps(val));

		}


	}



}
