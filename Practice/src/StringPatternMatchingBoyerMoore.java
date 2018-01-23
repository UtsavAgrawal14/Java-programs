import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/**
 * 
 * @author Utsav
 *INCOMPLETE
 */
public class StringPatternMatchingBoyerMoore {

	private static int counter = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string to be searched in:");
		String src = br.readLine();
		System.out.println("Enter pattern to be searched in string:");
		String pattern = br.readLine();
		HashMap<Character, Integer> skip = preprocessPattern(pattern);
		int count = searchPatternBoyerMoore(src, pattern, skip);
		if (count == 0) {
			System.out.println("Pattern not found.\nIterations performed: " + counter);
		} else {
			System.out.println("Pattern occured " + count + " times.\nIterations performed: " + counter);
		}
	}

	private static HashMap<Character, Integer> preprocessPattern(String pattern) {

		int i = -1, unique = 1, lenPattern = pattern.length();
		char c;
		HashMap<Character, Integer> skip = new HashMap<>();
		while (++i < lenPattern) {
			++counter;
			c = pattern.charAt(i);
			if (skip.get(c) == null) {
				skip.put(c, unique++);
			}
		}
		return skip;
	}

	private static int searchPatternBoyerMoore(String src, String pattern, HashMap<Character, Integer> preprocess) {
		int count = 0, srcLen = src.length(), patLen = pattern.length(), i = patLen - 1, j = patLen - 1;
		Integer skip;
		char cs, cp; 
		while (i < srcLen) {
			cs = src.charAt(i);
			cp = pattern.charAt(j);
			if(cs == cp) {
				--i;
				--j;
				if(j == -1) {
					++count;
					i += (count * patLen);
					j = patLen - 1;
				}
			}else {
				skip = preprocess.get(cs);
				if(skip!= null) {
					i += skip; 
				}else {
					i += patLen;
				}
				j = patLen - 1;
			}
		}
		return count;
	}

}
