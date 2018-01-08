import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CandidateCode {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int output = 0;
		long ip1 = Long.parseLong(in.nextLine().trim());
		int ip2_size = 0;
		ip2_size = Integer.parseInt(in.nextLine().trim());
		int[] ip2 = new int[ip2_size];
		int ip2_item;
		for (int ip2_i = 0; ip2_i < ip2_size; ip2_i++) {
			ip2_item = Integer.parseInt(in.nextLine().trim());
			ip2[ip2_i] = ip2_item;
		}
		in.close();
		output = fnumber(ip1, ip2);
		System.out.println(String.valueOf(output));
	}

	public static int fnumber(long input1, int[] input2) {
		// Write code here
		int input2Size = input2.length;
		Arrays.sort(input2);
		long[] powerLookup = findPower(input2, input2Size);
		for (int i = 0; i < input2Size; ++i) {
			if (powerLookup[input2[i] - 1] > input1) {
				return input2[i];
			}
		}
		return -1;
	}

	public static long[] findPower(int[] fnumbers, int size) {
		long[] powerLookup = new long[size];
		powerLookup[0] = fnumbers[size - 1];
		for (int i = 1; i < size; ++i) {
			powerLookup[i] = powerLookup[i - 1] + fnumbers[size - i - 1];
		}
		return powerLookup;
	}

}
