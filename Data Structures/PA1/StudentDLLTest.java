package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;

class StudentDLLTest {

	@Test
	void construtorTest() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		assertEquals(0, list.size());
	}
	
	@Test
	void insertTest() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		
		assertEquals("[1, 2, 3, 4]", list.toString());

	}
	
	@Test
	void deleteTest() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		
		list.delete(3);
		
		assertEquals("[1, 2, 4]", list.toString());

	}
	
	@Test
	void getAndFirstTest() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
	
		
		assertEquals("4", list.getFirst().toString());
		assertEquals(null, list.get(3));
		assertEquals("6", list.get(6).toString());
	}
}
