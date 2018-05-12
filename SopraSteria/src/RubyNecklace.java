import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RubyNecklace {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] counts = new int[4];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; ++i) {
			counts[i] = Integer.parseInt(br.readLine());
			sb.append((counts[i] != 0) ? '1' : '0');
		}
		int pathsVal = Integer.parseInt(new String(sb), 2), maxLength = 0;
		maxLength = initialCases(counts, pathsVal);
		System.out.println(maxLength);
	}

	static int initialCases(int[] counts, int pathsVal) {
		int maxLength = 0;
		switch (pathsVal) {
		case 0:
			maxLength = 0; // No rubies
			break;
		case 1:
			maxLength = counts[3]; // Only green rubies
			break;
		case 2:
		case 4:
			maxLength = 1; // Only red or only yellow
			break;
		case 8:
			maxLength = counts[0]; // Only blue
			break;
		case 3:
		case 5:
			maxLength = (counts[3] + 1); // Green with red or yellow
			break;
		case 6:
			maxLength = (counts[1] > counts[2]) ? 2 * counts[2] + 1
					: (counts[1] == counts[2]) ? 2 * counts[2] : 2 * counts[1]; // Yellow and red
			break;
		case 7:
			maxLength = (counts[1] - 1 > counts[2]) ? 2 * counts[2] + counts[3] + 2
					: (counts[1] - 1 == counts[2]) ? 2 * counts[2] + 1 + counts[3] : 2 * counts[1] + counts[3]; // Red,
			// yellow
			// and
			// green
			break;
		case 9:
		case 10:
		case 11:
			maxLength = counts[0]; // (Blue and yellow) or (Blue, yellow and green)
			break;
		case 12:
			maxLength = counts[0] + 1; // Blue and red.
			break;
		case 13:
			maxLength = counts[0] + 1 + counts[3]; // Blue, red and green
			break;
		case 14:
			maxLength = counts[0] + initialCases(counts, 6);
			break;
		case 15:
			maxLength = counts[0] + initialCases(counts, 7);
		}
		return maxLength;
	}
}
