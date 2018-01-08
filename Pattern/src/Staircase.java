import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Prints a right-aligned staircase with given number of steps. 
 */
public class Staircase {

	public static void main(String... args) throws NumberFormatException, IOException {
		System.out.println("Enter the number of steps:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int steps = Integer.parseInt(br.readLine());
		buildStaircase(steps);

	}

	public static void buildStaircase(int steps) {
		for (int i = 1; i <= steps; ++i) {
			for (int spaces = steps - i; spaces > 0; --spaces) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; ++j)
				System.out.print("#");
			System.out.println();
		}
	}
}
