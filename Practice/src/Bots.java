import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Bots {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        char[] ini, fin;
        boolean flag;
        for(int i = 0; i < t; ++i){
        	flag = true;
        	st = new StringTokenizer(br.readLine());
            ini = st.nextToken().toCharArray();
            fin = st.nextToken().toCharArray();
            int cia = 0, cib = 0, cfa = 0, cfb = 0, length = ini.length;
            for(int j = 0; j < length; ++j){
                if(ini[j] == 'A'){
                    ++cia;
                }else if(ini[j] == 'B'){
                    ++cib;
                }
                if(fin[j] == 'A'){
                    ++cfa;
                }else if(fin[j] == 'B'){
                    ++cfb;
                }
            }

            if(cia != cfa || cib != cfb){
            	
                System.out.println("No");
                flag = false;
                break;
            }else{
                List<Character> orderIni = new ArrayList<>();
                List<Character> orderFin = new ArrayList<>();
                boolean flag1 = false, flag2 = false;
                for(int j = 0; j < length; ++j){
                    if(ini[j] == 'A' || ini[j] == 'B'){
                        orderIni.add(ini[j]);
                        flag1 = true;
                    }
                    if(fin[j] == 'A' || fin[j] == 'B'){
                        orderFin.add(fin[j]);
                        flag2 = true;
                    }
                    if(flag1 && flag2){
                        if(orderIni.get(orderIni.size()-1) != orderFin.get(orderFin.size() - 1)){
                            System.out.println("No");
                            flag = false;
                            break;
                        }
                        flag1 = false;
                        flag2 = false;
                    }
                }
            }
            if(flag)
            	System.out.println("Yes");
        }
    }
}
