import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RansomNote {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the magazine string:");
		StringTokenizer str = new StringTokenizer(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		while (str.hasMoreTokens()) {
			String word = str.nextToken();
			Integer freq = map.get(word);
			if (freq != null) {
				++freq;
			}else {
				freq = 1;
			}
			map.put(word, freq);
		}
		System.out.println("Enter ransom note:");
		str = new StringTokenizer(br.readLine());
		while (str.hasMoreTokens()) {
			String word = str.nextToken();
			Integer freq = map.get(word);
			if (freq == null || freq == 0) {
				System.out.println("The given ransom note cannot be formed from the given magazine");
				break;
			}
			--freq;
			map.put(word, freq);
		}
		if(!str.hasMoreTokens()) {
			System.out.println("The given ransom note can be formed from the given magazine");
		}
	}

}
