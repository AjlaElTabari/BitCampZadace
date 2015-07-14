package task1;

/**
 * Represents a linked list of double values. Implements few standard methods
 * for linked list manipulation.
 * 
 * @author ajla.eltabari
 *
 */
public class LinkedListDouble {
	private Node head;

	/**
	 * Empty Constructor Sets start node to null (initialize empty linked list).
	 */
	public LinkedListDouble() {
		this.head = null;
	}

	/**
	 * Adds node to the linked list Checks if list is empty and adds start node,
	 * or adds node at the end of the list if it is not empty
	 */
	public void add(double value) {
		if (head == null) {
			head = new Node(value);
		} else {
			Node last = getLastNode();
			last.setNextNode(new Node(value));
		}
	}

	/**
	 * Returns last node in the linked list.
	 */
	private Node getLastNode() {
		if (head == null) {
			return null;
		}

		Node temp = head;
		while (temp.getNextNode() != null) {
			temp = temp.getNextNode();
		}
		return temp;
	}

	/**
	 * Removes node from the linked list, by index. If provided index does not
	 * exist, throws IndexOutOfBoundsException.
	 * 
	 * @param index
	 */
	public double remove(int index) throws IndexOutOfBoundsException {
		if (size() == 0) {
			System.out.println("Linked list is empty.");
			return -1;
		} else if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			head = head.getNextNode();
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.getNextNode();
		}

		Node previous = getPreviousNode(temp);
		previous.setNextNode(temp.getNextNode());
		return temp.value;
	}

	/**
	 * Returns current size of the linked list. Counts all nodes that have child
	 * nodes.
	 * 
	 * @returns integer value, that represents size of the linked list
	 */
	public int size() {
		int size = 0;
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
			size++;
		}
		return size;
	}

	/**
	 * Returns previous node of the provided node
	 * 
	 * @param node
	 * @return
	 */
	public Node getPreviousNode(Node node) {
		if (node == head) {
			return null;
		}

		Node temp = head;
		while (temp.getNextNode() != node) {
			temp = temp.getNextNode();
		}

		return temp;
	}
	
	/**
	 * Returns the element that is in the middle of the list and if there is no
	 * middle then returns left member of the middle.
	 * 
	 * @return The element that is in the middle of the list.
	 */
	public double middle() {
		
		  Node current = head;
	      int length = 0;
	      Node middle = head;
	   
	      while(current.getNextNode() != null){
	          length++;
	          if(length % 2 ==0){
	              middle = middle.getNextNode();
	          }
	          current = current.getNextNode();
	      }
	    
	      if(length % 2 == 1){
	          middle = middle.getNextNode();
	      }	
	      
	      return middle.value;
	}

	/**
	 * Prints out value of the head node
	 */
	@Override
	public String toString() {
		if (head == null) {
			return "The list is empty";
		}

		return head.toString();
	}

	/**
	 * Inner class that represents a node of linked list.
	 * 
	 * @author ajla.eltabari
	 *
	 */

	private class Node {
		private double value;
		private Node next;

		public Node(double value) {
			this.value = value;
		}

		public double getValue() {
			return value;
		}

		public Node getNextNode() {
			return next;
		}

		public void setNextNode(Node next) {
			this.next = next;
		}

		/**
		 * Prints out values of our linked list. Recursive call to toString
		 * method. Base case is when there is no more child nodes.
		 */
		@Override
		public String toString() {
			if (next == null) {
				return value + "";
			}

			return value + " " + next.toString();
		}
	}
}
