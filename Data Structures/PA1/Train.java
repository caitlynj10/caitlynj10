package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * October 18, 2023
 * COSI 21A PA1
 * 
 * The Double Linked List class includes the implementation
 * for a non-circular doubly linked list. The class contains
 * various methods that will perform basic actions that a 
 * doubly linked list needs (insert, delete, and get). The
 * content of this class will be used throughout the Railway
 * and MBTA classes.
 * 
 * Known Bugs: NONE
 *
 */

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	public int direction;
	public String currentStation;

	/**
	 * The constructor for the Train class;
	 * constructs an empty train with it's 
	 * current station, direction, and an array
	 * of riders currently on the train.
	 * 
	 * RUNTIME: O(1)
	 * @param currentStation
	 * @param direction
	 */
	public Train(String currentStation, int direction) {
		this.currentStation = currentStation;
		this.direction = direction;
		this.passengers = new Rider[TOTAL_PASSENGERS];
		this.passengerIndex = 0; 
	}

	/**
	 * This methods checks if the trains's direction
	 * is 0, which means the train is going North; 
	 * returns true if the condition upholds and 
	 * false if the train is going south (1).
	 * 
	 * RUNTIME: O(1)
	 * @return true, if direction = 0
	 */
	public boolean goingNorth() {
		return (this.direction == 0);
	}

	/*
	 * This method swaps the train's direction from
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
	 * This method returns a String of the current
	 * passengers in the train.
	 * 
	 * RUNTIME: O(n)
	 * @return String listPassenger
	 */
	public String currentPassengers() {
		String listPassenger = "";
		int i = 0;
		if(passengerIndex == 0) {
			return "";
		}
		while(i < passengerIndex) {
			listPassenger += passengers[i].toString();
			listPassenger += "\n";

			i++;
		}
		return "Current Passengers: " + "\n" + listPassenger.toString();

	}

	/**
	 * This method checks if the rider's current station 
	 * and direction equals the trains station and direction
	 * and if the train has space for passengers. The method
	 * returns true and adds the passenger to the train if 
	 * the conditions uphold. Returns false otherwise
	 * 
	 * RUNTIME: O(1)
	 * @param r
	 * @return true, if the conditions uphold
	 */
	public boolean addPassenger(Rider r) {
		if(r == null) {
			return false;
		}
		
		if(r.getStarting().equals(currentStation) && r.goingNorth() == goingNorth() && hasSpaceForPassengers()) {

			passengers[passengerIndex++] = r;
			System.out.println("Passengers: " + passengerIndex);
			return true;

		}
		return false;
	}

	/**
	 * This method checks if there is space on
	 * the train for more passengers to be added. 
	 * Returns true if the conditions uphold.
	 * 
	 * RUNTIME: O(1)
	 * @return true, if there is space for a passenger
	 */
	public boolean hasSpaceForPassengers() {
		return (passengerIndex < passengers.length);
	}

	/**
	 * This method removes the passengers that have
	 * the same destination station as the current station
	 * and returns the removed passengers as a String. 
	 * 
	 * RUNTIME: O(n)
	 * @return String disembarked
	 */
	public String disembarkPassengers() {
		String disembarked = "";
		for(int i = 0; i< passengerIndex; i++) {
			if(currentStation.equals(passengers[i].getDestination())) {
				disembarked += passengers[i].toString();
				disembarked += "\n";
				passengers[i] = null;
			}

		}
		return disembarked;
	}

	/**
	 * This method updates the current station
	 * with the given station s.
	 * 
	 * RUNTIME: O(1)
	 * @param s
	 */
	public void updateStation(String s) {
		currentStation = s;
	}

	/**
	 * This method returns the current station
	 * as a String.
	 * 
	 * RUNTIME: O(1)
	 * @return String currentStation
	 */
	public String getStation() {

		return currentStation;
	}

	/**
	 * This method returns a String of the train
	 * with the station it is currently at.
	 * 
	 * RUNTIME: O(1)
	 * @return String getStation()
	 */
	@Override
	public String toString() {

		return "Train at Station: " + getStation();
	}


}
