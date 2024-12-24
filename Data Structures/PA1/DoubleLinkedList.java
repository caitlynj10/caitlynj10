package main;

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
public class DoubleLinkedList<T> {
	private Node<T> head;
	private int size;

	/**
	 * The constructor for this class; 
	 * constructs an empty Double Linked List
	 * 
	 * RUNTIME: O(1)
	 */
	public DoubleLinkedList() {
		this.size = 0;
		this.head = null;
	}

	/**
	 * This method returns the first node
	 * of the linked list.
	 * 
	 * RUNTIME: O(1)
	 * @return head
	 */
	public Node<T> getFirst() {
		return head;
	}


	/**
	 * This method inserts a given element into
	 * the linked list.
	 * 
	 * @param element
	 * RUNTIME: O(n)
	 */
	public void insert(T element) {
		Node<T> newNode = new Node<>(element);
		if(head == null) {
			head = newNode;
		}
		else {
			Node<T> currNode = head;
			while(currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			currNode.setNext(newNode);
			newNode.setPrev(currNode);
		}
		size++;
	}

	/**
	 * This methods deletes a given key from
	 * the linked list and returns it
	 * 
	 * RUNTIME: O(n)
	 * @param key
	 * @return the deleted element
	 */
	public T delete(T key) {
		Node<T> currNode = head;

		while(currNode != null) {
			if(currNode.getData().equals(key)) {
				if(currNode.getPrev() != null) {
					currNode.getPrev().setNext(currNode.getNext());;
				}
				else {
					head = currNode.getNext();
				}
				
				if (currNode.getNext() != null) {
					currNode.getNext().setPrev(currNode.getPrev());
				}
				size--;
				return currNode.getData();
			}
			currNode = currNode.getNext();
		}
		return null;

	}

	/**
	 * This method retrieves the given key
	 * from the linked list; returns the null
	 * if the element was not found.
	 * 
	 * RUNTIME: O(n)
	 * @param key
	 * @return the found element
	 */
	public T get(T key) {
		Node<T> currNode = head;

		while(currNode != null) {
			if(currNode.getData().equals(key)) {
				return currNode.getData();
			}
			currNode = currNode.getNext();
		}
		
		return null;
	}

	/**
	 * This method returns the number of elements
	 * in the list
	 * 
	 * RUNTIME: O(1)
	 * @return size
	 */
	public int size() {
		return size;
	}
	
	
	
	/**
	 * This method prints out the contents of the
	 * linked list as a string, surround by brackets
	 * and separated by ", ".
	 * 
	 * RUNTIME: O(n)
	 * @return String printed	
	 */
	@Override
	public String toString() {
		String printed = new String("[");
		Node<T> currNode = head;
		
		while(currNode != null) {
			printed += currNode.getData();
			if(currNode.getNext() != null) { //if the node is not the last one
				printed += ", ";
			}
			currNode = currNode.getNext();
		}
		
		printed += "]";
		return printed.toString();
	}
	
	
}
