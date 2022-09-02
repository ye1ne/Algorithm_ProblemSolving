package baaarkingDogWorkBook.x15_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S7785 {
    static int N;
    static HashMap<String,String> map = new HashMap();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0;i <N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if(state.equals("leave")){
                map.remove(name);
            }else map.put(name, state);
        }
        Object[] mapKey = map.keySet().toArray();
        Arrays.sort(mapKey);
        for(int i= mapKey.length-1;i>=0; i--) System.out.println(mapKey[i]);
    }
}
