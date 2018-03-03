import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MaxFreqString {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer maxFreq = Integer.MIN_VALUE, freq = 0;
		String name, maxName = null;
		while (st.hasMoreTokens()) {
			name = st.nextToken();
			freq = map.get(name);
			if (freq == null) {
				map.put(name, 1);
			} else {
				++freq;
				map.put(name, freq);
			}
			if (freq != null && freq > maxFreq) {
				maxFreq = freq;
				maxName = name;
			}
		}
		System.out.println("Max duplicated string: " + maxName + "\nMax Freq: " + maxFreq);
	}

}
