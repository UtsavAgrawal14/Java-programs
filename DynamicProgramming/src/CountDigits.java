import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Count the number of different numbers that can be formed using 7 segment display LEDs without repeating any digit within given amount of money and board
 * length. It is given that each  LED costs Rs.7 and number of LEDs required for a forming digits 0 to 9 are {6,2,5,5,4,5,6,3,7,6} respectively.
 * 
 * Input format:
 * 1. Number of test cases, T
 * For each test case:
 * Input L <space> M representing length of board and money.
 * 
 * Output:
 * For each test case, print a single integer representing different numbers that can be formed.
 * 
 * Note: Each digit takes 1 unit length space on the board and board is 2 units wide.
 */
public class CountDigits {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int l, m, led;
		final int[] req = { 2, 3, 4, 5, 5, 5, 6, 6, 6, 7 };
		boolean[] vis = new boolean[10];
		long c = 0;
		StringTokenizer st;
		for (int j = 0; j < t; ++j) {
			for (int i = 0; i < t; ++i) {
				st = new StringTokenizer(br.readLine());
				l = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				led = m / 7;
				count(req, led, l, vis);
			}
			System.out.println(c);
		}
	}

	static long count(int[] req, int led, int len, boolean[] vis) {
		if(len > 0) {
			
		}
		return 0;
	}
}
