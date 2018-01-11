import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	        String [] temp = br.readLine().trim().split(" ");
	         int K = Integer.parseInt(temp[0]);
	         int N = Integer.parseInt(temp[1]);
	         String[] arr_arr = br.readLine().split(" ");
	         int[] arr = new int[N];
	         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
	         {
	         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
	         }

	         long out_ = Solve(K, arr);
	         System.out.println(out_);

	         wr.close();
	         br.close();
	    }
	    static long Solve(int K, int[] arr){
	    	 int len = arr.length;
	         if(len == 1)
	             return arr[0];
	         long total = 0;    
	         for(int i = len-1; i >= len-K; --i)
	             total += arr[i];
	         long sum = -1, fs = 0, rs = total;
	         int i = -1;
	         while(++i <= K){
	             if(i > 0){
	                 fs += arr[i-1];
	                 rs -= arr[len-K+i-1];
	             }
	             if((fs+rs) > sum)
	                 sum = fs+rs;
	         }  
	         return sum;
	    }
}
