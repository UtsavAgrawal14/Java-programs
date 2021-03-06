import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixTraversal {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter dimensions of matrix (m and n):");
		StringTokenizer st = new StringTokenizer(br.readLine());
		byte m = Byte.parseByte(st.nextToken()), n = Byte.parseByte(st.nextToken());
		byte[][] mat = new byte[m][n];
		System.out.println("Enter " + m + " X " + n + " matrix :");
		for (byte i = 0; i < m; ++i) {
			System.out.println("Row " + (i + 1) + ": ");
			st = new StringTokenizer(br.readLine());
			for (byte j = 0; j < n; ++j) {
				mat[i][j] = Byte.parseByte(st.nextToken());
			}
		}
		System.out.println("Input matrix:");
		for (byte[] row : mat) {
			for (byte elem : row) {
				System.out.format("%-5s", elem);
			}
			System.out.println();
		}
		
		System.out.println("\nRow major traversal:"); printRowMajor(mat, m, n);
		System.out.println("\nColumn major traversal:"); printColumnMajor(mat, m, n);
		System.out.println("\nZig-zag traversal:"); printZigZag(mat, m, n);
		System.out.println("\nSpiral traversal");
		printSpiral(mat, m, n, (byte) 0, (byte) 0);
	}

	static void printRowMajor(byte[][] mat, byte m, byte n) {

		for (byte i = 0; i < m; ++i) {
			for (byte j = 0; j < n; ++j) {
				System.out.format("%-5s", mat[i][j]);
			}
			System.out.println();
		}
	}

	static void printColumnMajor(byte[][] mat, byte m, byte n) {

		for (byte j = 0; j < n; ++j) {
			for (byte i = 0; i < m; ++i) {
				System.out.format("%-5s", mat[i][j]);
			}
			System.out.println();
		}
	}

	static void printZigZag(byte[][] mat, byte m, byte n) {

		for (byte i = 0; i < m; ++i) {
			for (byte j = 0; j < n; ++j) {
				System.out.format("%-5s", mat[i][j + (n - 1 - 2 * j) * (i % 2)]);
			}
			System.out.println();
		}
	}

	static void printSpiral(byte[][] mat, byte m, byte n, byte lr, byte lc) {

		int count = 0;
		while (lr <= m / 2 && lc <= n / 2) {
			for (int i = lc; i < n; ++i, ++count) {
				checkRow(count, n);
				System.out.format("%-5s", mat[lr][i]);
			}
			++lr;
			for (int i = lr; i < m; ++i, ++count) {
				System.out.format("%-5s", mat[i][n - 1]);
			}
			--n;
			for (int i = n - 1; i >= lc; --i, ++count) {
				System.out.format("%-5s", mat[m - 1][i]);
			}
			--m;
			for (int i = m - 1; i >= lr; --i, ++count) {
				System.out.format("%-5s", mat[i][lc]);
			}
			++lc;
		}
	}

	static void checkRow(int count, int cols) {
		if (count % cols == 0) {
			System.out.println();
		}
	}
}
