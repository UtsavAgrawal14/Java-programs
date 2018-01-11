import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class PokemonAndFood {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer> bag = new ArrayList<>();
		int[] food, pok;
		for (int i = 0; i < t; ++i) {
			int n = Integer.parseInt(br.readLine());
			food = new int[n];
			pok = new int[n];
			bag.clear();
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(br.readLine());
				food[j] = Integer.parseInt(st.nextToken());
				pok[j] = Integer.parseInt(st.nextToken());
				if (food[j] != pok[j]) {
					if ((bag.indexOf(pok[j]) == -1 || bag.indexOf(food[j]) == -1) && j < n - 1) {
						bag.add(food[j]);
					}
				}
			}
			System.out.println(bag.size());
		}
	}
}
