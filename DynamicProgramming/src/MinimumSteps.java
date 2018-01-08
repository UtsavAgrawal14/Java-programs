import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * On a positive integer, you can perform any one of the following 3 steps. 1.) Subtract 1 from it. ( n = n - 1 )  , 2.) If its divisible by 2, divide by 2.  , 3.) If its divisible by 3, divide by 3.
 * Given a positive integer n, find the minimum number of steps that takes n to 1
 * e.g: 1.) For n = 1 , output: 0       2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    3.)  For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
 */
public class MinimumSteps {

	private static List<Integer> minStepsM = new ArrayList<>();
	private static List<Integer> minStepsT = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, ans;
		long start,end;
		boolean choice = true;
		minStepsM.add(0);
		do {
			System.out.format("%-100s%n%n", "Enter an integer:");
			n = Integer.parseInt(br.readLine());
			start = System.nanoTime();
			ans = findStepsMemoi(n);
			end = System.nanoTime();
			System.out.format(" %-20s%-20s%-20s%n%n","Approach","Min. steps","Time(micro s.)");
			System.out.format(" %-20s%-20s%-20s%n", "Memoization",ans,findTime(start,end));
			start = System.nanoTime();
			ans = findStepsTabul(n);
			end = System.nanoTime();
			System.out.format(" %-20s%-20s%-20s%n", "Tabulation",ans,findTime(start,end));
			System.out.format("%-100s%n", "Press enter to test again..any other key then enter to exit.");
			choice = (br.readLine().length() == 0);
		}while(choice!=false);
	}

	private static int findStepsMemoi(int n) {
		
		if(minStepsM.size() > n) {
			return minStepsM.get(n);
		}
		if(n == 1) {
			minStepsM.add(0);
			return 0;
		}
		int steps = 1 + findStepsMemoi(n-1);
		int alt;
		if(n % 2 == 0) {
			alt = 1 + findStepsMemoi(n / 2);
			steps = (steps <= alt)? steps : alt; 
		}
		if(n % 3 == 0) {
			alt = 1 + findStepsMemoi(n / 3);
			steps = (steps <= alt)? steps : alt;
		}
		minStepsM.add(steps);
		return steps;
	}
	
	private static int findStepsTabul(int n) {
		minStepsT.add(0);
		minStepsT.add(0);
		int min, f, s;
		for(int i = minStepsT.size(); i <= n; ++i) {
			minStepsT.add(i,1 + minStepsT.get(i-1));
			if((i % 2) == 0) {
				f = minStepsT.get(i);
				s = 1 + minStepsT.get(i / 2);
				min = (s <= f)?s:f;
				minStepsT.set(i,min);
			}
			if((i % 3) == 0) {
				f = minStepsT.get(i);
				s = 1 + minStepsT.get(i / 3);
				min = (s <= f)?s:f;
				minStepsT.set(i,min);
			}
		}
		return minStepsT.get(n);
	}
	
	private static double findTime(long start, long end) {
		return (double)(end - start)/1000;
	}
}
