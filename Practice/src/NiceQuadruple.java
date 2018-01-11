import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NiceQuadruple {

	private static char[][] matrix;
	private static int rows;
	private static int cols;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());
		matrix = new char[rows][cols];
		for(int i = 0; i < rows; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < cols; ++j) {
				matrix[i][j] = st.nextToken().charAt(0);
			}
		}
		int quads = 0;
		for(int i = 0; i < rows - 1; ++i) {
			for(int j = 0; j < cols - 1; ++j) {
				if(isValidPermutation(i,j)) {
					if(isConnected(i,j)) {
						++quads;
						System.out.println("Row: "+i+"\nCol: "+j);
					}
				}
			}
		}
		System.out.println(quads);
	}

	private static boolean isValidPermutation(int row, int col) {
		int[] abcd = new int[4];
		int sum = 0;
		for(int i = 0; i < 2; ++i) {
			for(int j = 0; j < 2; ++j) {
				if(abcd[matrix[row + i][col + j] - 97] == 0) {
					abcd[matrix[row + i][col + j] - 97] = 1;
					++sum;
				}
			}
		}
		if(sum != 4)
			return false;
		return true;
	}
	
	private static boolean isConnected(int row, int col) {
		int[][] indexes = new int[4][2];
		for(int i = 0; i < 2; ++i) {
			for(int j = 0; j < 2; ++j) {
				indexes[matrix[row + i][col + j] - 97][0] = i;
				indexes[matrix[row + i][col + j] - 97][1] = j;
			}
		}
		for(int i = 0; i < 3; ++i) {
			if(indexes[i][0] == indexes[i+1][0] + 1 && indexes[i][1] == indexes[i+1][1] + 1)
				return false;
		}
		return true;
	}
}
