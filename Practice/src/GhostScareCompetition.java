import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class GhostScareCompetition {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] wins = new int[m];
        int ghost = 0, max = 0, ageOfMax = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i){
            ghost = Integer.parseInt(st.nextToken());
            ++wins[ghost - 1];
            if(wins[ghost - 1] > max){
                max = wins[ghost - 1];
                ageOfMax = ghost;
            }else if(wins[ghost - 1] == max) {
            	ageOfMax = (ageOfMax > ghost)?ageOfMax:ghost;
            }
            System.out.println(ageOfMax+" "+max);
        }
    }
}
