import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingSort {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of elements:");
		int n = Integer.parseInt(br.readLine()), max = Integer.MIN_VALUE;
		int[] arr = new int[n];
		System.out.println("Enter " + n + " elements:");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int[] counts = new int[max + 1];
		for (int i = 0; i < n; ++i) {
			++counts[arr[i]];
		}
		for (int i = 1; i <= max; ++i) {
			counts[i] += counts[i - 1];
		}
		int[] temp = new int[n];
		for (int i = n - 1; i >= 0; --i) {
			temp[counts[arr[i]] - 1] = arr[i];
			--counts[arr[i]];	
		}
		System.out.println("Sorted array:");
		for(int i = 0; i < n; ++i) {
			System.out.print(temp[i]+" ");
		}
	}

}
