import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddStringsCogoport {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int len = arr.length;
		long odds = 0;
		for (int i = len - 1; i >= 0; --i) {
			if (arr[i] == '1') {
				odds += (len - i);
			}
		}
		System.out.println(odds);
	}

}
