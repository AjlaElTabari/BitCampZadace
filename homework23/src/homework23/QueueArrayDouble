package homework23;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Represents an implementation of queue of doubles, using arrays.
 * 
 * @author ajla.eltabari
 *
 */
public class QueueArrayDouble {
	private Double[] array;

	/**
	 * Constructor. Initializing an array to length of zero.
	 */
	QueueArrayDouble() {
		array = new Double[0];
	}

	/**
	 * Implementation of add method for queues. Adds element at the beginning of
	 * the array.
	 */
	public Double add(Double value) {
		Double[] newArray = new Double[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			newArray[i + 1] = array[i];
		}
		newArray[0] = value;
		array = newArray;
		return value;
	}

	/**
	 * Returns first added element from the queue. Does'n do anything with that
	 * element. If queue is empty, returns null.
	 * 
	 * @throws EmptyStackException
	 */
	public Double peek() {
		if (array.length > 0) {
			return array[array.length - 1];
		} else {
			return null;
		}
	}

	/**
	 * Removes first added element from the queue. Returns null if queue is
	 * empty.
	 */
	public Double poll() {
		if (array.length > 0) {
			double temp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * Returns first added element from the queue. Does'n do anything with that
	 * element.
	 * 
	 * @return
	 * @throws EmptyStackException
	 */
	public Double element() throws EmptyStackException {
		if (array.length > 0) {
			return array[array.length - 1];
		} else {
			throw new EmptyStackException();
		}
	}
	
	/**
	 * Retrieves and removes the head of this queue.
	 * @return
	 */
	public Double remove() throws NoSuchElementException {
		if (array.length > 0) {
			throw new NoSuchElementException();
		} else {
			Double value = array[0];
			array = Arrays.copyOf(Arrays.copyOfRange(array, 1, array.length),
					array.length - 1);
			return value;
		} 
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions.
	 * 
	 * @param value
	 * @return true if operation was successful, and false if it wasn't
	 */
	public boolean offer(Double value) {
		try {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = value;
			return true;
		} catch (NullPointerException e1) {
			return false;
		} catch (ClassCastException e2) {
			return false;
		} catch (IllegalArgumentException e3) {
			return false;
		}
	}
}
