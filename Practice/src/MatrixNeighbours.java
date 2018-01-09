import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixNeighbours {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter matrix dimensions (m x n):");
		StringTokenizer st = new StringTokenizer(br.readLine());
		byte m = Byte.parseByte(st.nextToken()), n = Byte.parseByte(st.nextToken());
		int[][] mat = new int[m][n];
		System.out.println("Enter " + m + " x " + n + " matrix:");
		for (byte i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			for (byte j = 0; j < n; ++j) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println("Input matrix:");
		for (byte i = 0; i < m; ++i) {
			for (byte j = 0; j < n; ++j) {
				System.out.format("%-5s", mat[i][j]);
			}
			System.out.println();
		}
		System.out.println("Enter co-ordinates (indexes start from 0) of element to find neighbours of:");
		st = new StringTokenizer(br.readLine());
		byte x = Byte.parseByte(st.nextToken()), y = Byte.parseByte(st.nextToken());
		if (x < 0 || y < 0 || x > m || y > n) {
			System.out.println("Invalid coordinates..Terminating program...");
			System.exit(0);
		}
		System.out.println("Neighbours of entered co-ordinates are:");
		for (byte i = -1; i < 2; ++i) {
			for (byte j = -1; j < 2; ++j) {
				if ((i == 0 && j == 0) || i + x >= m || i + x < 0 || j + y >= n || j + y < 0) {
					continue;
				}
				System.out.print(mat[i + x][j + y]+" ");
			}
		}
	}

}
