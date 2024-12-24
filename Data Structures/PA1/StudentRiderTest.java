package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Rider;

class StudentRiderTest {


	
	
	@Test
	void constructorTest() {
		Rider r = new Rider("ABC123","Alewife", "Braintree");
		assertEquals("ABC123", r.getRiderID());
		assertEquals("Alewife", r.startingStation);
		assertEquals("Braintree", r.getDestination());
		assertFalse(r.goingNorth());	
	}
	
	@Test
	void methodsTest() {
		Rider r = new Rider("ABC123","Alewife", "Braintree");
		assertFalse(r.goingNorth());
		r.swapDirection();
		assertTrue(r.goingNorth());
		
		Rider b = new Rider("ABC123", "a", "b");
		assertEquals(r,b);

	}
	@Test
	void initTest() {
		Rider r = new Rider("abc123", "Alewife", "Braintree");
		
		assertEquals("abc123", r.getRiderID());
		assertEquals("Alewife", r.getStarting());
		assertEquals("Braintree", r.getDestination());
		assertFalse(r.goingNorth());

	}
	
	@Test
	void testEquals() {
		Rider r = new Rider("abc123", "Alewife", "Braintree");
		Rider r1 = new Rider("abc123", "a", "b");
		assertEquals(r1, r);
	}
	
	

}
