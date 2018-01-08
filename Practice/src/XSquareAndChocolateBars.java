import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*(Incorrect Output)
 * You have a chocolate bar having two types of chocolate blocks: "S" and "C". You have to give the longest block of chocolate which can be placed in boxes each of capacity
 * 3 such that no box contains pieces which are all the same. Print the number of blocks left with you after giving away such a block.
 * Input Format:
 * 1.) Number of test cases, t.
 * 2.) For each test case, input a string containing only S and C (UPPERCASE) representing the chocolate bar.
 * 
 * Output Format:
 * For each test case, print a single integer representing the number of chocolate pieces left with you after giving the longest sequence of pieces.
 */
public class XSquareAndChocolateBars {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		char[] b;
		int length, remaining, maxGroups, groups;
		for (int i = 0; i < t; ++i) {
			b = br.readLine().toCharArray();
			length = b.length;
			remaining = length;
			groups = 0;
			maxGroups = 0;
			for (int j = 0; j < length - 2;) {
				if (!(b[j] == b[j + 1] && b[j + 1] == b[j + 2])) {
					++groups;
					if (groups > maxGroups) {
						maxGroups = groups;
					}
					j += 3;
				} else {
					groups = 0;
					++j;
				}
			}
			remaining -= (3 * maxGroups);
			System.out.println(remaining);
		}
	}
}
