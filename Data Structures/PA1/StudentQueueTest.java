package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import main.Queue;

class StudentQueueTest {


	@Test
	void constructorTest() {
		Queue<Integer> q = new Queue<Integer>(2);
		assertEquals("[]", q.toString());
		assertThrows(NoSuchElementException.class,() -> q.dequeue(), "Queue is empty");
	}
	
	@Test
	void enqueueTest() {
		Queue<Integer> q = new Queue<Integer>(10);
		q.enqueue(2);
		assertEquals("[2]", q.toString());
		
		q.enqueue(3);
		q.enqueue(4);
		assertEquals("[2, 3, 4]", q.toString());
	}
	
	@Test
	void dequeueTest() {
		Queue<Integer> q = new Queue<Integer>(10);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		
		q.dequeue();
		
		assertEquals("[3, 4]", q.toString());
	}
	
	@Test
	void frontTest() {
		Queue<Integer> q = new Queue<Integer>(10);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
	
		assertEquals("2", q.front().toString());
	}
	
	@Test
	void sizeTest() {
		Queue<Integer> q = new Queue<Integer>(10);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		assertEquals(3, q.size());
		
		q.dequeue();
		
		assertEquals(2 , q.size());
	}
	

}
