import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerEarth {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		String word = "hackerearth";
		int[] freqString = new int[26];
		int[] freqWord = new int[26];
		for (char c : string.toCharArray())
			++freqString[c - 97];
		for (char c : word.toCharArray())
			++freqWord[c - 97];
		int minRatio = Integer.MAX_VALUE;
		for(int i = 0; i < 26; ++i) {
			if(freqString[i] != 0 && freqString[i] / freqWord[i] < minRatio ) {
				minRatio = freqString[i] / freqWord[i];
			}
		}
		System.out.println(minRatio);
	}
}
