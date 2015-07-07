package homework_oop;


/**
 * Represents tool box for computers array manipulation
 * Contains methods for increasing and decreasing computers array
 * @author ajla
 *
 */
public class ArrayManipulation {
	
	/**
	 * Simulates increasing array by one, by making
	 * a new array, and then copying values from old array to the new one
	 * New member of the array is null
	 * @param array
	 * @return
	 */
	public static Computer[] extendArray(Computer[] array) {

		// making new array with capacity of old one plus 1
		Computer[] newArray = new Computer[array.length + 1];
		
		// coping values from the old array to the new one
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = array[i];
		}

		return newArray;
	}

	/**
	 * Simulates decreasing array by one, by deleting 
	 * the array member on provided index.
	 * @param array
	 * @return
	 */
	public static Computer[] shrinkArray(Computer[] array, int index) {
		
		// making new array with capacity of old one minus 1
		Computer[] newArray = new Computer[array.length - 1];

		// coping values from the old array to the new one
		for (int i = 0; i < newArray.length; i++) {
			if (array[i] != array[index]) {
				newArray[i] = array[i];
			}
		}
		return newArray;
	}
}