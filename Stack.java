import java.util.Stack;
class StackPractice{
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("peek element" +stack.peek());
		System.out.println("pop element" +stack.pop());
		System.out.println("is stack empty" +stack.isEmpty());
		System.out.println("size of the stack" +stack.size());
	}
}
		