import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*(Incorrect output: Calculates the common factors between two numbers and prints 2^commonFactors which works fine till each common factor occurs
 * only once, but becomes incorrect when some factor occurs more than once :/)
 * 
 * Prints the number of common factors between 2 given numbers.
 * Note: The numbers can be VERY large ~10^12.
 */
public class CommonFactors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int cmnfctrs = 0;
		long div = 2;
		int itr = 0;
		while (a >= div && b >= div && Math.abs(a - b) >= div) {
			if (areCoprimes(a, b)) {
				break;
			}
			if (a % div == 0 && b % div == 0) {
				System.out.print(div+" ");
				++cmnfctrs;
				a /= div;
				b /= div;
			} else {
				++div;
			}
			++itr;
			{

			}
		}
		System.out.println("Iterations: "+itr);
		System.out.println("Common factors: " +(long)Math.pow(2, cmnfctrs));
	}

	static boolean areCoprimes(long a, long b) {
		long small = (a <= b) ? a : b;
		long large = a + b - small;
		while (small != 0) {
			long temp = large % small;
			large = small;
			small = temp;
		}
		if (large == 1)
			return true;
		return false;
	}
}
