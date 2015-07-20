package task2;

import java.util.EmptyStackException;

/**
 * Represents an implementation of stack of integers logic, with condition:
 * elements can not be duplicated.
 * 
 * @author ajla
 *
 */
public class UniqueStackInt {

	private Node head;

	/**
	 * Adds element at the end of the stack.
	 * 
	 * @param elem
	 * @return
	 */
	public int push(int elem) {
		if (head == null) {
			head = new Node(elem);
			return elem;
		}

		Node tmp = head;

		while (tmp.getNext() != null) {
			if (tmp.getValue() == elem) {
				System.out
						.println("Desired element already exists and could not be pushed.");
			} else {
				tmp = tmp.getNext();
			}
		}

		tmp = new Node(elem);
		tmp.setNext(head);
		head = tmp;
		return elem;
	}

	/**
	 * Removes last added element from the stack.
	 * 
	 * @return
	 * @throws EmptyStackException
	 */
	public int pop() throws EmptyStackException {
		if (head == null)
			throw new EmptyStackException();
		head = head.getNext();
		return head.getValue();
	}

	/**
	 * Checks if elements are sorted increasing from the lowest to the highest.
	 * 
	 * @return
	 */
	public boolean isIncreasing() {
		if (head == null)
			return true;
		int tmpValue = head.getValue();
		Node tmp = head;
		while (tmp != null) {
			if (tmpValue <= tmp.getValue()) {
				tmp = tmp.getNext();
				tmpValue = tmp.getValue();
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Prints out all nodes from the linked list, based on head node.
	 */
	@Override
	public String toString() {
		String result = "";

		Node tmp = head;
		while (tmp != null) {
			result += tmp.getValue() + " ";
			tmp = tmp.next;
		}

		return result;
	}

	/**
	 * Inner class that represents node of linked list.
	 * Node contains Integer value and pointer the next node.
	 * @author ajla
	 *
	 */
	private class Node {

		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return head.getValue() + "";
		}
	}
}
