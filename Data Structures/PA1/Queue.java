package main;


import java.util.Arrays;

import java.util.NoSuchElementException;

/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * October 18, 2023
 * COSI 21A PA1
 * 
 * The Queue class holds the implementation of a first-in
 * first-out queue. This method holds various methods for
 * a queue to perform different actions, such as dequeue and 
 * enqueue. This class will be used to create various objects
 * relating to the overall assignment.
 * 
 * Known Bugs: NONE
 *
 * 
 */

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail; //index of where the next element is being inserted
	public int numEntries;

	/**
	 * The constructor for the Queue class; 
	 * creates an empty class with a given 
	 * capacity.
	 * 
	 * RUNTIME: O(1)
	 * @param capacity
	 */
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		head = 0;
		tail = 0;
		numEntries = 0;
	}

	/**
	 * This method adds a new element to the
	 * end of the Queue.
	 * 
	 * RUNTIME: O(1)
	 * @param element
	 */
	public void enqueue(T element) {
		q[tail] = element;
		tail++;
		numEntries++;
	}

	/**
	 * This method removes the first element
	 * of the queue. If there are no elements 
	 * in the queue, an error is thrown
	 * 
	 * RUNTIME: O(1)
	 */
	public void dequeue() { 
		if(numEntries == 0) {
			throw new NoSuchElementException("Queue is empty");
		}
		q[head] = null;
		head++;	
		numEntries--;

	}

	/**
	 * This method returns the first element
	 * of the queue WITHOUT removing it. Throws
	 * and error if the queue is empty.
	 * 
	 * RUNTIME: O(1)
	 * @return the first element in the queue
	 */
	public T front() {
		if(numEntries == 0) {
			throw new NoSuchElementException("Queue is empty");
		}
		return q[head];

	}

	/**
	 * This method returns how many elements are
	 * stored in the queue.
	 * 
	 * RUNTIME: O(1)
	 * @return numEntries
	 */
	public int size() {
		return numEntries;
	}

	
	/**
	 * This method returns the contents of the
	 * queue as a string, surrounded by brackets
	 * and separated by ", ".
	 * 
	 * RUNTIME: O(n)
	 * 
	 * @return String printed
	 */
	@Override
	public String toString() {
		String printed = new String("[");
		for(int i = 0; i<=numEntries; i++) {
			if(q[i] != null) {
				printed += q[i].toString();
				if(q[i+1] != null) { //if the element is not the last
					printed += ", ";
				}
				
			}
			
		}
		
		printed += "]";
		return printed.toString();
	}

}
