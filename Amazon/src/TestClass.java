import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*(Incorrect Output)
 * You are given a piece of wood of length L having N mark points on it for cutting (point 1 is at l=0 and point N at l=L, thus there are N-2 points in between the wood and 2 on ends)
 * The cost of cutting wood at a specific mark point depends on the length of wood remaining on the left and right side after cutting and is calculated as X*(length of left part)+Y*(length of right part).
 * You need to print the minimum amount of money that will be spent on cutting the wood at all the N-2 mark points.
 * Input Format
 * 1. Number of test cases, T.
 * For each test case
 * Input X (multiplier for left side) <space> Y (multiplier for right side)
 * Total Number of mark points N
 * N values of mark points i.e distance of each mark point from the left end of wood.
 * 
 * Output Format:
 * For each test case print the minimum amount of money required to cut the wood.
 */
public class TestClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int j = 0; j < t; ++j) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine());
			int[] points = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i) {
				points[i] = Integer.parseInt(st.nextToken());
			}
			int leftEnd = 1, rightEnd = points[n - 1];
			int cost = 0;
			if (left >= right) {
				for (int i = 1; i < (n - 1); ++i) {
					cost += left * (points[i] - leftEnd) + right * (rightEnd - points[i]);
					leftEnd = points[i];
				}
			} else {
				for (int i = (n - 2); i > 0; --i) {
					cost += left * (points[i] - leftEnd) + right * (rightEnd - points[i]);
					rightEnd = points[i];
				}
			}
			System.out.println(cost);
		}
	}

}
