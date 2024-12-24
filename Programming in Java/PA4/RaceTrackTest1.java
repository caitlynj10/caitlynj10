package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.FormulaOne;
import main.RaceCar;
import main.RaceTrack;
import main.SportsCar;
import main.SimulationDriverC;
import static main.SimulationDriverC.*;
import main.TrackLoggerC;
import static main.TrackLoggerC.*;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 *
 *This is the first JUnit Test for this program.
 *It will be testing a 2 car race. Works as intended!
 * 
 * Known Bugs: none
 *
 */
class RaceTrackTest1 {

	
	/**
	 * Testing utility that will be used to pass RaceCar initialization data into the RaceTrack using SimulationDriver.getSomeRaceCars() 
	 * @see RaceTrack#RaceTrack(RaceCar[])
	 * @see SimulationDriverC#getSomeRaceCars()
	 */
	private static GenericConsoleTester tester = new GenericConsoleTester();
	
	/**
	 * The RaceTrack that will be used in these tests 
	 */
	private static RaceTrack track = null;
	
	/**
	 * The logger that will be used by track 
	 */
	private static TrackLoggerC logger = null;
	
	/**
	 * RaceCar to be tested on 
	 */
	private static final RaceCar RACECAR = new RaceCar(40, 3);
	
	
	/**
	 * SportsCar to be tested on 
	 */
	private static final SportsCar SPORTSCAR = new SportsCar(30, 2);
	
	/**
	 * Sets up the input/output streams before the tests are run.
	 */
	@BeforeAll
	static void setUp() { 
		tester.storeOldStreams();
	}
	
	/**
	 * Cleans up the opened input/output streams.
	 */
	@AfterAll
	static void cleanUp() {
		tester.cleanUpStreamsAndFiles();
	}
	
	/**
	 * This method checks to see if the events that occurred at a certain tick matched the expected set of events. This method takes a variable
	 * String argument to be convenient when writing the tests (as seen in testPDFOutput() below). However, the order of events in the tick do not
	 * have to match the order provided in the variable string. 
	 * @param tick a given tick to check the output at 
	 * @param exp the expected output  
	 */
	private static void testTick(int tick, String...exp) {
		Set<String> actEntry = logger.getTickLog(tick); // get the events that occurred at 'tick' from the logger 
		if (exp[0].isEmpty()) { // if entry 0 is empty, that means tick should be empty 
			assertTrue(actEntry.isEmpty(), "There should not have been any events recorded at tick " + tick);
			return;
		}
		// convert expected from var String into set so order-independent check can be made 
		Set<String> expSet = new HashSet<String>();
		for (String event : exp) {
			expSet.add(event);
		}
		int expSize = expSet.size();
		// expected & actual should have the same number of entries  
		assertEquals(expSize, actEntry.size(), String.format("Number of events at tick %d [%d] did not match expected value of [%d].", tick, actEntry.size(), expSize));
		/* at this point, expected and actual have same size. retainAll() is a "1-way intersect" and the following will remove all events
		 * from actual that DO NOT occur in expected. 
		 * 
		 * if retainAll() => true, that means 2 things: 
		 * 1) a subset of actual was not supposed to have happened: otherwise those events would have been in expected and retainAll() wouldn't have
		 * removed them
		 * 2) only a subset of the expected events actually happened: retainAll() => true will result in actual being reduced in size to the subset
		 * of events that occur in both actual and expected  
		 * 
		 * if retainAll() => false, that means retainAll() did not find any events in actual that were not in expected, but more importantly,
		 * since expected and actual have the same size, that means each event in expected was found in actual 
		 */
		System.out.println(actEntry);
		System.out.println(expSet);
		assertFalse(actEntry.retainAll(expSet), "Not all of the expected events occurred at tick " + tick + ".");
	}
	
	/**
	 * Convenience method that is used when there are long stretches of ticks where nothing may happen. This method checks to see if ticks in a
	 * certain interval [tickStart, tickEnd] all have nothing occur in them using testTick(). 
	 * @param tickStart start of the interval (note interval is inclusive) 
	 * @param tickEnd end of the interval (note interval is inclusive)
	 * @see #testTick(int, String...)
	 */
	private static void testEmptyTickRange(int tickStart, int tickEnd) {
		for (int i = tickStart; i <= tickEnd; i++) {
			testTick(i, "");
		}
	}
	
	/**
	 * Tests the students' code on sample output.
	 */
	@Test
	void testOnSampleOutput() {
		// pass race car, sports car, and formula one in through scanner and run the track
		tester.setUpInputStream("2", "40 3 " + TYPE_RACE_CAR, "30 2 " + TYPE_SPORTS_CAR);
		track = new RaceTrack();
		track.setCars(SimulationDriverC.getSomeCars());
		track.run();
		logger = track.getLogger(); // get logged results and test each tick based on expected output 
		testEmptyTickRange(1, 9);
		testTick(10, damagedStr(SPORTSCAR), damagedStr(RACECAR));
		testTick(11, "");
		testTick(12, "");
		testTick(13, enterPitStr(RACECAR));
		testTick(14, enterPitStr(SPORTSCAR));
		testTick(15, exitPitStr(RACECAR));
		testTick(16, exitPitStr(SPORTSCAR));
		testEmptyTickRange(17, 20);
		testTick(21,damagedStr(RACECAR),damagedStr(SPORTSCAR));
		testTick(22, enterPitStr(RACECAR), enterPitStr(SPORTSCAR));
		testTick(23, "");
		testTick(24, exitPitStr(RACECAR), exitPitStr(SPORTSCAR));
		testEmptyTickRange(25,28);
		testTick(29, finishedStr(RACECAR, 1));
		testEmptyTickRange(30,37);
		testTick(38, finishedStr(SPORTSCAR, 2), scoreStr(590));
	}
	
	
}