import java.util.Scanner;

public class CalcSum {

	public static void main(String[] args) {
		int N, k, maxSum = 0, size;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		k = sc.nextInt();
		++k;
		int[] coupons = new int[N];
		size = (N - 1) / k + 1;
		int[] couponSums = new int[size];
		for (int i = 0; i < N; ++i) {
			coupons[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i <= (N - 1) % k; ++i) {
			maxSum = 0;
			for (int j = i; j < N; j += k) {
				couponSums[i] += coupons[j];
			}
			if (couponSums[i] > maxSum) {
				maxSum = couponSums[i];
			}
		}
		System.out.println("\n" + maxSum);
	}

}
