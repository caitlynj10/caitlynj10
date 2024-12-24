package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * October 18, 2023
 * COSI 21A PA1
 * 
 * The Station class holds the implementation for a singular
 * station in the Railway. The Station class holds the methods
 * to track north bound and south bound riders along with north
 * bound and south bound trains. This class will be used throughout
 * the Railway and MBTA classes.
 *
 * 
 * Known Bugs: NONE
 *
 */
public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	public String name;

	/**
	 * The constructor for the Station class; constructs a
	 * station with given name, and also it initializes
	 * 4 queues for each station.
	 * 
	 * RUNTIME: O(1)
	 * @param name
	 */
	public Station(String name) {
		this.name = name;
		this.northBoundRiders = new Queue<Rider>(100);
		this.southBoundRiders = new Queue<Rider>(100);
		this.northBoundTrains = new Queue<Train>(100);
		this.southBoundTrains = new Queue<Train>(100);
	}

	/**
	 * This method adds a rider to the station as long
	 * as the rider's starting starting is equal to the
	 * current station. The rider wull be added to the
	 * queue of riders based on their direction.
	 * 
	 * RUNTIME: O(1)
	 * @param r
	 * @return true if the rider is added to a queue
	 */
	public boolean addRider(Rider r) {
		if(r.getStarting().equals(name)) {
			if(r.goingNorth()) {
				northBoundRiders.enqueue(r);
				return true;
			}
			if(!r.goingNorth()) {
				southBoundRiders.enqueue(r);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method disembarks the passengers that are getting 
	 * off at the current station then adds the train to the queue
	 * of trains based on its direction.
	 * 
	 * RUNTIME: O(1)
	 * @param t
	 * @return String disembarkMessage
	 */
	public String addTrain(Train t) {
		if(t != null) {
			String disembarkMessage = t.disembarkPassengers();

			t.updateStation(stationName());

			if (t.goingNorth()) {
				northBoundTrains.enqueue(t);

			} 
			else {
				southBoundTrains.enqueue(t);

			}

			if(disembarkMessage.equals("")){
				return "";
			}
			return stationName() + " Disembarking Passengers: " + "\n" + disembarkMessage.toString();


		}
		return "";
	}

	/**
	 * This method boards a south bound train by retrieving the
	 * first train from the queue of south bound trains and
	 * boarding as many passengers as possible. 
	 * 
	 * RUNTIME: O(n)
	 * @return the boarded south bound train
	 */
	public Train southBoardTrain() {
		if(southBoundTrains.size() == 0) {
			return null;
		}

		Train southBoundTrain = southBoundTrains.front();
		while(southBoundTrain.hasSpaceForPassengers() && southBoundRiders.size() != 0) {
		
			int rider = southBoundTrains.front().passengerIndex;
			Rider r = southBoundTrains.front().passengers[rider];
			southBoundTrain.addPassenger(r);
			southBoundRiders.dequeue();
		}


		return southBoundTrain;
	}

	/**
	 * This method boards a north bound train by retrieving the
	 * first train from the queue of north bound trains and
	 * boarding as many passengers as possible. 
	 * 
	 * RUNTIME: O(n)
	 * @return the boarded north bound train
	 */
	public Train northBoardTrain() {
		if(northBoundTrains.size() == 0) {
			return null;
		}


		Train northBoundTrain = northBoundTrains.front();
		while(northBoundTrain.hasSpaceForPassengers() && northBoundRiders.size() != 0) {
			int rider = northBoundTrains.front().passengerIndex;
			Rider r = northBoundTrains.front().passengers[rider];
			northBoundTrain.addPassenger(r);
			northBoundRiders.dequeue();
		}
		return northBoundTrain;

	}

	/**
	 * This method changes the trains direction from 
	 * north to south, then adds the new south
	 * bound train to the southBoundTrains queue
	 * 
	 * RUNTIME: O(1)
	 */
	public void moveTrainNorthToSouth() {
		if(northBoundTrains.size() != 0) {
			Train a = northBoundTrains.front();
			a.swapDirection();
			northBoundTrains.dequeue();
			southBoundTrains.enqueue(a);
		}

	}


	/**
	 * This method changes the trains direction from 
	 * south to north, then adds the new north
	 * bound train to the northBoundTrains queue
	 * 
	 * RUNTIME: O(1)
	 */
	public void moveTrainSouthToNorth() {
		if(southBoundTrains.size() != 0) {
			Train a = southBoundTrains.front();
			a.swapDirection();
			southBoundTrains.dequeue();
			northBoundTrains.enqueue(a);
		}

	}

	/**
	 * This method returns a String of the 
	 * current passengers and trains at 
	 * the current station.
	 * 
	 * RUNTIME: O(1)
	 * @return String stationName
	 */
	@Override
	public String toString() {
		String stationName = stationName();

		int nbt = northBoundTrains.size();
		int sbt = southBoundTrains.size();
		int nbr = northBoundRiders.size();
		int sbr = southBoundRiders.size();



		return "Station: " + stationName + "\n" + nbt + " north-bound trains waiting" 
		+ "\n" +  sbt + " south-bound trains waiting" + "\n"
		+	nbr + " north-bound passengers waiting" + "\n"
		+ sbr + " south-bound passengers waiting" ;
	}

	/**
	 * This method returns the name of the station
	 * 
	 * RUNTIME: O(1)
	 * @return the station name
	 */
	public String stationName() {
		return this.name;
	}

	/**
	 * This method compares the station name to another
	 * station's name; returns true if their String values
	 * are equal.
	 * 
	 * RUNTIME: O(1)
	 * @return true, if the String values are equivalent
	 */
	@Override
	public boolean equals(Object o) {

		if(this.stationName().equals(((Station) o).stationName())) {
			return true;
		}

		return false;
	}


}
