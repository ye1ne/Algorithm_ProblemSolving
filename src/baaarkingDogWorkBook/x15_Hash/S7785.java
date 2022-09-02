package baaarkingDogWorkBook.x15_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S7785 {
    static int N;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0;i <N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if(state.equals("leave")){
                list.remove(name);
            }else list.add(name);
        }

        Collections.sort(list,Comparator.reverseOrder());
        for(String name: list) System.out.println(name);
    }
}
