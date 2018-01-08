import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*(Correct but inefficient)
 * 
 */
public class UniversityZscaler {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		byte q = Byte.parseByte(st.nextToken());
		int[] arr = new int[n];
		Map<Integer, ArrayList<Integer>> lookup = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list;
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			list = lookup.get(arr[i]);
			if (null != list) {
				list.add(i);
			} else {
				list = new ArrayList<>();
				list.add(i);
				lookup.put(arr[i], list);
			}
		}
		int x, y;
		ArrayList<Integer> list2;
		for (byte i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			list = lookup.get(x);
			list2 = lookup.get(y);
			System.out.println(minDistance(list, list2, n) / 2);
		}
	}

	static int minDistance(ArrayList<Integer> l1, ArrayList<Integer> l2, int students) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < l1.size(); ++i) {
			int one = l1.get(i);
			for (int j = 0; j < l2.size(); ++j) {
				int two = l2.get(j);
				int diff = Math.min(Math.abs(one - two), students - Math.abs(one - two));
				if (diff < min)
					min = diff;
			}
		}

		return min;

	}
}
