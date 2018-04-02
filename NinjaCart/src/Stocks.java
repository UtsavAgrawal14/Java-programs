import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stocks {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] diff = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			diff[i] = Integer.parseInt(st.nextToken());
		}
		int maxProfit = Integer.MIN_VALUE, sum;
		for (int i = 0; i < n; ++i) {
			sum = 0;
			for (int j = i; j < n; ++j) {
				sum += diff[j];
			}
			if (sum > maxProfit) {
				maxProfit = sum;
			}
		}
		System.out.println(maxProfit);
	}

}
