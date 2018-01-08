import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] prepareLookup(int[] arr, int size) {
		int[][] maxLookup = new int[size][size];
		for (int i = 0; i < size; ++i) {
			maxLookup[i][i] = arr[i];
		}
		for (int i = 0; i < size; ++i) {
			for (int j = i + 1; j < size; ++j) {
				if (maxLookup[i][j - 1] <= arr[j])
					maxLookup[i][j] = arr[j];
				else
					maxLookup[i][j] = maxLookup[i][j - 1];
			}
		}
		/*
		 * for(int i=0; i<size; ++i){ for(int j=0; j<size; ++j){
		 * System.out.print(maxLookup[i][j]+"\t"); } System.out.println(); }
		 */
		return maxLookup;
	}

	public static int min(int[] arr, int size) {
		int minElem = arr[0];
		for (int i = 0; i < size; ++i) {
			if (arr[i] < minElem) {
				minElem = arr[i];
			}
		}
		return minElem;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int i = -1;
		st = new StringTokenizer(br.readLine());
		while (++i < n) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = -1;
		int[] minFrom = new int[n];
		int[][] maxLookup;
		maxLookup = prepareLookup(arr, n);
		while (++k < q) {
			int d = Integer.parseInt(br.readLine());
			int j;
			for (j = 0; j + d - 1 < n; ++j) {
				minFrom[j] = maxLookup[j][j + d - 1];
			}
			System.out.println(min(minFrom, j));
		}
	}
}