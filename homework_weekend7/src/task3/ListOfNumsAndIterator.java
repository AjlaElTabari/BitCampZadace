package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Creates new List, every third element is sum of previous two elements. 
 * @author ajla
 *
 */
public class ListOfNumsAndIterator {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		for (int i = 0; i < 11; i++) {
			numbers.add(i);
		}
		
		System.out.println("Original list: " + numbers);
		
		ListIterator<Integer> it = numbers.listIterator();
		
		while (it.hasNext()) {
			int tmp = it.next();
			if(it.hasNext()){
				it.remove();
				tmp += it.next();
				it.set(tmp);
			}
		}
		System.out.println("New list: " + numbers);
		
	}
}
