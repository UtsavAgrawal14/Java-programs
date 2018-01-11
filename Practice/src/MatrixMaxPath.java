import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixMaxPath {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] mat = new int[n][m];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(findBestPath(mat,n,m,0,0));
	}
	
	private static int findBestPath(int[][] mat, int rows, int cols, int rpos, int cpos) {
		
		if(rpos == rows - 1 || cpos == cols - 1 || rows * cols == 1)
			return mat[rpos][cpos];
		int sum = 0, maxSum = Integer.MIN_VALUE;
		if(cpos > 0)
			sum += findBestPath(mat, rows, cols, rpos, cpos - 1);
		if(rpos < rows - 1)
			sum += findBestPath(mat, rows, cols, rpos + 1, cpos);
		if(cpos < cols - 1)
			sum += findBestPath(mat, rows, cols, rpos, cpos + 1);
		if(sum > maxSum)
			maxSum = sum;
		return maxSum;
	}
}
