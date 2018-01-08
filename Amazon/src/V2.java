import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*Prints the largest number in given string that does not contain the digit 9*/

public class V2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		List<String> lines = new ArrayList<>();
		for (int i = 0; i < t; ++i) {
			lines.add(br.readLine());
		}
		for (String line : lines) {
			char[] arr = line.toCharArray();
			int left = -1, right = -1;
			boolean first = true;
			BigInteger max = new BigInteger("-1");
			for (int i = 0; i < arr.length; ++i) {
				if (Character.isDigit(arr[i])) {
					if (first) {
						left = i;
						first = false;
					}
					if (i == arr.length - 1) {
						right = i + 1;
					}
				} else {
					if (left >= 0) {
						right = i;
					}
				}
				if (right >= 0) {
					String substr = line.substring(left, right);
					if (substr.indexOf('9') == -1) {
						BigInteger number = new BigInteger(substr);
						if (number.compareTo(max) > 0 || max == null) {
							max = number;
						}
					}
					// Reset for next number.
					right = -1;
					left = -1;
					first = true;
				}
			}
			System.out.println(max);
		}
	}
}
