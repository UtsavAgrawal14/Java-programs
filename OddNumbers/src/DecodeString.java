import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Finds the number of occurrences of each alphabet in the original string for given encoded string.
 * Encoding Procedure:
 * Strings can only contain lower case letters.
 * a is encoded as 1, b as 2.. i as 9, j is encoded as 10#, k as 11#, and similarly z as 26#.
 * If a letter occurs more than once in the original string, it is represented with the frequency specified within parenthesis.
 * 
 * Input Format:
 * Encoded String
 * 
 * Output Format:
 * An array(of size 26) specifying the frequency of each letter in the original string.
 */
public class DecodeString {

	public static void main(String[] args) throws IOException {
		int[] freq = new int[26];
		System.out.println("Enter encoded string:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] code = s.toCharArray();
		int numR = 0, numL = 0, count = 0, num = 0;
		boolean flag = true;
		for (int i = code.length - 1; i >= 0; --i) {
			if (code[i] == ')') {
				flag = false;
				numR = i;
			} else if (code[i] == '(') {
				numL = i + 1;
				try {
					count = Integer.parseInt(s.substring(numL, numR));
				} catch (NumberFormatException nfe) {
					System.err.println("Frequency of a letter should be a number, (" + s.substring(numL, numR) + ") is invalid.");
					System.exit(0);
				}
				// Uncomment the line below and enable assertions using -ea in vm arguments in run configurations.
				// assert (count > 2) : "Value in parenthesis should always be greater than 2, ("+s.substring(numL, numR)+") is invalid.");
				if (count < 2) {
					System.err.println("Value in parenthesis should always be greater than 2, '" + count + "' is not allowed.");
					System.exit(0);
				}
				// assert( count > 2) : "Value in parenthesis should always be greater than 2, '" + count + "' is not allowed.";
				flag = true;
			} else if (code[i] == '#') {
				try {
					num = Integer.parseInt(s.substring(i - 2, i));
				} catch (NumberFormatException nfe) {
					System.err.println("Only numbers are allowed in coded string, '" + s.substring(i, i + 1) + "' is invalid.");
				}
				if (num > 26 || num < 10) {
					System.err.println("Code should have a value between 10# and 26#, '" + s.substring(i - 2, i) + "#' is not allowed.");
					System.exit(0);
				}
				// assert(num < 27 && num > 9) : "Code should have a value between 10# and 26#, '" + s.substring(i - 2, i) + "#' is not allowed.";
				updateFreq(freq, num - 1, count);
				count = 1;
				numR = 0;
				numL = 0;
				i = i - 2;
			} else {
				if (flag) {
					try {
						num = Integer.parseInt(s.substring(i, i + 1));
					} catch (NumberFormatException nfe) {
						System.err.println("Only numbers, () and # are allowed in coded string, '"+ s.substring(i, i + 1) + "' is invalid.");
						System.exit(0);
					}
					if (num < 1) {
						System.err.println("Code cannot be less than 1, '" + num + "' is invalid.");
						System.exit(0);
					}
					// assert(num > 1) : "Code cannot be less than 1, '" + num + "' is invalid";
					updateFreq(freq, num - 1, count);
					count = 1;
					numR = 0;
					numL = 0;
				}
			}
		}
		for (int i : freq) {
			System.out.print(i + " ");
		}

	}

	static void updateFreq(int[] freq, int num, int count) {
		freq[num] += count;
	}

}
