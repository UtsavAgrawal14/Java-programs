import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class SpecialArraySapient {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		List<Integer> prime = new ArrayList<>();
		List<Integer> nonPrime = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (isPrime(arr[i])) {
				prime.add(arr[i]);
			} else {
				nonPrime.add(arr[i]);
			}
		}
		Collections.sort(prime);
		Collections.sort(nonPrime, Collections.reverseOrder());
		Iterator<Integer> iter = prime.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		iter = nonPrime.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

	static boolean isPrime(long num) {
		if (num == 2)
			return true;
		if (num % 2 == 0 || num == 1)
			return false;
		for (long i = 3; i <= Math.sqrt(num); i += 2)
			if (num % i == 0)
				return false;
		return true;
	}
}
