import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * (Incorrect output)
 * Finds the minimum cost of buying items from a shop with the following scenario:
 * There are N shops in a row each having 3 items : shoes, shirt and pants. You cannot buy the same item from two consecutive shops but you have to buy one 
 * item from each shop.
 * 
 * Input Format:
 * 1. Number of test cases, T.
 * For each test case, 
 * Input number of shops, N
 * Input prices of shoes, shirt and pants for each shop ( 3 integers ).
 * 
 * Output Format:
 * For each test case, print the minimum cost of buying items under the given constraints.
 */
public class MinCost {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<t; ++i) {
			int n = Integer.parseInt(br.readLine());
			int[][] prices= new int[n][3];
			for(int j=0 ;j<n;++j) {
				st = new StringTokenizer(br.readLine());
				prices[j][0]= Integer.parseInt(st.nextToken());
				prices[j][1]= Integer.parseInt(st.nextToken());
				prices[j][2]= Integer.parseInt(st.nextToken());
			}
			int minCost=Integer.MAX_VALUE,cost=0;
			int[] indexOfMin= new int[n];
			for(int j=0;j<n;++j) {
				for(int k=0; k<n; ++k) {
					if(k==0) {
						indexOfMin[k]= findMin(prices[k],j,-1);
					}else {
						indexOfMin[k]= findMin(prices[k],-1,indexOfMin[k-1]);
						cost+=prices[k][indexOfMin[k]];
					}
				}
				if(cost<minCost) {
					minCost=cost;
				}
			}
			System.out.println(minCost);
		}
	}
	static int findMin(int[] prices, int min, int exclude) {
		int[] p= prices;
		Arrays.sort(p);
		if(min!=-1) {
			return p[min];
		}
		return 1;
	}
}
