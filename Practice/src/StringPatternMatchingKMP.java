import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPatternMatchingKMP {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string to be searched in:");
		String src = br.readLine();
		System.out.println("Enter pattern to be searched in string:");
		String pattern = br.readLine();
		int lenSrc = src.length(),  lenPattern = pattern.length();
		int[] preprocess = new int[lenSrc];
		char[] arrSrc = src.toCharArray(), arrPattern = pattern.toCharArray();
		
	}

}
