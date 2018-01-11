import java.util.Scanner;

public class IPAddressChecker {
	
	 public static void main(String[] args){
	        Scanner in = new Scanner(System.in);
	        boolean choice = true;
	        while(choice){
	            String IP = in.next();
	            System.out.println(IP.matches(new MyRegex().pattern));
	            choice = in.hasNext();
	        }
	        in.close();
	    }
}

class MyRegex{
    public String pattern = "(((2([0-5]){2})|(1([0-9]){2})|(\\d){1,2}|(0){3})\\.){3}";
}
