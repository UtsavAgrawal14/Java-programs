
//TODO: Current approach doesn't find the maximum count that can be obtained within threshold, it just finds the first element that matches the criteria and goes deeper from there.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Road {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		byte k = Byte.parseByte(st.nextToken());
		byte[] arr = new byte[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			arr[i] = Byte.parseByte(st.nextToken());
		int count = findVisits(arr, n, k, 0, 1);
		System.out.println(count);
	}

	private static int findVisits(byte[] arr, int size, byte threshold, int src, int target) {

		if (src == size - 1 || target == size || threshold == 0)
			return 1;
		byte diff = (byte) Math.abs(arr[target] - arr[src]);
		if (diff <= threshold)
			return 1 + findVisits(arr, size, (byte) (threshold - diff), target, target + 1);
		else
			return 0 + findVisits(arr, size, threshold, src, target + 1);
	}
}
