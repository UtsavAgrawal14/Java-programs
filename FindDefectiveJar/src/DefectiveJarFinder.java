import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DefectiveJarFinder {

	static int counter = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of jars:");
		int jars = Integer.parseInt(br.readLine());
		float weights[] = new float[jars];
		System.out.println("Enter the weights of " + jars + " jars:");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < jars; ++i) {
			weights[i] = Float.parseFloat(st.nextToken());
		}
		int i = 1;
		float weightOnPan = 0.0f, correctWeight = 0.0f;
		do {
			weightOnPan = sum(weights, 0, i - 1);
			if(i == 1)
				correctWeight = weightOnPan;
			else {
				if(correctWeight * i != weightOnPan) {
					if(i == 2) {
						if(correctWeight == sum(weights, 2, 2)) {
							System.out.println("Jar number: 2 is defective.");
							break;
						}	
						else {
							System.out.println("Jar number: 1 is defective.");
							break;
						}
					}else {
						System.out.println("This is a tricky case");
					}
				}
			}
			i = (int) Math.pow(2, i);
		}while (i <= jars);
		System.out.println("Weighing pan was used "+counter+" times.");
	}

	private static float sum(float[] weights, int lowLimit, int highLimit) {
		++counter;
		float sum = 0.0f;
		for(int i = lowLimit; i <= highLimit; ++i) {
			sum += weights[i];
		}
		return sum;
	}
}
