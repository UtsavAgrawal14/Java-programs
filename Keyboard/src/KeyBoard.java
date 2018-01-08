/*
 * Simulates a keyboard with the following keys:
 * '@' - Caps Lock
 * '#' - Enter
 * '/' - Backspace
 * '?' - Down Arrow key
 * '^' - Up Arrow key
 * '<' - Left Arrow key
 * '>' - Right Arrow key
 * and alphanumeric keys
 * 
 * Input Format:
 * 1. A string containing any sequence of allowed characters.
 * 
 * Output Format:
 * A representation of how the string would look like.
 * NOTE: Caps lock is initially OFF, i.e letters will be lower case initially.
 */
import java.util.ArrayList;
import java.util.Scanner;

class KeyBoard {
	public static void main(String[] args) throws Exception {
		boolean caps = false;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int linePos = 0;
		int cursor = 0;
		char[] arr = str.toCharArray();
		ArrayList<ArrayList<Character>> res = new ArrayList<>();
		res.add(new ArrayList<>());

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] >= 48 && arr[i] <= 57) || (arr[i] == ' ')) {
				res.get(linePos).add(cursor, arr[i]);
				cursor++;
			} else if ((arr[i] >= 97 && arr[i] <= 122)) {
				if (caps) {
					res.get(linePos).add(cursor, Character.toUpperCase(arr[i]));
					// System.out.println(linePos);
				} else
					res.get(linePos).add(cursor, arr[i]);
				cursor++;
			} else {
				switch (arr[i]) {
				case '@':
					caps = !caps;
					break;
				case '#':
					res.add(new ArrayList<>());
					cursor = 0;
					linePos++;
					break;
				case '/':
					if (cursor == -1) {
						if (linePos > 0) {
							linePos--;
							cursor = res.get(linePos).size() - 1;
						}
					} else {
						res.get(linePos).remove(cursor - 1);
						cursor--;
					}
					break;
				case '?':
					if (linePos < res.size() - 1) {
						linePos++;
						if (res.get(linePos).size() < cursor)
							cursor = res.get(linePos).size();
					}
					break;
				case '^':
					if (linePos > 0) {
						--linePos;
						if (res.get(linePos).size() < cursor)
							cursor = res.get(linePos).size();
					}
					break;
				case '<':
					if (cursor > 0)
						cursor--;
					else if (linePos > 0) {
						linePos--;
						cursor = res.get(linePos).size();
					}
					break;
				case '>':
					if (cursor < (res.get(linePos).size() - 1))
						cursor++;
					else if (linePos < res.size() - 1) {
						++linePos;
						cursor = 0;
					}
					break;
				default:
				}
			}

		}

		for (ArrayList<Character> k : res) {
			for (Character c : k) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}