package BOJ_Study.BJ_STR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            StringBuilder tmpStr = new StringBuilder(br.readLine());
            sb.append(tmpStr.reverse()+"\n");
        }

        System.out.println(sb);
        System.out.println();

    }
}
