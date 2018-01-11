import java.io.BufferedReader;
import java.io.InputStreamReader;

class CircularCipher {
    public static void main(String args[] ) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String plain;
        char[] arr;
        int current, size = 0, cl, acl;
        for(int i = 0; i < t; ++i){
            current = 0;
            plain = br.readLine();
            arr = plain.toCharArray();
            size  = arr.length;
            for(int j = 0; j < size; ++j){
                cl = arr[j] - 97 - current;
                if(cl < 0)
                    cl = 26 + cl;
                acl = 26 - cl;
                if(cl <= acl){
                    System.out.print(cl+" ");
                    current += cl;
                }else{
                    System.out.print("-"+acl+" ");
                    current -= acl;
                }
            }
            System.out.println();
        }
    }
}
