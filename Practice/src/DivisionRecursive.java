import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisionRecursive {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dividend = Integer.parseInt(br.readLine());
		int divisor = Integer.parseInt(br.readLine());
		int[] res = divide(dividend,divisor);
		System.out.println("Quotient: " + res[0] + " Remainder: " + res[1]);
	}

	private static int[] divide(int dividend, int divisor) {
		if(divisor == 0)
			throw new IllegalArgumentException("Divisor cannot be 0");
		int[] res = {0, dividend};
		if( dividend < divisor)
			return res;
		else {
			int temp = dividend - divisor;
			res = divide(temp, divisor);
			res[0]++;
			return res;
		}
	}
}
