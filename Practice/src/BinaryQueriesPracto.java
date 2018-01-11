import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryQueriesPracto {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[] arr = br.readLine().toCharArray();
		byte q1;
		int q2, maxLength = 0, count = 0;
		for (int i = 0; i < n; ++i) {
			if (arr[i] == '0') {
				if (count > maxLength) {
					maxLength = count;
				}
				count = 0;
			} else {
				++count;
			}
		}
		if (count > maxLength) {
			maxLength = count;
		}
		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			q1 = Byte.parseByte(st.nextToken());
			if (q1 == 1) {
				System.out.println(maxLength);
			} else {
				q2 = Integer.parseInt(st.nextToken());
				arr[q2 - 1] = '1';
				count = 1;
				int index = q2 - 1;
				while (index > 0 && arr[--index] == '1') {
					++count;
				}
				index = q2 - 1;
				while (index < n - 1 && arr[++index] == '1') {
					++count;
				}
				if (count > maxLength)
					maxLength = count;
			}
		}
	}
}
