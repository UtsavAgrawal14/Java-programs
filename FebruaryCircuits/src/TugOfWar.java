import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Player {

	Double dist;
	byte strength;

	public Double getDist() {
		return dist;
	}

	public void setDist(Double dist) {
		this.dist = dist;
	}

	public byte getStrength() {
		return strength;
	}

	public void setStrength(byte strength) {
		this.strength = strength;
	}

}

class DistanceComparator implements Comparator<Player> {
	@Override
	public int compare(Player p1, Player p2) {
		return p1.getDist().compareTo(p2.getDist());
	}
}

public class TugOfWar {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		short n = Short.parseShort(br.readLine());
		Player[] players = new Player[n];
		Player player;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (short i = 0; i < n; ++i) {
			player = new Player();
			player.setDist(Double.parseDouble(st.nextToken()));
			players[i] = player;
		}
		st = new StringTokenizer(br.readLine());
		for (short i = 0; i < n; ++i) {
			players[i].setStrength(Byte.parseByte(st.nextToken()));
		}
		Arrays.sort(players, new DistanceComparator());
		List<Double> solutions = new ArrayList<>();
		for (short i = 0; i < n; ++i) {
			
		}
	}
}
