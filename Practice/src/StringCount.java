import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/*
 * Prints the number of strings of given length that can be formed using a's, at most one b, and at most two c's.
 * Input Format:
 * 1. Number of test cases.
 * For each test case input length of the string.
 * 
 * Output Format:
 * For each test case, print the number of strings that can be formed under the given constraints.
 */
public class StringCount {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases=0;
		try {
			testCases = Integer.parseInt(br.readLine());
		}catch(NumberFormatException nfe) {
			System.out.println("Empty Line");
			testCases = Integer.parseInt(br.readLine());
		}
		List<BigInteger> lengths = new ArrayList<>();
		for (int i = 0; i < testCases; ++i) {
			try{
				lengths.add(new BigInteger(br.readLine()));
			}catch(NumberFormatException nfe) {
				System.out.println("Empty BigInteger");
				--i;
				continue;
			}
		}
		for(int i = 0; i < testCases; ++i) {
			BigInteger length = lengths.get(i);
			if (length.compareTo(BigInteger.valueOf(2)) >= 0) {
				BigInteger first = BigInteger.ONE;
				BigInteger second = secondTerm(length);
				BigInteger third = thirdTerm(length);
				BigInteger fourth = fourthTerm(length,third);
				BigInteger numberOfStrings = first.add(second).add(third).add(fourth);
				System.out.println(numberOfStrings);
			} else {
				System.out.println("3");
			}
		}
	}

	static BigInteger secondTerm(BigInteger l) {
		return l.multiply(BigInteger.valueOf(2));
	}

	static BigInteger thirdTerm(BigInteger l) {
		return l.multiply(BigInteger.valueOf(3)).multiply((l.subtract(BigInteger.valueOf(1))))
				.divide(BigInteger.valueOf(2));
	}

	static BigInteger fourthTerm(BigInteger l, BigInteger third) {
		return third.multiply((l.subtract(BigInteger.valueOf(2)))).divide(BigInteger.valueOf(3));
	}
}
