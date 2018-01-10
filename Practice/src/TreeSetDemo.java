import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;

class TreeSetDemo {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Set<String> names = new TreeSet<>();
        for(int i = 0; i < t; ++i){
            int n = Integer.parseInt(br.readLine());
            for(int j = 0; j < n; ++j){
                String name = br.readLine();
                names.add(name);
            }
            Iterator<String> it = names.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }
}
