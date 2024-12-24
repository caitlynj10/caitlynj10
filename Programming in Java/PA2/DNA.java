import java.util.*;
import java.io.*;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * March 1, 2023
 * PA 2
 * 
 * The following program reads an input file dna.txt
 * or ecoli.txt, full of many different nucleotide 
 * sequences. The methods below do a variety of 
 * computations and actions,such as printing the 
 * entire nucleotide sequence,counting the number of 
 * A,C,G,T nucleotides in each sequence, computing the 
 * total mass percentage of each nucleotide, splitting 
 * the nucleotide into codons, and lastly, determining 
 * if the nucleotide sequence is a protein. The program 
 * does all of these actions and prints them out in an 
 * ouput file, named by the user.
 * 
 * Known Bugs: none
 *
 */
public class DNA {

	public static final int MIN_CODON = 5; //minimum codon
	public static final int MIN_PERCENT = 30; //minimum Percent
	public static final int NUC_COUNTER_LENGTH = 4; //nucleotides counter length
	public static final int CODON_LENGTH = 3; //nucleotides per codon 


	/**
	 * This method counts the number of individual nucleotides 
	 * per sequence and stores the values in an array
	 * @param dna
	 * @return int [] countNucleos
	 */
	public static int [] countNuc(String dna) {
		int [] countNucleos = new int [NUC_COUNTER_LENGTH]; //make new array to hold values
		for(int i = 0; i < dna.length(); i++) {
			if(dna.charAt(i) == 'A') {
				countNucleos[0] += 1;
			}
			if(dna.charAt(i) == 'C') {
				countNucleos[1] += 1;
			}
			if(dna.charAt(i) == 'G') {
				countNucleos[2] += 1;
			}
			if(dna.charAt(i) == 'T') {
				countNucleos[3] += 1;
			}
		}
		return countNucleos;
	}
	
	/**
	 * This method totals the mass of each nucleotide from 
	 * each sequence and stores the value in a double.
	 * @param dna
	 * @return double total
	 */
	public static double getTotalMass(String dna) {
		double total = 0.0; 
		for(int i = 0; i< dna.length(); i++) {
			if(dna.charAt(i) == 'A') {
				total += 135.128;
			}
			if(dna.charAt(i) == 'C') {
				total += 111.103;	
			}
			if(dna.charAt(i) == 'G') {
				total += 151.128;	
			}
			if(dna.charAt(i) == 'T') {
				total += 125.107;
			}
			if(dna.charAt(i) == '-') { //only time the dashes will count for something
				total += 100.00;
			}
		}

		return total;
	}

	/**
	 * This method takes double total from the previous
	 * method and the nucleotide count from countNuc 
	 * and computes the total mass percent of each 
	 * nucleotide and saves it to a double array.
	 * @param dna
	 * @return double [] massPercent
	 */
	public static double[] getMass(String dna) {
		double total = getTotalMass(dna); //gets the total
		int [] codonCount = countNuc(dna); //gets the nucleotide counts

		double [] massPercent = new double [NUC_COUNTER_LENGTH];
		//to get the actual percent, it multiples the mass of each nucleotide by the number
		//of said nucleotide in the sequence, divides the number by the total mass, then
		//multiplies that value by 100. to get the correct rounded number, invokes Math.round
		//on this value, *10 and /10, which gets the number rounded to one past the decimal place
		massPercent[0] = Math.round((((codonCount[0] * 135.128) / total) * 100.0)*10.0)/10.0;
		massPercent[1] = Math.round((((codonCount[1] * 111.103) / total) * 100.0)*10.0)/10.0;
		massPercent[2] = Math.round((((codonCount[2] * 151.128) / total) * 100.0)*10.0)/10.0;
		massPercent[3] = Math.round((((codonCount[3] * 125.107) / total) * 100.0)*10.0)/10.0;

		return massPercent;

	}

	
	/**
	 * This method first goes through the given
	 * dna strand and takes out all "-". Next, 
	 * the method creates codons of the sequence,
	 * each containing 3 nucleotides, and stores 
	 * the codons in a string array.
	 * @param dna
	 * @return String [] codons
	 */
	public static String [] getCodons(String dna) {
		//first create a new string which holds the sequence given without the dashes
		String pureDna = "";
		for(int i = 0; i < dna.length(); i++) {
			if(dna.charAt(i) != '-') {
				pureDna += dna.charAt(i);
			}
		}
		String [] codons = new String [pureDna.length()/CODON_LENGTH]; //length of the "clean" sequence divided by 3 
		int start = 0; //starting point for substring
		int end = start+CODON_LENGTH; //ending point for substring
		for(int i = 0; i< codons.length; i++) {
			String cod = pureDna.substring(start, end); //gets 3 nucleotides per codon
			codons[i] = cod;
			start = end; //gets the new start, which would be end after the codon is inputed in the array
			end += CODON_LENGTH; //new end is three from the start
		}

		return codons;				
	}

	//for the next section, I decided to break down the various boolean statements to make it easier to read
	
	/**
	 * This method first checks if the first codon
	 * is ATG by calling getCodons.
	 * @param dna
	 * @return true if statement upholds
	 */
	public static boolean validStart(String dna) {
		String [] cod = getCodons(dna);
		return(cod[0].equals("ATG") );
	}

	/**
	 * This method checks if the final codon in the 
	 * sequence is TAA, TAG, or TGA
	 * @param dna
	 * @return true if statement upholds
	 */
	public static boolean validStop(String dna) {
		
		String [] cod = getCodons(dna);
		int end = cod.length-1;
		return (cod[end].equals("TAA") || cod[end].equals("TAG") || cod[end].equals("TGA") );

	}

	/**
	 * This method checks if there are at least
	 * 5 codons in a sequence and if the mass 
	 * percentage of C and G together are at
	 * least 30.
	 * @param dna
	 * @return true if statement upholds
	 */
	public static boolean validCods(String dna) {

		String [] cod = getCodons(dna);
		double [] mass = getMass(dna);

		return (cod.length >= MIN_CODON && (mass[1] + mass[2] >= MIN_PERCENT));
	}
	
	/**
	 * This statement checks if the previous three
	 * methods return true.
	 * @param dna
	 * @return true if statement upholds
	 */
	public static boolean isProtein(String dna) {
		return(validStart(dna) && validStop(dna)&& validCods(dna) );
	}
	
	/**
	 * This method is the main method of the function 
	 * that will be called in the input main of the 
	 * class. It first prints out the region name.
	 * Then it capitalizes the nucleotide sequence.
	 * Lastly, it calls each method written above
	 * to print out in the output file all the data
	 * acquired from calling the various methods.
	 * @param scan
	 * @param userOut
	 */
	public static void getData(Scanner scan, PrintStream userOut) {

		String dnaName = scan.nextLine();
		userOut.println("Region Name: " + dnaName);

		String ln = scan.nextLine(); //skips to next line so that it won't compute methods on the region name
		String line = ln.toUpperCase();
		userOut.println("Nucleotides: " + line);

		int [] counter = countNuc(line);
		userOut.println("Nuc. Counts: " + Arrays.toString(counter));

		double total = getTotalMass(line);
		double [] masses = getMass(line);
		userOut.println("Total Mass%: " + Arrays.toString(masses) + " of " + Math.round(total*10.0)/10.0); //rounds the total to one past the decimal place

		String [] printCodons = getCodons(line);
		userOut.println("Codons List: " + Arrays.toString(printCodons));

		boolean isValidProtein = isProtein(line);
		String valid = "YES";
		if(isValidProtein) { //prints YES instead of true
			valid = "YES"; 
		}
		else {
			valid = "NO";
		}
		userOut.println("Is Protein?: " + valid);
		userOut.println("");

	}

	
	public static void main (String[] args) throws FileNotFoundException {
		
		System.out.println("This program reports information about DNA\r\n"
				+ "nucleotide sequences that may encode proteins.");
		//scanner asks for input file 
		Scanner user = new Scanner(System.in);
		System.out.print("Input file name? ");
		String userInput = user.nextLine();
		Scanner input = new Scanner(new File(userInput));

		//scanner asks for and creates output file before methods are called
		Scanner userOut = new Scanner(System.in);
		System.out.print("Output file name? ");
		String userOutput = userOut.nextLine();
		PrintStream output = new PrintStream(new File(userOutput));

		//calls main method on the file until it's empty, prints to newly created output file
		while(input.hasNextLine()) {
			getData(input,output);
		}		
		System.out.println("Your output file is ready.");

		input.close();
		output.close();
	}
}
