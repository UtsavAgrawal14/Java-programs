import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SingleSwapPalindrome {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte t = Byte.parseByte(br.readLine());
		for (byte i = 0; i < t; ++i) {
			char[] str = br.readLine().toCharArray();
			boolean isPalin = true;
			byte isSwapped = -1;
			int length = str.length, index = -1, j = 0, k = length - 1;
			while (j < Math.ceil((double) length / 2) && k >= length / 2) {
				if (isSwapped != 0) {
					if (str[j] != str[k]) {
						if (isSwapped == 1) {
							isPalin = false;
							break;
						}
						isSwapped = 0;
						isPalin = false;
						index = k;
						--j;
					}
					++j;
					--k;
				} else {
					if (str[j] == str[k]) {
						if (k == length / 2 || str[k] != str[length - 1 - k]) {
							swap(str, k, index);
							isSwapped = 1;
							isPalin = true;
							// j = length - 1 - k;
							// continue;
						}
					}
					--k;
				}
			}
			if (isPalin) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
}
