package com.junit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Contrasts the running time of Naive, Memoized and Tabulated approaches of finding the sum upto {@code t} natural numbers.
 * @author Utsav  
 */
public class SumOfNaturalNumbers {

	/**
	 * The lookup for memoized technique.
	 */
	private static List<Long> lookupM = new ArrayList<>();
	/**
	 * The lookup for tabulated technique.
	 */
	private static List<Long> lookupT = new ArrayList<>();
	/**
	 * An integer that counts the total number of recursive calls made for finding the answer through memoization.
	 */
	private static int countRecursion;

	public static void main(String[] args) throws IOException {
		lookupM.add(0L);
		lookupT.add(0L);
		boolean choice = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int term;
		do {
			countRecursion = -1;
			term = takeInput();
			if (term < 0) {
				System.err.println("Term number must be non-negative. Try again...");
			} else {
				long start = System.nanoTime();
				long naive = sumNaive(term);
				long end = System.nanoTime();
				double naiveT = computeMicros(start, end);
				start = System.nanoTime();
				long memoi = sumMemoi(term);
				end = System.nanoTime();
				double memoiT = computeMicros(start, end);
				start = System.nanoTime();
				long tabul = sumTabul(term);
				end = System.nanoTime();
				double tabulT = computeMicros(start, end);
				System.out.println("Approach\t\tAnswer\t\tTime(micro s)");
				System.out.println("Naive Appr\t\t" + naive + "\t\t" + naiveT + "\nMemoization\t\t" + memoi + "\t\t"
						+ memoiT + "\nTabulation\t\t" + tabul + "\t\t" + tabulT);
				String best = (tabulT <= memoiT) ? (tabulT <= naiveT) ? "Tabulation" : "Naive"
						: (memoiT <= naiveT) ? "Memoization" : "Naive";
				String worst = (tabulT >= memoiT) ? (tabulT >= naiveT) ? "Tabulation" : "Naive"
						: (memoiT >= naiveT) ? "Memoization" : "Naive";
				System.out.println("\n\nBest time: " + best + "\nWorst Time: " + worst + "\n");
				System.out.println("Recursive calls in memoization: "+countRecursion);
				System.out.println("Test again? Press enter to continue or any other key to exit...");
				choice = br.readLine().length() == 0;
			}
		} while (choice != false);
	}

	/**
	 * Uses naive technique for finding the sum of first {@code t} natural numbers.
	 * 
	 * @param t
	 *            the term number
	 * @return the sum of first {@code t} natural numbers.
	 */
	static long sumNaive(int t) {

		long sum = 0;
		for (int i = 1; i <= t; ++i)
			sum += i;
		return sum;
	}

	/**
	 * Uses memoization technique for finding the sum of first {@code t} natural
	 * numbers.
	 * 
	 * @param t
	 *            the term number
	 * @return the sum of first {@code t} natural numbers.
	 * @author Utsav
	 */
	static long sumMemoi(int t) {
		++countRecursion;
		if (lookupM.size() <= t) {
			lookupM.add(sumMemoi(t - 1) + t);
		}
		return lookupM.get(t);
	}

	/**
	 * Uses tabulation technique for finding the sum of first {@code t} natural
	 * numbers.
	 * 
	 * @param t
	 *            the term number
	 * @return the sum of first {@code t} natural numbers.
	 * @author Utsav
	 */
	static long sumTabul(int t) {
		if (lookupT.size() <= t) {
			int top = lookupT.size();
			for (int i = top; i <= t; ++i)
				lookupT.add(lookupT.get(i - 1) + i);
		}
		return lookupT.get(t);
	}

	static int takeInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n\n\t\tSum of first N Natural numbers\n\nEnter the term number:");
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
