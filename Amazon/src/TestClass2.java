import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Finds the number of different countries people sitting in a row are from. People from the same country always sit together. Each of them tells you how many
 * people belong to his/her country (which can be wrong too).
 * Input format:
 * 1. Number of test cases.
 * For each test case
 * 1. Number of people in the row, N
 * 2. Answers of N people..(Q.How many people in the row belong to their country?)
 * 
 * Output format:
 * For each test case, print the number of different countries people are from or Invalid data if the answers provided are incorrect.
 */
class TestClass2 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		outer: for (int i = 0; i < t; ++i) {
			int n = Integer.parseInt(br.readLine());
			int[] ans = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				ans[j] = Integer.parseInt(st.nextToken());
			}
			int count = 0, countries = 0;
			int temp = ans[0];
			for (int j = 0; j < n; ++j) {
				if (ans[j] == temp) {
					++count;
					if (count == temp) {
						++countries;
						if (j < (n - 1)) {
							temp = ans[j + 1];
							count = 0;
						}
					} else {
						if (j == n - 1 || ans[j + 1] != temp) {
							System.out.println("Invalid Data");
							continue outer;
						}
					}
				} else {
					System.out.println("Invalid Data");
					continue outer;
				}
			}
			System.out.println(countries);
		}
	}
}
