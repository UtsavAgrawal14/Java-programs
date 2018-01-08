import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class FindNumberFromString {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		List<String> lines = new ArrayList<>();
		for (int i = 0; i < t; ++i) {
			lines.add(br.readLine());
		}
		for (String line : lines) {
			char[] arr = line.toCharArray();
			BigInteger max = null;
			int left = 0, right = 0;
			Boolean lFound = false, first=true, rFound=false;
			for (int i = 0; i < arr.length; ++i) {
				if (Character.isDigit(arr[i]) && first) {
					left = i;
					lFound = true;
					first=false;
				} else if (lFound && !Character.isDigit(arr[i])) {
					lFound = false;
					right = i;
					first=true;
					rFound=true;
				}else if(lFound && i==arr.length-1) {
					right = i+1;
					rFound=true;
				}
				if(rFound) {
					rFound=false;
					BigInteger number = new BigInteger(line.substring(left, right));
					if (max == null || (max.compareTo(number) < 0)) {
						max = number;
					}
				}
			}
			System.out.println(max);
		}
	}
}