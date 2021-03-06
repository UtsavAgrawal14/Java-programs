import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[] prepareLookup(int[] arr, int size, int blockSize) {
		int blockIndex = 0;
		int lookupSize = size / blockSize;
		int[] maxLookup = new int[lookupSize];
		for (int i = 0; blockIndex < lookupSize; i = i + blockSize) {
			if (i + blockSize > size)
				maxLookup[blockIndex] = max(i, size, arr);
			else
				maxLookup[blockIndex] = max(i, i + blockSize, arr);
			++blockIndex;
		}
		return maxLookup;
	}

	public static int max(int startIndex, int endIndex, int[] arr) {
		int maxElem = 0;
		maxElem = arr[startIndex];
		for (int i = startIndex; i < endIndex; ++i) {
			if (arr[i] > maxElem)
				maxElem = arr[i];
		}
		return maxElem;
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

	public static int findMax(int low, int high, int[] arr, int[] lookup, int blockSize) {
		int max = arr[low];
		while (low < high && (low) % blockSize != 0 && low != 0) {
			// traversing first block in range
			if (max < arr[low]) {
				max = arr[low];
			}
			low++;
		}
		while (low + blockSize <= high) {
			// traversing completely overlapped blocks in range
			if (max < lookup[low / blockSize]) {
				max = lookup[low / blockSize];
			}
			low += blockSize;
		}
		while (low <= high) {
			// traversing last block in range
			if (max < arr[low]) {
				max = arr[low];
			}

			low++;
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		long startTime = System.nanoTime();
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
		int blockSize = (int) Math.floor(Math.sqrt(n));
		int[] maxLookup = prepareLookup(arr, n, blockSize);
		while (++k < q) {
			int d = Integer.parseInt(br.readLine());
			int j;
			for (j = 0; j + d - 1 < n; ++j) {
				minFrom[j] = findMax(j, j + d - 1, arr, maxLookup, blockSize);
			}
			System.out.println(min(minFrom, j));
		}
		long endTime = System.nanoTime();
		System.out.println("Execution time (ms):" + (endTime - startTime) / 1000000);
	}
}