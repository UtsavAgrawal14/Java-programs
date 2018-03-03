import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author Utsav
 *
 *         4 1 3 9 7 => 8
 */
public class BalanceNumbers {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int maxIndex = -1, minIndex = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		long sum = 0, share = 0, steps = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += (long) arr[i];
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		if (min == max) {
			System.out.println(steps);
			System.exit(0);
		}
		share = sum / n;
		int index = maxIndex, num = arr[index], diff;
		do {
			diff = num - (int) share;
			if(diff >= 0) {
				arr[index] -= diff;
				arr[(index + 1) % n] += diff;
				steps += diff;
				index = (index + 1) % n;
				num = arr[index];
			}
		}while(index != maxIndex);
		System.out.println(steps);
	}

}
