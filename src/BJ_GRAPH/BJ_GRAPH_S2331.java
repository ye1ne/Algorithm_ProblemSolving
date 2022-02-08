package BJ_GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_GRAPH_S2331 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String str = st.nextToken();
        int P = Integer.parseInt(st.nextToken());

        LinkedList<Integer> D = new LinkedList<>();
        D.add(Integer.parseInt(str));
        int count;
        OutLoop:
        while(true) {
            int sum = 0;
            count =0;
            for (int i = 0; i < str.length(); i++) {
                sum += (int)Math.pow(str.charAt(i) -'0', P);
            }
            for (int i : D) {
                if (i == sum) {
                    break OutLoop;
                }
                count++;
            }
            D.add(sum);
            str = Integer.toString(sum);
        }
        System.out.println(count);
    }

}
