package task1;

public class Main {

	public static void main(String[] args) {
		LinkedListDouble list = new LinkedListDouble();
		System.out.println(list);
		list.add(2.5);
		list.add(3.5);
		list.add(4.5);
		list.add(5.5);
		list.add(6.5);
		list.add(7.5);
		list.add(8.5);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		System.out.println(list);
		
		System.out.println(list.middle());		
		System.out.println(list.getFirst());	
		System.out.println(list.getLast());
		
		//list.deleteFirst();
		System.out.println(list);
		list.deleteLast();
		System.out.println(list);
		
	}

}
