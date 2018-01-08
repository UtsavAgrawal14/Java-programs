import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KthPowerFreeNumbersCount {
	public static void main(String[] args) throws IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       long n = Long.parseLong(st.nextToken());
	       if (n == 1){
	           System.out.println(1);
	           System.exit(0);
	       }
	       long k = Long.parseLong(st.nextToken());
	       List<Long> primesExpK = new ArrayList<>();
	       if (Math.pow(2,k) <= n)
	           primesExpK.add((long)Math.pow(2,k));
	       long num = 3, val = (long)Math.pow(num,k);
	       while (val <= n){
	            if (isPrime(num))
	                primesExpK.add(val);
	            num += 2;
	            val = (long)Math.pow(num,k);
	       }
	       long kthPowerFree = 1, size = primesExpK.size();
	       for (long i = 2; i <= n; ++i){
	           if (isPrime(i) && k != 1)
	                ++kthPowerFree;
	           else{
	        	    int j = 0;
	                long div = primesExpK.get(0);
	                while(j < size - 1 && div <= i && i % div != 0) {
	                    div = primesExpK.get(++j);
	                }
	                if(i % div != 0 || div > i)
	                	++kthPowerFree;
	           }
	       }
	       System.out.println(kthPowerFree);
	    }
	    
	    static boolean isPrime(long num){
	        if (num == 2)
	            return true;
	        if(num % 2 == 0)
	            return false;
	        for(long i = 3; i <= Math.sqrt(num); i +=2)
	            if(num % i == 0)
	                return false;
	        return true;
	    }
}
