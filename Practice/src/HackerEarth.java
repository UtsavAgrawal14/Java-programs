import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerEarth {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String string = br.readLine();
		char[] array = string.toCharArray();
		String word = "hackerearth";
		char[] wordarr = word.toCharArray();
		int[] freqString = new int[26];
		int[] freqWord = new int[26];
		for (char c : array)
			++freqString[c - 97];
		for (char c : wordarr)
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
