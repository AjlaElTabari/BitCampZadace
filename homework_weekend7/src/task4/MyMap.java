package task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyMap {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter key value: ");
		int key = input.nextInt();
		System.out.print("Enter numbers limit: ");
		int numbersLimit = input.nextInt();
		
		Map<Integer, ArrayList<Integer>> map = getMap(key, numbersLimit);
		System.out.println(map);
		
		input.close();
	}
	
	/**
	 * Fills map with keys and values determined in the main method.
	 * @param key
	 * @param numbersLimit
	 * @return
	 */
	public static Map<Integer, ArrayList<Integer>> getMap(int key, int numbersLimit){
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i < key + 1; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < numbersLimit; j++) {
				list.add(i * j + 1);
			}
			map.put(i, list);
		}
		return map;
	}
}