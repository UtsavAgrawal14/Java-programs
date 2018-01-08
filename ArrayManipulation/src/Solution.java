import java.util.Scanner;
/*Prints the maximum element in an array of size N after performing M update queries.
 * Each query has 3 integers a, b and k, where a and b denote the starting index and ending index (both inclusive) to perform query on, and k denotes  
 * the value to be added on each element of the array in the range specified by a and b.
 * NOTE: It is assumed that indexes start from 1.
 * 
 *  Input Format:
 *  
 *  1. Size of array, N
 *  2. Number of queries, M
 *  For each query,  
 *  Input a, b and k
 *  
 *  Output Format:
 *  Print a single integer denoting the max value in array after performing M queries. 
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		// This will be the "difference array". The entry arr[i]=k indicates that arr[i]
		// is exactly k units larger than arr[i-1]
		long[] arr = new long[n];
		int a, b;
		long k, max = 0, temp = 0;

		for (int i = 0; i < m; ++i) {
			a = scan.nextInt();
			b = scan.nextInt();
			k = scan.nextInt();
			arr[a - 1] += k;
			if (b < n)
				arr[b] -= k;
		}
		scan.close();
		for (int i = 0; i < n; i++) {
			temp += arr[i];
			if (temp > max)
				max = temp;
		}
		System.out.println(max);
	}
}
