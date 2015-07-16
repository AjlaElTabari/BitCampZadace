package homework23;

/**
 * Represents an implementation of stack of integers, using arrays.
 * 
 * @author ajla.eltabari
 *
 */
import java.util.EmptyStackException;

public class StackLinkedInt {
	private Node head;

	/**
	 * Empty constructor.
	 * Initialize head node to null.
	 */
	public StackLinkedInt() {
		head = null;
	}

	/**
	 * Checks if stack is empty.
	 * @returns true if it is, and false if it is not.
	 */
	public boolean empty() {
		return head == null;
	}

	/**
	 * Adds element at the end of the stack.
	 * @param value
	 * @return
	 */
	public int push(int value) {
		if (head == null) {
			head = new Node(value);
		} else {
			Node tmp = new Node(value);
			tmp.setNext(head);
			head = tmp;
		}
		return value;
	}
	
	/**
	 * Returns last added element from the stack.
	 * Does'n do anything with that element.
	 */
	public int peek() {
		return head.getValue();
	}
	
	/**
	 * Removes last added element from the stack.
	 * @return
	 */
	public int pop()	 {
		if(head == null){
			throw new EmptyStackException();
		}
		
		int tmp = head.getValue();
		head = head.getNext();
		return tmp;
	}
	
	/**
	 * Prints out information about stack elements.
	 */
	public String toString() {
		if(head == null) {
			return "Stack is empty!";
		}else{
			return head.toString();
		}
	}

	/**
	 * Inner class that represents node of linked list.
	 * Node contains integer value and pointer the next node.
	 * @author ajla.eltabari
	 *
	 */
	private class Node {

		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
			next = null;
		}

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(int value) {
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

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + " " + next.toString();
		}

	}

	public static void main(String[] args) {

		StackLinkedInt stack = new StackLinkedInt();
		System.out.println(stack.empty());
		System.out.println(stack.push(3));
		System.out.println(stack.push(7));
		System.out.println(stack);
		stack.push(15);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		
		System.out.println(stack.peek());

	}

}
