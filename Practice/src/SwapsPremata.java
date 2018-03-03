import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SwapsPremata {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), count = 0, streak = 0;
		int[] arr = new int[n];
		List<Integer> cavities = new ArrayList<>();
		List<Integer> indices = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] < k) {
				if (streak == 0) {
					indices.add(i);
				}
				++streak;
			} else {
				++count;
				if (streak > 0) {
					cavities.add(streak);
				}
				streak = 0;
			}
		}
		if (streak > 0) {
			cavities.add(streak);
		}
	}
}
