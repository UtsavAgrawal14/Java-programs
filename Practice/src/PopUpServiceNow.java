import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PopUpServiceNow {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int x, y, l, m, a, b, right;
		for (int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			right = x - a;
			if (b >= m) {
				if (right >= l) {
					System.out.println("bottom-right");
					continue;
				} else {
					System.out.println("bottom-left");
					continue;
				}
			} else {
				if (right >= l) {
					System.out.println("top-right");
					continue;
				} else {
					System.out.println("top-left");
					continue;
				}
			}
		}
	}

}
