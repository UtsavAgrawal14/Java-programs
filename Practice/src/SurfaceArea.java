import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SurfaceArea {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rows, columns;
		rows = Integer.parseInt(st.nextToken());
		columns = Integer.parseInt(st.nextToken());
		int[][] mat = new int[rows][columns];
		for (int i = 0; i < rows; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < columns; ++j) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println("Surface area: " + findSurfaceArea(mat, rows, columns));
	}

	private static int findSurfaceArea(int[][] mat, int rows, int columns) {
		if (rows * columns == 1)
			return 6;
		return left(mat, rows, columns) + right(mat, rows, columns) + front(mat, rows, columns) + back(mat, rows, columns) + 2 * rows * columns;
	}

	private static int left(int[][] mat, int rows, int columns) {

		int leftSum = 0, diff;
		for (int i = 0; i < rows; ++i) {
			leftSum += mat[i][0];
			for (int j = 1; j < columns; ++j) {
				diff = mat[i][j] - mat[i][j - 1];
				if(diff > 0)
					leftSum += diff;
			}
		}
		return leftSum;
	}

	private static int right(int[][] mat, int rows, int columns) {

		int rightSum = 0, diff;
		for (int i = 0; i < rows; ++i) {
			rightSum += mat[i][columns - 1];
			for (int j = columns - 2; j >= 0; --j) {
				diff = mat[i][j] - mat[i][j + 1];
				if(diff > 0)
					rightSum += diff;
			}
		}
		return rightSum;
	}

	private static int front(int[][] mat, int rows, int columns) {
	
		int frontSum = 0, diff;
		for (int j = 0; j < columns; ++j) {
			frontSum += mat[rows-1][j];
			for (int i = rows - 2; i >= 0; --i) {
				diff = mat[i][j] - mat[i + 1][j];
				if(diff > 0)
					frontSum += diff;
			}
		}
		return frontSum;
	}

	private static int back(int[][] mat, int rows, int columns) {
		int backSum = 0, diff;
		for (int j = 0; j < columns; ++j) {
			backSum += mat[0][j];
			for (int i = 1; i < rows; ++i) {
				diff = mat[i][j] - mat[i - 1][j];
				if(diff > 0)
					backSum += diff;
			}
		}
		return backSum;
	}
}
