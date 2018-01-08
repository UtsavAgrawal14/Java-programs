import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CanYouCountUbona {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr;
		int t = Integer.parseInt(br.readLine());
		int size, vowelsSoFar;
		long count;
		List<Character> vowels = new ArrayList<>();
		for (int i = 0; i < t; ++i) {
			vowels.clear();
			arr = br.readLine().toCharArray();
			size = arr.length;
			vowelsSoFar = 0;
			count = 1;
			for (int j = 0; j < size; ++j) {
				if (arr[j] == 'a' || arr[j] == 'e' || arr[j] == 'i' || arr[j] == 'o' || arr[j] == 'u') {
					if (vowels.isEmpty() || vowels.indexOf(arr[j]) == -1) {
						++vowelsSoFar;
						vowels.add(arr[j]);
					}
				} else if(arr[j] == '_') {
					count *= vowelsSoFar;
				}
			}
			System.out.println(count);
		}
	}

}
