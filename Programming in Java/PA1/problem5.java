package PA1;
import java.util.Scanner;

public class problem5 {
	
	/**
	 * Caitlyn Jones
	 * COSI 12b, Spring 2023
	 * Programming Assignment #1
	 * 
	 * This method takes two Strings, first and last name,
	 * and converts those names in pig latin.
	 * (moving the first letter to the end and adding "ay"
	 * after it. Ex: Caitlyn Jones --> Aitlyncay Onesjay)
	 * @param name
	 * @return
	 */
	public static String pigLatin(String first, String last) {
		
		//convert to lower case
		String firstName = first.toLowerCase();
		String lastName = last.toLowerCase();
		
		//get the new first name and new last name
		String newFirst = firstName.substring(1) + firstName.charAt(0) + "ay";
		String newLast = lastName.substring(1) + lastName.charAt(0) + "ay";
		
		//get the final first and last name, capitalizing the new first letter
		String finalFirst = newFirst.substring(0,1).toUpperCase()+ newFirst.substring(1);
		String finalLast = newLast.substring(0,1).toUpperCase() + newLast.substring(1) ;
	
		//put together first and last to print together
		return finalFirst + " " + finalLast;
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter your first name: ");
		String userFirstName = console.next();
		System.out.println("Enter your last name: ");
		String userLastName = console.next();
		System.out.println(pigLatin(userFirstName,userLastName));
		
		
		
		
	}

}
