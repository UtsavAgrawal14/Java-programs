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
		int i = 0, j = 0, freq = 0;
		long count = 1;
		while (i < lenSrc) {
			if (src.charAt(i) != pattern.charAt(j)) {
				i -= j;
				j = -1;
			}
			++i;
			++j;
			if (j == lenPattern) {
				j = 0;
				++freq;
			}
			++count;
		}
		if (freq > 0) {
			System.out.println("Pattern found " + freq + " times.\nIterations: " + count);
		} else {
			System.out.println("Pattern not found.\nIterations: " + count);
		}
	}
}
