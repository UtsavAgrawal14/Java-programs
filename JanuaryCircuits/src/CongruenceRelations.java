import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CongruenceRelations {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		long count = 0, num;
		for (int rem = 0; rem < k; ++rem) { // Remainder
			num = (n / k);
			if (rem > 0 && n - num * k >= rem) {
				++num;
			}
			count += num * (num - 1) / 2;
		}
		System.out.println(count);
	}

}
