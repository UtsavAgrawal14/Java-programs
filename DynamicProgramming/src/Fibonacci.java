import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Contrasts the running time of Naive, Memoized and Tabulated approaches of
 * finding the {@code t th} term of the Fibonacci Sequence.
 * 
 * @author Utsav
 */
public class Fibonacci {

	/**
	 * The lookup for memoized technique.
	 */
	private static ArrayList<Long> lookupM = new ArrayList<>();
	/**
	 * The lookup for tabulated technique.
	 */
	private static ArrayList<Long> lookupT = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		boolean choice = true;
		lookupM.ensureCapacity(93);
		lookupT.ensureCapacity(93);
		lookupM.add(0, 0L);
		lookupM.add(1, 1L);
		lookupT.add(0, 0L);
		lookupT.add(1, 1L);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int term;
		do {
			term = takeInput();
			if (term < 1 || term > 93) {
				System.err.println("Term number must be between 1 and 93. Try again...");
			} else {
				long start = System.nanoTime();
				long naive = fibNaive(term - 1);
				long end = System.nanoTime();
				double naiveT = computeMicros(start, end);
				start = System.nanoTime();
				long memoi = fibMemoi(term - 1);
				end = System.nanoTime();
				double memoiT = computeMicros(start, end);
				start = System.nanoTime();
				long tabul = fibTabul(term - 1);
				end = System.nanoTime();
				double tabulT = computeMicros(start, end);
				System.out.format("%-15s%-25s%-10s%n%n", "Approach", "Answer", "Time(micro s)");
				System.out.format("%-15s%-25s%-10s%n", "Naive Appr", naive, naiveT);
				System.out.format("%-15s%-25s%-10s%n", "Memoization", memoi, memoiT);
				System.out.format("%-15s%-25s%-10s%n", "Tabulation", tabul, tabulT);
				String best = (tabulT <= memoiT) ? (tabulT <= naiveT) ? "Tabulation" : "Naive"
						: (memoiT <= naiveT) ? "Memoization" : "Naive";
				String worst = (tabulT >= memoiT) ? (tabulT >= naiveT) ? "Tabulation" : "Naive"
						: (memoiT >= naiveT) ? "Memoization" : "Naive";
				System.out.format("%n%-15s%-20s%n%-15s%-20s%n", "Best time: ", best, "Worst Time: ", worst);
				System.out.format("%n%100s%n","Test again? Press enter to continue or any other key to exit...");
				choice = br.readLine().length() == 0;
			}
		} while (choice != false);
	}

	/**
	 * Uses naive technique for finding the {@code t th} term of the Fibonacci
	 * Sequence.
	 * 
	 * @param t
	 *            the term number of Fibonacci Sequence (starting from 0).
	 * @return the value of {@code t th} term.
	 */
	static long fibNaive(int t) {
		if (t < 2)
			return t;
		long sum = 0;
		long first = 0, second = 1;
		for (int i = 0; i < (t - 1); ++i) {
			sum = first + second;
			first = second;
			second = sum;
		}
		return sum;
	}

	/**
	 * Uses memoization technique of Dynamic Programming for finding {@code t th}
	 * term of the Fibonacci Sequence.
	 * 
	 * @param t
	 *            the term number of Fibonacci Sequence (starting from 0).
	 * @return the value of {@code t th} term.
	 * @author Utsav
	 */
	static long fibMemoi(int t) {
		if (lookupM.size() < t + 1) {
			lookupM.add(fibMemoi(t - 1) + fibMemoi(t - 2));
		}
		return lookupM.get(t);
	}

	/**
	 * Uses tabulation technique of dynamic programming for finding the {@code t th}
	 * term of the Fibonacci Sequence.
	 * 
	 * @param t
	 *            the term number of Fibonacci Sequence (starting from 0).
	 * @return the value of {@code t th} term.
	 * @author Utsav
	 */
	static long fibTabul(int t) {
		if (lookupT.size() < t + 1) {
			for (int i = lookupT.size(); i <= t; ++i)
				lookupT.add(lookupT.get(i - 1) + lookupT.get(i - 2));
		}
		return lookupT.get(t);
	}

	static int takeInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.format("%n%n%92s%n%100s%n","Nth Term of Fibonacii sequence","Enter the term number (Between 1 and 93 only):");
		try {
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("No number found..try again");
			return takeInput();
		}
	}

	static double computeMicros(long start, long end) {
		return (double) (end - start) / 1000;
	}
}
