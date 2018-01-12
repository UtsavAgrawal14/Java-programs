import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatternMatchingBrute {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string to be searched in:");
		String src = br.readLine();
		System.out.println("Enter pattern to be searched in string:");
		String pattern = br.readLine();
		int lenSrc = src.length(), lenPattern = pattern.length();
		char[] arrSrc = src.toCharArray(), arrPattern = pattern.toCharArray();
		int i = 0, j = 0;
		long count = 1;
		while (i < lenSrc && j < lenPattern) {
			if (arrSrc[i] != arrPattern[j]) {
				i -= j;
				j = -1;
				System.out.println(count);
			}
			++i;
			++j;
			++count;
		}
		if (j == lenPattern) {
			System.out.println("Pattern found at index: " + (i - j));
		} else {
			System.out.println("Pattern not found.");
		}
		System.out.println("\nLength of string: " + lenSrc + "\nLength of pattern: " + lenPattern
				+ "\nIterations performed: " + count);
	}
}
