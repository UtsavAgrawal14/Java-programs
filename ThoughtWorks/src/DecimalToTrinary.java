import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DecimalToTrinary {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken()), ones = 0,
				blockSize = (int) Math.ceil(Math.sqrt(n));
		int[] arr = new int[n];
		int[] sum = new int[(int) Math.ceil((double) n / blockSize)];
		boolean dirty = false;
		for (int i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			char type = st.nextToken().charAt(0);
			int x = Integer.parseInt(st.nextToken());
			--x;
			int block = x / blockSize;
			dirty = true;
			if (type == '1') {
				++arr[x];
				++sum[block];
			} else if (type == '2') {
				if (arr[x] > 0)
					--arr[x];
				if (sum[block] > 0) {
					--sum[block];
				}

			} else {
				int y = Integer.parseInt(st.nextToken());
				--y;
				if (dirty) {
					ones = 0;
					int nextBlock = (int) Math.ceil((double) x / blockSize),
							lastBlock = (int) Math.ceil((double) y / blockSize);
					for (int j = x; j < nextBlock * blockSize; ++j) {
						ones += arr[j];
					}
					for (int j = nextBlock; j < lastBlock; ++j) {
						ones += sum[j];
					}
					for (int j = lastBlock * blockSize; j <= y; ++j) {
						ones += arr[j];
					}
					dirty = false;
				}
				System.out.println(ones);
			}
		}
	}
}
