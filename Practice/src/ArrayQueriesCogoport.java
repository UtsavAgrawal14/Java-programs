import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayQueriesCogoport {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int q = Integer.parseInt(br.readLine()), u, l, r, p;
		char type;
		for (int i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken().charAt(0);
			if (type == '1') {
				u = Integer.parseInt(st.nextToken()) - 1;
				p = Integer.parseInt(st.nextToken());
				arr[u] = p;
			} else {
				l = Integer.parseInt(st.nextToken()) - 1;
				r = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				System.out.println(findElem(arr, l, r, p) + 1);
			}
		}
	}

	static int findElem(int[] arr, int l, int r, int p) {
		int k = -2, diff = Integer.MAX_VALUE;
		for (int i = l; i < r; ++i) {
			if (arr[i] > p && arr[i] - p < diff) {
				diff = arr[i] - p;
				k = i;
				if(diff == 1)
				    return k;
			}
		}
		return k;
	}
}
