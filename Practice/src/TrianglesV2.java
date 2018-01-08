import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TrianglesV2 {

	private static final int div = (int) 1e9 + 7; // 10 to the power 9 plus 7.
	private static List<Integer> lookup = new ArrayList<>();
	private static int size = 1;
	private static List<Integer> lookupExp = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine()), move;
		lookup.add(5);
		lookupExp.add(3);
		long ans;
		for (int i = 0; i < q; ++i) {
			move = Integer.parseInt(br.readLine());
			if (size >= move)
				System.out.println(lookup.get(move - 1) % div);
			else {
				for (int j = size; j < move; ++j) {
					ans = (lookup.get(j - 1) + (4L * lookupExp.get(j - 1)) % div) % div;
					lookup.add((int) ans);
					if (j < 18)
						lookupExp.add((int) Math.pow(3, j + 1));
					else
						lookupExp.add(threeToThePowerExpModDiv(j + 1));
					++size;
				}
				System.out.println(lookup.get(move - 1) % div);
			}
		}
	}

	private static int threeToThePowerExpModDiv(int exp) {

		long result = lookupExp.get(exp - 2);
		result = (result * 3) % div;
		return (int) result;
	}

}
