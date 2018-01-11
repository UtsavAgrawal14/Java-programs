import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompositionFunctionSapient {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Long.parseLong(br.readLine());
		}
		int result;
		for (int i = 0; i < n; ++i) {
			result = g(f(i, arr, n), arr, n);
			if (result != -1)
				System.out.print(arr[result] + " ");
			else
				System.out.print(-1 + " ");
		}
	}

	static int f(int x, long[] arr, int size) {
		for (int i = x; i < size; ++i) {
			if (arr[x] < arr[i])
				return i;
		}
		return -1;
	}

	static int g(int x, long[] arr, int size) {
		if (x == -1)
			return -1;
		for (int i = x; i < size; ++i) {
			if (arr[x] > arr[i])
				return i;
		}
		return -1;
	}

}
