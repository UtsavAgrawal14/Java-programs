import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MaxFreqString {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> names = new ArrayList<>();
		List<String> unique = new ArrayList<>();
		List<Integer> fr = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxFreq = Integer.MIN_VALUE, freq = 0, index;
		String name, maxName = null;
		while (st.hasMoreTokens()) {
			name = st.nextToken();
			if (!unique.contains(name)) {
				unique.add(name);
				freq = 1;
				fr.add(freq);
			} else {
				index = unique.indexOf(name);
				freq = fr.get(index);
				++freq;
				fr.set(index, freq);
			}
			if (freq > maxFreq) {
				maxFreq = freq;
				maxName = name;
			}
			names.add(name);
		}
		System.out.println("Max duplicated string: " + maxName + "\nMax Freq: " + maxFreq);
	}

}
