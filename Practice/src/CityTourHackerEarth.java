import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

//TODO 2. multiple cities can have the same type..need to visit the closest city of given type in given direction.
public class CityTourHackerEarth {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Map<Integer, List<Integer>> types = new HashMap<>();
		Integer type;
		List<Integer> indexes;
		for (int i = 0; i < n; ++i) {
			type = Integer.parseInt(st.nextToken());
			if (!types.containsKey(type)) {
				indexes = new ArrayList<>();
				indexes.add(Integer.valueOf(i));
				types.put(type, indexes);
			} else {
				indexes = types.get(Integer.valueOf(type));
				indexes.add(Integer.valueOf(i));
			}
		}
		for (int i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			Integer desType = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			if (!types.containsKey(desType)) {
				System.out.println(-1);
				continue;
			}
			int count = 0, index, min = Integer.MAX_VALUE, diff=Integer.MAX_VALUE;
			indexes = types.get(desType);
			if(indexes.contains(start)) {
				System.out.println(count);
				continue;
			}
			if(dir == 'R') {
				ListIterator<Integer> iter = indexes.listIterator();
				while(iter.hasPrevious()) {
					index = iter.previous();
					
				}
			}
		}
	}
}
