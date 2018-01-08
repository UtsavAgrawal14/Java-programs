
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	/**
	 * @author Utsav
	 * @param currentQuery
	 *            a {@code String} that represents a query for sold products
	 * @return a newly created {@code int array} that contains the query constraints
	 *         in the order:
	 *         {@code startDay, endDay, productId, categoryId, stateId, regionId}
	 * @throws NullPointerException
	 *             if {@code currentQuery} is null.
	 */
	static int[] getParams(String currentQuery) throws NullPointerException {
		if (currentQuery == null) {
			throw new NullPointerException();
		}
		int[] constraints = { 0, 0, 0, 0, 0, 0 };
		int j = -1;
		String[] params = currentQuery.split(" ");
		for (int i = 0; i < 3; ++i) {
			char[] param = params[i].toCharArray();
			if (param[0] == '-') {
				constraints[++j] = -1;
				++j;
			} else {
				String[] subParams = params[i].split("\\.");
				if (subParams.length == 1) {
					constraints[++j] = Integer.parseInt(params[i]);
					++j;
				} else {
					constraints[++j] = Integer.parseInt(subParams[0]);
					constraints[++j] = Integer.parseInt(subParams[1]);
					Arrays.sort(constraints);
				}
			}
		}
		return constraints;
	}

	static boolean checkDay(int[] qc, int[] sc) {
		if (qc[1] != 0)
			return sc[0] >= qc[0] && sc[0] <= qc[1];
		return qc[0] == sc[0];
	}

	static boolean checkProductId(int[] qc, int[] sc) {
		if (qc[2] == -1)
			return true;
		if (qc[3] == 0)
			return qc[2] == sc[2];
		return qc[2] == sc[2] && qc[3] == sc[3];
	}

	static boolean checkState(int[] qc, int[] sc) {
		if (qc[4] == -1)
			return true;
		if (qc[5] == 0)
			return qc[4] == sc[4];
		return qc[4] == sc[4] && qc[5] == sc[5];
	}

	static int countProducts(String query, String[] data) {
		int count = 0;
		if (k == 0) {
			return 0;
		}
		int[] queryConstraints = {};
		try {
			queryConstraints = getParams(query);
		} catch (NullPointerException npe) {
			System.err.println("Empty query cannot be processed.");
		}
		for (int i = 0; i < k; i++) {
			String q = data[i];
			// System.out.println(q);
			int[] saleConstraints = getParams(q);
			if (checkDay(queryConstraints, saleConstraints) && checkProductId(queryConstraints, saleConstraints)
					&& checkState(queryConstraints, saleConstraints)) {
				++count;
			}
		}
		return count;
	}

	static int k = 0;

	public static void main(String[] args) {
		int T;
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		String[] data = new String[T];
		input.nextLine();
		for (int i = 0; i < T; ++i) {
			String command = input.next();
			String queryString = input.nextLine();
			queryString = queryString.trim();
			switch (command) {
			case "Q":
				System.out.println(countProducts(queryString, data));
				break;
			case "S":
				data[k++] = queryString;
				// System.out.println("K: "+k);
				break;
			}
		}
		input.close();
	}
}
