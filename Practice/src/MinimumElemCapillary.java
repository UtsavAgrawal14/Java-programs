import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumElemCapillary {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()),n, k, q; 
		int[] arr;
		StringTokenizer st;
		for(int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
		}
	}

}
