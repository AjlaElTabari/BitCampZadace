package homework23;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Represents an implementation of stack of integers logic, using arrays.
 * @author ajla.eltabari
 *
 */
public class StackInt {
	private int[] array;
	
	/**
	 * Constructor.
	 * Initializing an array to length of zero.
	 */
	public StackInt() {
		this.array = new int[0];
	}

	/**
	 * Checks if stack is empty.
	 * @returns true if it is, and false if it is not.
	 */
	public boolean empty() {
		return (array.length == 0);
	}
	
	/**
	 * Adds element at the end of the stack.
	 * @param value
	 * @return
	 */
	public int push(int value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return value;
	}
	
	/**
	 * Removes last added element from the stack.
	 * @return
	 * @throws EmptyStackException
	 */
	public int pop() throws EmptyStackException {
		if (array.length > 0) {
			int temp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);
			return temp;
		} else {
			throw new EmptyStackException();
		}
	}
	
	/**
	 * Returns last added element from the stack.
	 * Does'n do anything with that element.
	 * @return
	 * @throws EmptyStackException
	 */
	public int peek() throws EmptyStackException {
		if (array.length > 0) {
			return array[array.length - 1];
		} else {
			throw new EmptyStackException();
		}
	}
	
	/**
	 * Prints out information about stack elements.
	 */
	public String toString() {
		return Arrays.toString(array);
	}
}
