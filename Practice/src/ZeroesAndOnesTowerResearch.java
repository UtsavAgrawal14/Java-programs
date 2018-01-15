import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZeroesAndOnesTowerResearch {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array of ones:");
		int n = Integer.parseInt(br.readLine()), ones = n;
		char[] arr = new char[n];
		System.out.println("Enter number of queries:");
		int q = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < q; ++i) {
			System.out.println("Ones left: " + ones);
			st = new StringTokenizer(br.readLine());
			char param1 = st.nextToken().charAt(0);
			int param2 = Integer.parseInt(st.nextToken());
			if (param1 == '0') {
				if (param2 > 0 && param2 <= n) {
					arr[param2 - 1] = '0';
					--ones;
				} else {
					System.out.println("Invalid index");
				}
			} else if (param1 == '1') {
				if (param2 > ones || param2 < 1) {
					System.out.println("Shortcut! There aren't enough 1's in the array :D");
				} else {
					int j = -1;
					while (param2 > 0 && j < n - 1) {
						if (arr[++j] == '\u0000') {
							--param2;
						}
					}
					if (param2 == 0) {
						System.out.println("Found at index: " + (j + 1));
					} else {
						System.out.println("There aren't enough 1's in the array :D");
					}
				}
			} else {
				System.out.println("Invalid query param1");
			}
		}
	}

}
