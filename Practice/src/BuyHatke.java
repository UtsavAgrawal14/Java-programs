import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyHatke {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int n, q, index;
		int[] arr;
		final boolean beg = true;
		for (int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < q; ++j) {
				index = Integer.parseInt(br.readLine());
				if (index == 1 || index == n)
					System.out.println(0);
				else {
					System.out.println(
							(long) findMax(arr, n, index - 1, beg) * arr[index - 1] * findMax(arr, n, index - 1, !beg));
				}
			}
		}
	}

	private static long findMax(int[] arr, int size, int index, boolean beg) {
		if (index == 1 || index == size)
			return 0;
		int max = Integer.MIN_VALUE, begIndex = 0, endIndex = index;
		if (beg == false) {
			begIndex = index + 1;
			endIndex = size;
		}
		for (int i = begIndex; i < endIndex; ++i) {
			if (arr[i] > max && arr[i] <= arr[index])
				max = arr[i];
		}
		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}
}
