import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ZeroesAndOnesV2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array of ones:");
		int n = Integer.parseInt(br.readLine()), ones = n;
		char[] arr = new char[n];
		Set<Integer> zeroesIndex = new TreeSet<>();
		System.out.println("Enter number of queries:");
		int q = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < q; ++i) {
			System.out.println("Ones left: " + ones);
			st = new StringTokenizer(br.readLine());
			char param1 = st.nextToken().charAt(0);
			int param2 = Integer.parseInt(st.nextToken());
			if (param1 == '0') {
				if (param2 > 0 && param2 <= n) {
					arr[param2 - 1] = '0';
					zeroesIndex.add(param2);
					--ones;
				} else {
					System.out.println("Invalid index");
				}
			} else if (param1 == '1') {
				if (param2 > ones || param2 < 1) {
					System.out.println("Shortcut! There aren't enough 1's in the array :D");
				} else {
					int j = param2;
					Iterator<Integer> iter = zeroesIndex.iterator();
					while(iter.hasNext()) {
						if(iter.next() <= param2) {
							++j;
						}else {
							break;
						}
					}
					System.out.println("Found at index: " + j);
				}
			} else {
				System.out.println("Invalid query param1");
			}
		}
	}

}
