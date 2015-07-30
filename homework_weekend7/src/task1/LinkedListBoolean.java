package task1;

import java.util.NoSuchElementException;

/**
 * Represents implementation of LinkedList for boolean values. Implements common
 * methods related to the LinkedList.
 * 
 * @author ajla
 *
 */

public class LinkedListBoolean {
	private Node head;

	/**
	 * Adds element at the end of the list.
	 * 
	 * @param value
	 * @return
	 */
	public void add(boolean value) {
		if (head == null) {
			head = new Node(value);
			return;
		}

		Node tmp = head;

		while (tmp.getNextNode() != null) {
			tmp = tmp.getNextNode();
		}
		tmp.setNextNode(new Node(value));
	}

	/**
	 * Removes first element with given value.
	 * 
	 * @param elem
	 * @throws NoSuchElementException
	 */
	public void remove(boolean elem) throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException();
		if (head.getValue() == elem) {
			head = head.getNextNode();
			return;
		}

		Node tmp = head.getNextNode();
		while (tmp != null) {
			if (tmp.next.getValue() == elem) {
				tmp.setNextNode(tmp.next.next);
				break;
			} else {
				tmp = tmp.next;
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Removes first element with given value, after given index.
	 * 
	 * @param elem
	 * @param index
	 * @throws NoSuchElementException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void remove(boolean elem, int index) throws NoSuchElementException,
			ArrayIndexOutOfBoundsException {
		int size = size(), count = 0;
		Node tmp = head;

		for (int i = 0; i < size; i++) {
			if (head == null || index < 0 || index >= size) {
				throw new ArrayIndexOutOfBoundsException();
			} else if (count != index) {
				tmp = tmp.getNextNode();
			} else {
				remove(elem);
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Checks if given element exists in the list.
	 * 
	 * @param value
	 * @returns true if it exists, and false if it is not.
	 */
	public boolean contains(boolean value) {
		Node tmp = head;
		for (int i = 0; i < size(); i++) {
			if (tmp.getValue() == value)
				return true;
		}
		return false;
	}

	/**
	 * Checks if elements are sorted like: true, false, true, false...
	 * 
	 * @returns true if they are, and false if they are not.
	 */
	public boolean isAlternating() {
		if (head == null) {
			return false;
		}
		Node tmp = head;
		boolean tmpValue = head.getValue();
		for (int i = 0; i < size(); i++) {
			if (tmp.getValue() == tmpValue) {
				tmpValue = !tmpValue;
			} else {
				return false;
			}
			tmp = tmp.getNextNode();
		}
		return true;
	}

	/**
	 * Calculates size of the linked list, based on the head node
	 * 
	 * @return size of the linked list
	 */
	public int size() {
		Node tmp = head;
		int size = 0;
		while (tmp != null) {
			size++;
			tmp = tmp.getNextNode();
		}
		return size;
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
	 * Inner class that represents node of linked list. Node contains Boolean
	 * value and pointer the next node.
	 * 
	 * @author ajla
	 *
	 */
	private class Node {

		private boolean value;
		private Node next;

		public Node(boolean value) {
			this.value = value;
		}

		/**
		 * @return the next
		 */
		public Node getNextNode() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNextNode(Node next) {
			this.next = next;
		}

		/**
		 * @return the value
		 */
		public boolean getValue() {
			return value;
		}

		@Override
		public String toString() {
			return head.getValue() + "";
		}
	}
}