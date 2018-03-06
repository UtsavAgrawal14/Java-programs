import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxDifference {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(maxDifference(arr));
	}

	static int maxDifference(int[] a) {
		int maxDiff = Integer.MIN_VALUE, size = a.length;
		if(size == 1)
			return a[size -1];
		int diff = -1;
		for(int i = 1; i < size; ++i) {
			for(int j = 0; j < i; ++j) {
				if(a[j] <= a[i]) {
					diff = a[i] - a[j];
				}
				if(diff > maxDiff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
}
