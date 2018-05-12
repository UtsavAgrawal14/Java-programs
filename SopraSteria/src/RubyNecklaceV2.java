import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RubyNecklaceV2 {

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
			maxLength = (counts[1] > counts[2]) ? 2 * counts[2] + counts[3] + 1 : 2 * (counts[1] - 1) + 1 + counts[3]; // Red,
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
			maxLength = case15(counts, pathsVal);
		}
		return maxLength;
	}

	/*static int case14(int[] counts, int pathsVal) {
		int index = findMin(counts), minCount = counts[index];
		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] > 0)
				counts[i] -= minCount;
		}
		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] == 0)
				pathsVal -= Math.pow(2, 3 - i);
		}
		return 3 * minCount + initialCases(counts, pathsVal);
	}*/

	static int case15(int[] counts, int pathsVal) {
		int index = findMin(counts), minCount = counts[index];
		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] > 0)
				counts[i] -= minCount;
		}
		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] == 0)
				pathsVal -= Math.pow(2, 3 - i);
		}
		return 4 * minCount + initialCases(counts, pathsVal);
	}

	static int findMin(int[] counts) {
		int min = Integer.MAX_VALUE, minIndex = 0;
		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] < min && counts[i] > 0) {
				min = counts[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
