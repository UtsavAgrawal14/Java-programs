import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeStrings {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		System.out.println(mergeStrings(s1, s2));
	}

	static String mergeStrings(String s1, String s2) {
		StringBuilder result = new StringBuilder();
		int size1 = s1.length(), size2 = s2.length(), k = 0;
		while(k < size1 && k < size2) { 
			result.append(s1.charAt(k));
			result.append(s2.charAt(k));
			k++;
		}
		if(k < size1){
			result.append(s1.substring(k));
		}else if(k < size2) {
			result.append(s2.substring(k));
		}
		return result.toString();
	}
}
