import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Ammo{
	
	private int weight;
	private int value;
	private float ratioVW;
	
	public float getRatioVW() {
		return ratioVW;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setRatio() {
		ratioVW = (float)value/weight;
	}
}

public class Knapsack {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n, w;
		StringTokenizer st;
		Ammo ammo;
		for (int i = 0; i < t; ++i) {
			n = Integer.parseInt(br.readLine());
			List<Ammo> list = new ArrayList<>();
			w = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				ammo = new Ammo();
				ammo.setWeight(Integer.parseInt(st.nextToken()));
				list.add(ammo);
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				list.get(j).setValue(Integer.parseInt(st.nextToken()));
				list.get(j).setRatio();
			}
			sortAmmoByRatioDesc(list);
			int j = -1, maxValue = 0;
			Ammo temp;
			while (w > 0) {
				temp = list.get(++j);
				if (temp.getWeight() <= w) {
					maxValue += temp.getValue();
					w -= temp.getWeight();
				}
				if (j == n - 1)
					break;
			}
			System.out.println(maxValue);
		}
	}
	
	private static void sortAmmoByRatioDesc(List<Ammo> l) {
		Ammo temp, tempj, tempj2;
		int size = l.size();
		for (int i = 0; i < size - 1; ++i) {
			for (int j = 0; j < size - 1 - i; ++j ) {
				tempj = l.get(j);
				tempj2 = l.get(j + 1); 
				if (tempj.getRatioVW() < tempj2.getRatioVW()) {
					temp = tempj;
					l.set(j,tempj2);
					l.set(j + 1, temp);
				}
			}
		}
	}

}
