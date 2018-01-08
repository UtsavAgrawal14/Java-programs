import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NiceQuadrupleV2 {

	private static char[][] matrix;
	private static boolean[][] visited;
	private static int rows;
	private static int cols;
	private static int[] abcd;
	private static int[][] indexes;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());
		matrix = new char[rows][cols];
		visited = new boolean[rows][cols];
		for (int i = 0; i < rows; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cols; ++j) {
				matrix[i][j] = st.nextToken().charAt(0);
			}
		}
		int quads = 0;
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (!visited[i][j]) {
					abcd = new int[4];
					indexes = new int[4][2];
					if(validQuadruple(i,j,1,abcd)) {
						++quads;
						System.out.println("Row: "+i+"\nCol: "+j);
					}
				}
			}
		}
		System.out.println(quads);
	}
	
	private static boolean validQuadruple(int row, int col, int len, int[] abcd) {
		System.out.println("Checking Row: "+row+" Col:"+col);
		visited[row][col] = true;
		++abcd[matrix[row][col] - 97];
		indexes[matrix[row][col] - 97][0] = row;
		indexes[matrix[row][col] - 97][1] = col;
		if(len == 4) {
			int sum = 0;
			for(int n : abcd) {
				if(n > 0)
				++sum;
			}	
			if(sum != 4) {
				--abcd[matrix[row][col] - 97];
				visited[row][col] = false;
				indexes[matrix[row][col] - 97][0] = -1;
				indexes[matrix[row][col] - 97][1] = -1;
				return false;
			}
			for(int i = 0; i < 3; ++i) {
				if(indexes[i][0] == indexes[i+1][0] - 1 && indexes[i][1] == indexes[i+1][1] - 1)
					return false;
			}
			return true;
		}
		boolean r1=false,r2=false,r3=false,r4=false;
		if(row < rows - 1 && !visited[row + 1][col]) {
			r1 = validQuadruple(row + 1, col, len + 1, abcd);	//Down
		}
		if(col > 0 && !visited[row][col - 1]) {
			r2 = validQuadruple(row, col - 1, len + 1, abcd);	//Right
		}
		if(col < cols - 1 && !visited[row][col + 1]) {
			r3 = validQuadruple(row, col + 1, len + 1, abcd);	//Left
		}
		if(row > 0 && !visited[row - 1][col]) {
			r4 = validQuadruple(row - 1, col, len + 1, abcd);	//Up
		}
		if(r1 || r2 || r3 || r4)
			return true;
		visited[row][col] = false;
		--abcd[matrix[row][col] - 97];
		return false;
	}
}
