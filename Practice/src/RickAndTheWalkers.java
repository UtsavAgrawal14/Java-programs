import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RickAndTheWalkers {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] walkers;
		boolean isRickDead;
		int walkersKilled;
		for (int i = 0; i < t; ++i) {
			int n = Integer.parseInt(br.readLine());
			walkers = new int[n];
			isRickDead = false;
			walkersKilled = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				walkers[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(walkers);
			int j = 0;
			int time = 0;
			while (!isRickDead && j < n) {
				if (walkers[j] - time == 0) {
					isRickDead = true;
				} else {
					++walkersKilled;
				}
				++time;
				++j;
				if (walkersKilled % 6 == 0) {
					++time;
				}
			}
			if (isRickDead) {
				System.out.println("Goodbye Rick\n" + walkersKilled);
			} else {
				System.out.println("Rick now go and save Carl and Judas");
			}
		}
	}

}
