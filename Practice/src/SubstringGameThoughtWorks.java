import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubstringGameThoughtWorks {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int q = Integer.parseInt(br.readLine());
		int diff, initialIndex, endIndex;
		StringTokenizer st = new StringTokenizer(br.readLine());
		;
		long query, size = arr.length, maxQuery = size * (size + 1) / 2;
		for (int i = 0; i < q; ++i) {
			diff = (int) size;
			initialIndex = 0;
			query = Long.parseLong(st.nextToken());
			if (query <= maxQuery) {
				while (query > diff && diff > 0) {
					query -= diff;
					++initialIndex;
					--diff;
				}
				endIndex = initialIndex;
				while (query > 0) {
					++endIndex;
					--query;
				}
				System.out.println(new String(arr).substring(initialIndex, endIndex));
			} else {
				System.out.println(-1);
			}
		}
	}
}
