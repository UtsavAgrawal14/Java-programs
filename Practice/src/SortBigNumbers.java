import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SortBigNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] unsorted = new String[n];
		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			unsorted[unsorted_i] = in.next();
		}
		in.close();
		long start = System.nanoTime();
		String temp;
		long[] small = new long[n];
		int smallCount = 0;
		List<String> large = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			try {
				small[smallCount] = Long.parseLong(unsorted[i]);
				++smallCount;
			} catch (NumberFormatException nfe) {
				large.add(unsorted[i]);
				continue;
			}
		}
		Arrays.sort(small);
		for (int i = 0; i < large.size() - 1; ++i) {
			for (int j = 0; j < large.size() - 1 - i; ++j) {
				if (large.get(j).length() > large.get(j + 1).length()) {
					temp = large.get(j);
					large.set(j, large.get(j + 1));
					large.set(j + 1, temp);
				} else if (large.get(j).length() == large.get(j + 1).length()) {
					char[] f = large.get(j).toCharArray();
					char[] s = large.get(j + 1).toCharArray();
					inner: for (int k = 0; k < f.length; ++k) {
						if (Character.getNumericValue(f[k]) > Character.getNumericValue(s[k])) {
							temp = large.get(j);
							large.set(j, large.get(j + 1));
							large.set(j + 1, temp);
							break inner;
						} else if (Character.getNumericValue(f[k]) < Character.getNumericValue(s[k])) {
							break inner;
						}
					}
				}
			}
		}
		long end = System.nanoTime(); 
		for (int i = n - smallCount; i < n; ++i) {
			System.out.println(small[i]);
		}
		Iterator<String> it = large.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
		System.out.println("Time taken: "+(double)(end-start)/1000000+" milliseconds.");
	}
}
