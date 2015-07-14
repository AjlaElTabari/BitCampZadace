package task1;

public class Main {

	public static void main(String[] args) {
		LinkedListDouble list = new LinkedListDouble();
		System.out.println(list);
		list.add(2.5);
		list.add(2.5);
		list.add(2.5);
		list.add(2.5);
		list.add(2.5);
		list.add(2.5);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		System.out.println(list);
		System.out.println(list.middle());
		
	}

}
