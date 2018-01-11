import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Triangles {

	public static void main(String[] args) throws NumberFormatException, IOException {
		    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine()), move, size = 1;
        ArrayList<Long> lookup = new ArrayList<>();
        lookup.ensureCapacity(39);
        List<BigInteger> lookupBig = new ArrayList<>();
        lookup.add(5L);
        long div = 1000000007;
        for(int i = 0; i < q; ++i){
            move = Integer.parseInt(br.readLine());
            if(move < 40) {
	            if(size >= move)
	                System.out.println(lookup.get(move - 1) % div);
	            else{
	                for(int j = size; j < move; ++j){
	                    lookup.add(lookup.get(j - 1) + 4 *(long) Math.pow(3, j));
	                    ++size;
	                }
	                System.out.println(lookup.get(move - 1) % div);
	            }
            }else {
            	if(size < 39) {
            		for(int j = size; j < 39; ++j){
	                    lookup.add(lookup.get(j - 1) + 4 *(long) Math.pow(3, j));
	                    ++size;
	                }
            	}
            	BigInteger prev = new BigInteger(lookup.get(38).toString());
            	for(int j = size; j < move; ++j) {
            		lookupBig.add(prev.add(new BigInteger("4").multiply(new BigInteger("3").pow(j))));
            		++size;
            	}
            	System.out.println(lookupBig.get(move - 40).mod(new BigInteger("1000000007")));
            }
        }
	}
	
}
