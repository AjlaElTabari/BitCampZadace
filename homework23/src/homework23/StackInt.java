package homework23;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackInt {
	private int[] array;
	
	public StackInt() {
		this.array = new int[0];
	}

	public boolean empty() {
		return (array.length == 0);
	}
	
	public int push(int value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return value;
	}
	
	public int pop() throws EmptyStackException {
		if (array.length > 0) {
			int temp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);
			return temp;
		} else {
			throw new EmptyStackException();
		}
	}
	
	public int peek() throws EmptyStackException {
		if (array.length > 0) {
			return array[array.length - 1];
		} else {
			throw new EmptyStackException();
		}
	}
	
	public String toString() {
		return Arrays.toString(array);
	}
}
