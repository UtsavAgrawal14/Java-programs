import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CreditSuisse {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, q;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		final int blockSize = 1000;
		int qt, elem, blocks = (int) Math.ceil((double) n / blockSize);
		int[] first = new int[blocks];
		for (int i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			qt = Integer.parseInt(st.nextToken());
			elem = Integer.parseInt(st.nextToken());
			if (qt == 1) {
				if (first[elem / blockSize] == 0 || first[elem / blockSize] > elem)
					first[elem / blockSize] = elem;
			} else {
				int j;
				for (j = elem / blockSize; j < blocks; ++j) {
					if (first[j] != 0 && elem <= first[j]) {
						System.out.println(first[j]);
						break;
					}
				}
				if (j == blocks)
					System.out.println(-1);
			}
		}
	}
}
