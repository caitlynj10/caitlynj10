package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * October 18, 2023
 * COSI 21A PA1
 * 
 * The MBTA class holds the methods that will
 * properly allow the railway class to run. This
 * class reads through various text files and uses
 * the contents of them to run the simulation.
 * 
 * Known Bugs: NONE
 *
 */
public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;

	static final int TIMES = 6;
	static Railway r = new Railway();
	
	/**
	 * This method initializes stations, trains, and 
	 * riders from the given text files; this method
	 * also runs the simulation.
	 * 
	 * RUNTIME: O(n^2)
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		initStations("redLine.txt");
		initTrains("trains.txt");
		initRiders("riders.txt");

		runSimulation();
	}

	/**
	 * This method runs the simulate method 
	 * a set number of times and prints out 
	 * the log while it does.
	 * 
	 * RUNTIME: O(n^3)
	 */
	public static void runSimulation() {
		for(int i = 0; i<TIMES; i++) {
			System.out.println(r.simulate());
		}
		//System.out.println(r.simulate());


	}
	
	/**
	 * 
	 * 
	 * RUNTIME: O(n^2)
	 * @param trainsFile
	 * @throws FileNotFoundException
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(trainsFile));
		while(scan.hasNextLine()) {
			String stationName = scan.nextLine().trim();
			int direction = Integer.parseInt(scan.nextLine().trim());

			Train train = new Train(stationName, direction);
			r.addTrain(train);
		}

	}

	/**
	 * RUNTIME: O(n^2)
	 * @param ridersFile
	 * @throws FileNotFoundException
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(ridersFile));
		while(scan.hasNextLine()) {
			String riderID = scan.nextLine().trim();
			String start = scan.nextLine().trim();
			String end = scan.nextLine().trim();
			Rider ride = new Rider(riderID, start, end);
			r.addRider(ride);
		}

	}

	
	/**
	 *  RUNTIME: O(n^2)
	 * @param stationsFile
	 * @throws FileNotFoundException
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(stationsFile));
		while(scan.hasNextLine()) {
			String station = scan.nextLine().trim();
			Station s = new Station(station);
			r.addStation(s);	
		}

	}
}
