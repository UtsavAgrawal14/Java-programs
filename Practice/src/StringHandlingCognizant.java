import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringHandlingCognizant {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int ind, ind2;
		char ch;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			ind = Integer.parseInt(st.nextToken());
			ch = st.nextToken().charAt(0);
			arr[ind - 1] = ch;
		}
		n = Integer.parseInt(br.readLine());
		String s = new String(arr);
		System.out.println(s);
		StringBuilder sb0 = new StringBuilder(s), sb;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			ind = Integer.parseInt(st.nextToken());
			ind2 = Integer.parseInt(st.nextToken());
			sb0 = new StringBuilder(sb0.substring(0, ind - 1));
			sb = new StringBuilder(sb0.substring(ind - 1, ind2)).reverse();
			sb0.append(sb.toString());
			if (ind2 < s.length()) {
				sb0.append(s.substring(ind2));
			}
		}
		System.out.println(sb0);
		char[] arr2 = sb0.toString().toCharArray();
		int count = 0;
		for(int i = 0; i < arr2.length; ++i) {
			if(arr[i] == arr2[i]) {
				++count;
			}
		}
		System.out.println(count);
	}

}
