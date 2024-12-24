package main;

/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * October 18, 2023
 * COSI 21A PA1
 * 
 * The Node class contains the implementation of
 * a doubly linked list node. This contains nodes
 * with pointers to the next node and previous node.
 * This class will be used for implentation purposes
 * in the DoubleLinkedList class.
 * 
 * Known Bugs: NONE
 *
 * 
 */
public class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	/**
	 * The Node constructor; creates an empty 
	 * node containing the given data.
	 * 
	 * @param data
	 * RUNTIME: O(1)
	 */
	 Node(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	 
	 /**
	  * This method sets the data variable of a node
	  * to a given data value.
	  * 
	  * @param data
	  * RUNTIME: O(1)
	  */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * This method sets the next node to the given
	 * next value for the node.
	 * 
	 * @param next O(1)
	 * RUNTIME:
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * This method sets the previous node to 
	 * the given previous value for the node.
	 * 
	 * @param prev
	 * RUNTIME: O(1)
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	/**
	 * This method retrieves the next node.
	 * 
	 * RUNTIME: O(1)
	 * @return next
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * This method retrieves the previous node.
	 * 
	 * RUNTIME: O(1)
	 * @return prev
	 */
	public Node<T> getPrev() {
		return prev;
	}
	
	/**
	 * This method retrieves the data of the node
	 * 
	 * RUNTIME: O(1)
	 * @return data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * This method returns the data as a String,
	 * which will change based on what type of
	 * object data is (int, Rider, Train, etc).
	 * 
	 * RUNTIME: O(1)
	 * @return String data
	 */
	@Override
	public String toString() {
		return data.toString();
	}
}
