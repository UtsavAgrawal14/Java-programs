import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arrays {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max, sum = 0, min = Integer.MAX_VALUE, elem = -1;
		for (int i = 0; i < k; ++i) {
			max = Integer.MIN_VALUE;
			for (int j = 0; j < n; ++j) {
				sum = ((arr[j][0] + i) % k) + ((arr[j][1] + i) % k) + ((arr[j][2] + i) % k);
				if (sum > max) {
					max = sum;
					if(max == 3 * (k - 1)) {
						break;
					}
				}
			}
			if (max < min) {
				min = max;
				if(min == 0) {
					break;
				}
				elem = i;
			}
		}
		System.out.println(min + " " + elem);
	}
}
