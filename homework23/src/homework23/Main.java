package homework23;

public class Main {

	public static void main(String[] args) {
		StackInt stack = new StackInt();
		stack.push(5);
		stack.push(15);
		stack.push(6);
		System.out.println(stack.empty());
		System.out.println(stack);
		
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.peek());

	}

}
