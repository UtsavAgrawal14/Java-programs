import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabyGin {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 6 integers, each between 0 and 9 (inclusive)");
		byte[] arr = new byte[6], counts = new byte[10];
		boolean isTriplet = false, isRun = false;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; ++i) {
			arr[i] = Byte.parseByte(st.nextToken());
			if (arr[i] > 9 || arr[i] < 0) {
				System.out.println("Invalid input");
				System.exit(1);
			}
			++counts[arr[i]];
			if (!isTriplet) {
				if (counts[arr[i]] > 2) {
					isTriplet = true;
					counts[arr[i]] -= 3;
				}
			} else {
				if (counts[arr[i]] > 2) {
					System.out.println("Two triplets found! Sequence is a baby gin");
					System.exit(0);
				}
			}
		}
		for (int i = 0; i < 8; ++i) {
			if (!isRun) {
				if (counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0) {
					isRun = true;
					--counts[i];
					--counts[i + 1];
					--counts[i + 2];
				}
			} else {
				if (counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0) {
					System.out.println("Two runs found! Sequence is a baby gin");
					System.exit(0);
				} else {
					if (isTriplet) {
						System.out.println("One triplet and one run found! Sequence is a baby gin");
						System.exit(0);
					}
				}
			}
		}
		if (isTriplet) {
			System.out.println("Only one triplet found. Sequence is not a baby gin");
		} else if (isRun) {
			System.out.println("Only one run found. Sequence is not a baby gin");
		} else {
			System.out.println("No runs or triplets found. Sequence is not a baby gin");
		}
	}

}
