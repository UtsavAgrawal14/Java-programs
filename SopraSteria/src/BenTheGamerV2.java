import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BenTheGamerV2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		boolean[] bought = new boolean[m];
		boolean[] lvlClr = new boolean[n];
		String[] levels = new String[n];
		for (int i = 0; i < n; ++i) {
			levels[i] = br.readLine();
		}
		long coins = 0L;
		for (int i = 0; i < n; ++i) {
			int count = findMin(levels, lvlClr, bought, n, m);
			coins += Math.pow(count, 2);
		}
		System.out.println(coins);
	}

	/**
	 * 
	 * @param levels
	 *            An <code>array</code> of <code>String</code> representing weapons
	 *            required at each level.
	 * @param clr
	 *            An <code>array</code> of <code>booleans</code> representing
	 *            cleared levels.
	 * @param bought
	 *            An <code>array</code> of <code>booleans</code> representing bought
	 *            weapons.
	 * @param n
	 *            An <code>integer</code> representing number of levels.
	 * @param m
	 *            An <code>integer</code> representing number of weapons.
	 * 
	 * @return the minimum number of new weapons required at next level.
	 */
	static int findMin(String[] levels, boolean[] clr, boolean[] bought, int n, int m) {
		int minCount = Integer.MAX_VALUE, nxtLvl = -1;
		for (int i = 0; i < n; ++i) {
			int count = 0;
			if (clr[i])
				continue;
			String level = levels[i];
			for (int j = 0; j < m; ++j) {
				if (level.charAt(j) == '1' && !bought[j]) {
					++count;
				}
			}
			if (count < minCount) {
				minCount = count;
				nxtLvl = i;
			}
		}
		System.out.print("Going for level: " + nxtLvl);
		clr[nxtLvl] = true;
		String lvl = levels[nxtLvl];
		for (int i = 0; i < m; ++i) {
			if (lvl.charAt(i) == '1') {
				bought[i] = true;
			}
		}
		System.out.println(", New Weapons required: " + minCount);
		return minCount;
	}
}
