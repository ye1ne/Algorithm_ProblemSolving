package BOJ_Study.BJ_ES;

import java.io.*;
import java.util.*;

public class BJ_ES_S1476 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = E;

        while(true){
            if((result-E)%15 == 0 && (result-S)%28 == 0 && (result-M)%19 == 0){
                break;
            }else{
                result++;
            }
        }
        System.out.println(result);
    }
}
