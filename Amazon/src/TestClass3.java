import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/* (Incorrect output)
 * Finds the max value of k (where k is the number of elements chosen from a set) for which the diff value of the set is less than a given integer s
 * Diff Value of a set : Maximum possible difference between any two elements of the set. 
 * IMPORTANT: If K elements are chosen from the set then each of the chosen element gets multiplied by k.  
 * 
 * Input format:
 * 1. Number of test cases, T
 * for each test case :
 * Number of elements in the set, N <space> An integer s
 * Elements of the set(Total N elements)
 * 
 *  Output format:
 *  For each test case print the largest value of k for which diff value of set is less than s.
 */
public class TestClass3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[][] ans = new long[t][2];
		StringTokenizer st;
		for (int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			long s=Long.parseLong(st.nextToken());
			int[] arr = new int[n];
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n;++j) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for(int j=n; j>0;--j) {
				if( (long)(j*(arr[j-1]-arr[0]))<=s) {
					ans[i][0]=j;
					ans[i][1]=(long)(j*(arr[j-1]-arr[0]));
					break;
				}
			}
		}
		for(int i = 0; i < t; ++i) {
			System.out.println(ans[i][0]+" "+ans[i][1]);
		}
	}

}
