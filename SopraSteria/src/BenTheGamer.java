import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BenTheGamer {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		boolean[] bought = new boolean[m];
		String[] levels = new String[n];
		for (int i = 0; i < n; ++i) {
			levels[i] = br.readLine();
		}
		List<Integer> counts = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int count = 0;
			for (int j = 0; j < m; ++j) {
				if (levels[i].charAt(j) == '1') {
					++count;
				}
			}
			counts.add(count);
		}
		long coins = 0L;
		for (int i = 0; i < n; ++i) {
			int newWeapons = 0;
			int index = findMin(counts);
			String nextLevel = levels[index];
			for(int j = 0; j < m; ++j) {
				if(nextLevel.charAt(j) == '1' && !bought[j]) {
					bought[j] = true;
					++newWeapons;
				}
			}
			coins += Math.pow(newWeapons, 2);
		}
		System.out.println(coins);
	}
	
	/**
	 * 
	 * @param counts A <code>List</code> of <code>Integers</code> representing number of weapons required at each level.
	 * @return the index of the row requiring minimum weapons after some iterations.
	 */
	static int findMin(List<Integer> counts) {
		int minCount = Integer.MAX_VALUE, count = 0, index = -1;
		Iterator<Integer> iter = counts.iterator();
		for(int i = 0; iter.hasNext(); ++i) {
			count = iter.next();
			if(count < minCount) {
				minCount = count;
				index = i;
			}	
		}
		counts.set(index, Integer.MAX_VALUE);
		return index;
	}

}
