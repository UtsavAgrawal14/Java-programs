import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpecialBinaryCogoport {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte t = Byte.parseByte(br.readLine());
		int n, k, rem, indo1;
		boolean to;
		StringTokenizer st;
		for (byte i = 0; i < t; ++i) {
			indo1 = 0;
			to = true;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if (k < 3) {
				System.out.println("impossible");
				continue;
			}
			rem = n % k;
			if (rem > 0) {
				indo1 = rem;
				to = false;
			}
			int j = 0, l = 0;
			while (j < n) {
				if (l == 0 || (l + 1) == indo1 || (l == k - 1 && to)) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
				++j;
				++l;
				if (j % k == 0) {
					l = 0;
				}
			}
			System.out.println();
		}
	}

}
