package sorted_linked_list;

/**
 * Implementira interface za rad s listom integera koji su uvijek sortirani.
 * 
 * @author Damir Zekic
 */
public class SortedIntList {
	private Node start;

	/**
	 * Ubacuje broj u listu, cuvajuci listu sortiranom.
	 * <p>
	 * TODO: Zavrsiti implementaciju metode
	 * 
	 * @param n
	 *            broj koji ubacujemo u listu.
	 */
	public void add(int n) {
		Node newNode = new Node(n);
		if (start == null) {
			start = newNode;
		} else {
			Node temp = start;
			if (temp.getValue() > newNode.getValue()) {
				newNode.setNext(start);
				start = newNode;
				return;
			}
			while (temp.getNext() != null) {
				if (newNode.getValue() < temp.getNext().getValue()) {
					newNode.setNext(temp.getNext());
					temp.setNext(newNode);
					return;
				}
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	/**
	 * Vraca duzinu liste
	 * <p>
	 * TODO: prepisati ovu metodu tako da koristi rekurziju umjesto iteracije
	 * <p>
	 * Ako zapnete s rekurzijom pokusajte barem prepisati kôd koristeci `for`
	 * petlju umjesto `while`.
	 * 
	 * @return duzina liste
	 */
	public int getLength() {
		return (start == null) ? 0 : getLength(start);
	}

	private int getLength(Node node) {
		return (node.getNext() == null) ? 1 : getLength(node.getNext()) + 1;
	}

	/**
	 * Pretvara linkanu listu u niz
	 * <p>
	 * TODO: zavrsiti implementaciju
	 * 
	 * @return niz sa svim elementima iz liste
	 */
	public int[] toArray() {
		int n = getLength();
		int[] result = new int[n];
		Node temp = start;
		
		for (int i = 0; i < n; i++) {
			result[i] = temp.getValue();
			temp = temp.getNext();
		}
		return result;
	}

	private class Node {

		private int value;
		private Node next;

		/**
		 * @param value
		 */
		public Node(int value) {
			super();
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
			if (next == null)
				return String.valueOf(value);
			return String.valueOf(value) + ", " + next;
		}
	}
}
