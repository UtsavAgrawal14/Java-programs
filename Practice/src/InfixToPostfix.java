import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Stack {

	List<Object> values = new ArrayList<>();
	int top = -1;

	public void push(int elem) {
		++top;
		values.add(elem);
	}

	public Object pop() throws IOException {
		if (isEmpty()) {
			throw new IOException("Underflow in stack");
		}
		return values.remove(top--);
	}

	public Object peek() throws IOException {

		if (isEmpty()) {
			throw new IOException("Underflow in stack");
		}
		return values.get(top);
	}

	public boolean isEmpty() {
		if (top < 0)
			return true;
		return false;
	}
}

public class InfixToPostfix {

	static Map<Character, Integer> priority = new HashMap<>();

	static void initMap() {
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('^', 3);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter infix expression:");
		String infix = br.readLine();
		int length = infix.length();
		char elem;
		Stack stack = new Stack();
		initMap();
		System.out.println("\nPostfix Expression:");
		StringBuilder postfix = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			elem = infix.charAt(i);
			if (Character.isDigit(elem) || Character.isAlphabetic(elem)) {
				System.out.print(elem);
				postfix.append(elem);
			} else {
				if (elem == ')') {
					while (!stack.isEmpty()) {
						char elem2 = (char) stack.pop();
						if (elem2 == '(')
							break;
						else {
							System.out.print(elem2);
							postfix.append(elem2);
						}
					}
				} else { // elem is an operator.
					try {
						char elemFromTop = (char) stack.peek();
						if (elem == '(' || isLowerPriority(elemFromTop, elem)) {
							stack.push(elem);
						} else {
							while (!isLowerPriority(elemFromTop, elem)) {
								postfix.append(elemFromTop);
								System.out.print(stack.pop());
								elemFromTop = (char) stack.peek();
							}
							stack.push(elem);
						}
					} catch (IOException ex) {
						stack.push(elem);
					}
				}
			}
		}
		while (!stack.isEmpty()) {
			elem = (char) stack.pop();
			System.out.print(elem);
			postfix.append(elem);
		}
		System.out.println("\nEvaluation:");
		for (int i = 0; i < postfix.length(); ++i) {
			elem = postfix.charAt(i);
			if (Character.isDigit(elem)) {
				stack.push(elem);
			} else {
				Integer op2 = (Integer) stack.pop(), op1 = (Integer) stack.pop();
				op2 = eval(op1, elem, op2);
				if (op2 != null)
					stack.push(Character.forDigit(op2, 10));
				// or stack.push((char)(op2+'0'));
			}
		}
		System.out.println(stack.pop());
	}

	static boolean isLowerPriority(char op1, char op2) {
		if (priority.get(op1) < priority.get(op2))
			return true;
		return false;
	}

	static Integer eval(int operand1, char operator, int operand2) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			if (operand2 != 0)
				return operand1 / operand2;
			else {
				System.err.println("Division by 0 is not defined.");
				break;
			}
		case '^':
			return (int) Math.pow(operand1, operand2);
		}
		return null;
	}

}
