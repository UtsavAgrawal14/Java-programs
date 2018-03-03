import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excel {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter cell number:");
		int num = Integer.parseInt(br.readLine());
		if (num <= 0) {
			System.out.println("Invalid number");
			System.exit(0);
		}
		--num;
		int row = num / 702 + 1;
		int col = num % 702;
		if (col < 26) {
			System.out.println("Row: " + row + "\nCol: " + (char) ('A' + col));
			System.exit(0);
		}
		System.out.print("Row: " + row + "\nCol: " + (char) ('A' - 1 + col / 26));
		System.out.println((char) ('A' + (col - col / 26 * 26)));
	}

}
