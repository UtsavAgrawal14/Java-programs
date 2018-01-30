import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Stack {

	List<Character> values = new ArrayList<>();
	int top = -1;

	public void push(char elem) {
		++top;
		values.add(elem);
	}

	public char pop() throws IOException {
		if (isEmpty()) {
			throw new IOException("Underflow in stack");
		}
		char val = values.remove(top--);
		return val;
	}

	public char peek() throws IOException {

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
		for (int i = 0; i < length; ++i) {
			elem = infix.charAt(i);
			if (Character.isDigit(elem) || Character.isAlphabetic(elem)) {
				System.out.print(elem);
			} else {
				if (elem == ')') {
					while (!stack.isEmpty()) {
						char elem2 = stack.pop();
						if (elem2 == '(')
							break;
						else {
							System.out.print(elem2);
						}
					}
				} else { // elem is an operator.
					try {
						char elemFromTop = stack.peek();
						if (elem == '(' || isLowerPriority(elemFromTop, elem)) {
							stack.push(elem);
						} else {
							while (!isLowerPriority(elemFromTop, elem)) {
								System.out.print(stack.pop());
								elemFromTop = stack.peek();
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
			System.out.print(stack.pop());
		}
	}

	static boolean isLowerPriority(char op1, char op2) {
		if (priority.get(op1) < priority.get(op2))
			return true;
		return false;
	}

}
