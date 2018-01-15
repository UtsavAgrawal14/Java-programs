import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPatternMatchingKMP {

	private static int counter = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string to be searched in:");
		String src = br.readLine();
		System.out.println("Enter pattern to be searched in string:");
		String pattern = br.readLine();
		int[] preprocess = preprocessPattern(pattern);
		int count = searchPatternKMP(src, pattern, preprocess);
		if (count == 0) {
			System.out.println("Pattern not found.\nIterations performed: " + counter);
		} else {
			System.out.println("Pattern occured " + count + " times.\nIterations performed: " + counter);
		}
	}

	private static int[] preprocessPattern(String pattern) {

		int i = 1, len = 0, lenPattern = pattern.length();
		int[] preprocess = new int[lenPattern];
		preprocess[0] = 0;
		while (i < lenPattern) {
			++counter;
			if (pattern.charAt(i) == pattern.charAt(len)) {
				++len;
				preprocess[i] = len;
				++i;
			} else {

				if (len != 0) {
					len = preprocess[len - 1];
				} else {
					preprocess[i] = 0;
					++i;
				}
			}
		}
		return preprocess;
	}

	private static int searchPatternKMP(String src, String pattern, int[] preprocess) {
		int count = 0, i = 0, j = 0, srcLen = src.length(), patLen = pattern.length();
		while (i < srcLen) {
			++counter;
			if (src.charAt(i) == pattern.charAt(j)) {
				++i;
				++j;
			}
			if (j == patLen) {
				++count;
				j = preprocess[j - 1];
			} else if (i < srcLen && pattern.charAt(j) != src.charAt(i)) {

				if (j != 0) {
					j = preprocess[j - 1];
				} else {
					++i;
				}
			}
		}
		return count;
	}
}
