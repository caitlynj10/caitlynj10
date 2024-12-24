package main;

/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * October 18, 2023
 * COSI 21A PA1
 * 
 * The Rider class contains the features of a rider
 * on the red line. This class holds the riders ID, 
 * starting station, and destination station which will
 * be used throughout the other classes (Train, Station,
 * Railway, MBTA).
 * 
 * Known Bugs: NONE
 *
 */

public class Rider {

	public String riderID;
	public String startingStation;
	public String destinationStation;
	public int direction;

	/**
	 * The constructor for a Rider; constructs a new rider
	 * with it's individual ID, starting station, and 
	 * destination station. It also sets the rider's 
	 * direction to South (which is equivalent to 1).
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 * 
	 * RUNTIME: O(1)
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
		this.direction = 1; //South is 1, North is 0

	}
	
	/**
	 * This method returns the rider's starting
	 * station as a String.
	 * 
	 * RUNTIME: O(1)
	 * @return String startingStation
	 */
	public String getStarting() {

		return startingStation;
	}

	/**
	 * This methods returns the rider's 
	 * destination station as a String.
	 * 
	 * RUNTIME: O(1)
	 * @return String destinantionStation
	 */
	public String getDestination() {

		return destinationStation;
	}

	/**
	 * This method returns the rider's ID as
	 * a String.
	 * 
	 * RUNTIME: O(1)
	 * @return String riderID
	 */
	public String getRiderID() {
		return riderID;
	}

	/**
	 * This methods checks if the rider's direction
	 * is 0, which means the rider is going North; 
	 * returns true if the condition upholds and 
	 * false if the rider is going south (1).
	 * 
	 * RUNTIME: O(1)
	 * @return true, if direction = 0
	 */
	public boolean goingNorth() {
		return (this.direction == 0);
	}

	/*
	 * This method swaps the rider's direction from
	 * north to south (0 --> 1) or south to north (1 --> 0).
	 * 
	 * RUNTIME: O(1)
	 */
	public void swapDirection() {
		if(direction == 0) {
			direction = 1;
		}
		if(direction == 1) {
			direction = 0; 
		}
	}



	/**
	 * This method returns the rider as a String.
	 * ex: 7SG7IE6K7J7TZLHCHTZW, Porter 
	 * where Porter is the rider's destination station
	 * 
	 * RUNTIME: O(1)
	 * @return String riderID and String destinationStation.
	 */
	@Override
	public String toString() {
		return riderID + " " + destinationStation;
	}

	/**
	 * This method compares the riderID to another
	 * rider's ID; returns true if their String values
	 * are equal.
	 * 
	 * RUNTIME: O(1)
	 * @return true, if the String values are equivalent
	 */
	@Override
	public boolean equals(Object s) {
		if(this.riderID.equals(((Rider) s).getRiderID())) {
			return true;
		}
		return false;
	}
}
