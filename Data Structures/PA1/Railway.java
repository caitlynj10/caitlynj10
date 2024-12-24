package main;

import java.util.Arrays;
/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * October 18, 2023
 * COSI 21A PA1
 * 
 * The Railway class holds the implementation of 
 * the red line. It holds the methods and actions 
 * that will allow the red line simulation to run
 * properly. The contents of this class use methods 
 * from all the previous classes.
 * 
 * Known Bugs: 2
 *
 */

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	public int index;

	/**
	 * The constructor for the Railway class;
	 * constructs a railway as a double linked 
	 * list AND an array of station names
	 * 
	 * RUNTIME: O(1)
	 */
	public Railway() {
		this.railway = new DoubleLinkedList<Station>();
		this.stationNames = new String[18];
		this.index = 0;
	}

	/**
	 * This method adds a station to the railway
	 * if it has not been added yet.
	 * 
	 * RUNTIME: O(1)
	 * @param s
	 */
	public void addStation(Station s) {
		if(railway.get(s) == null) { //if the station isn't already added
			railway.insert(s);
			stationNames[index] = s.stationName();
			index++;
		}
	}

	/**
	 * This method adds a rider to a station in 
	 * the railway.
	 * 
	 * RUNTIME: O(n)
	 * 
	 * @param r
	 */
	public void addRider(Rider r) {
		setRiderDirection(r); //swap direction if need be
		Node<Station> currentStationNode = railway.getFirst();
		while(currentStationNode.getNext() != null) {
			Station stat = currentStationNode.getData(); //returns the station in the railway
			if(stat.stationName().equals(r.getStarting())) {
				stat.addRider(r);
				//System.out.println("Passengers added: " + r.toString());
			}
			currentStationNode = currentStationNode.getNext();
		}

	}

	/**
	 * This method adds a train to a station in the railway
	 * 
	 * RUNTIME: O(n)
	 * @param t
	 */
	public void addTrain(Train t) {
		if(railway.getFirst() != null) {
			Node<Station> currentStationNode = railway.getFirst();
			while(currentStationNode.getNext() != null) {
				Station stat = currentStationNode.getData();
				if(stat.stationName().equals(t.getStation())){
					stat.addTrain(t);
					//System.out.println("Trains added: " + t.currentStation);


				}
				currentStationNode = currentStationNode.getNext();

			}
		}


	}

	/**
	 * This methods sets the rider's direction based
	 * on its starting station and destinantion station.
	 * 
	 * RUNTIME: O(1)
	 * @param r
	 */
	public void setRiderDirection(Rider r) {
		int start = stationIndex(r.getStarting()); //0 //4
		int end = stationIndex(r.getDestination()); //3 //2

		if(start > end) { //if going north
			r.swapDirection(); //starting direction is south; swap direction to north
		}

	}

	/**
	 * This method holds all the mechanics for moving a train.
	 * At each station, trains are boarded, trains are moved, and
	 * if the station is Braintree or Alewife, trains are moved 
	 * from north to south.
	 * 
	 * RUNTIME: O(n^2)
	 * @return log
	 */
	public String simulate() {
		String log = "";
		Node<Station> currentStationNode = railway.getFirst();
		while(currentStationNode != null) { //at every station, north to south
			Station currentStation = currentStationNode.getData();
			log += currentStation.toString();

			//board a southbound or northbound train with as many passengers as possible unless the station is (Braintree/Alewife)
			if(!currentStation.stationName().equals("Braintree") && !currentStation.stationName().equals("Alewife")){
				//create a northbound and southbound train
				
				//board the trains with as many passengers as possible
				Train southBound = currentStation.southBoardTrain();
				Train northBound = currentStation.northBoardTrain();

				Station next = currentStationNode.getNext().getData();
				Station prev = currentStationNode.getPrev().getData();




				//move the trains to their next station
				if(northBound != null) {
					

					northBound.updateStation(prev.stationName());
					log+= "\n" + prev.addTrain(northBound);

					//System.out.println(northBound.disembarkPassengers());

				}

				if(southBound != null) {
					
					southBound.updateStation(next.stationName());
					log += "\n" + next.addTrain(southBound);

					//System.out.println(southBound.disembarkPassengers());
				}


				//disembark passengers



			}
			//if the current station is Braintree or Alewife, then you should move
			//a southbound train to go north/northbound train to go south
			if(currentStation.stationName().equals("Braintree")) {
				Train northBound = currentStation.northBoardTrain();
				currentStation.moveTrainSouthToNorth();
				currentStation.addTrain(northBound);

			}
			if(currentStation.stationName().equals("Alewife")) {
				Train southBound = currentStation.southBoardTrain();
				currentStation.moveTrainNorthToSouth();
				currentStation.addTrain(southBound);

			}

			currentStationNode = currentStationNode.getNext();
			log += "\n";

		}


		return log.toString();
	}

	/**
	 * This method returns the contents of the
	 * Railway as a string, surrounded by brackets
	 * and separated by ", ". The objects in the
	 * String are going to be the station names.
	 * 
	 * RUNTIME: O(n)
	 * 
	 * @return String stations
	 */
	@Override
	public String toString() {
		String stations = "[";
		for(int i = 0; i<stationNames.length; i++) {
			if(stationNames[i] != null) {
				stations += stationNames[i].toString();
				if(stationNames[i+1] != null) {
					stations += ", ";
				}
			}
		}
		stations += "]";

		return stations.toString();
	}

	/**
	 * This method searches the array of station 
	 * names and returns the index of the given name 
	 * in the array. This method is used in setRiderDirection
	 * to determine which way the rider is going.
	 * 
	 * RUNTIME: O(1) 
	 * @param name 
	 * @return the index of the name or -1 if not found
	 */
	public int stationIndex(String name) {
		for(int i = 0; i < stationNames.length; i++) {
			if(stationNames[i] != null && stationNames[i].equals(name)) {
				return i;
			}
		}

		return -1;
	}

}
