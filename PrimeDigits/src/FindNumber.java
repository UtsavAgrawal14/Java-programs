import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Finds and prints a number less than or equal to input number having all prime digits.
 */
public class FindNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number:");
		int num = Integer.parseInt(br.readLine());
		long start = System.nanoTime();
		for (int i = num; i >= 0; i--) {
			if (hasPrimeDigits(i)) {
				System.out.println(i);
				break;
			}
		}
		long end = System.nanoTime();
		System.out.println("Execution time (in ms): " + (double) (end - start) / 1000000 + "\nStart time: " + start
				+ "\nEnd time: " + end);
	}

	static boolean hasPrimeDigits(int num) {
		int digit;
		while (num > 0) {
			digit = num % 10;
			if (digit != 2 && digit != 3 && digit != 5 && digit != 7) {
				return false;
			}
			num /= 10;
		}
		return true;
	}

}
