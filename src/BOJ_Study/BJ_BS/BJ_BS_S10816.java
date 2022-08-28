package BOJ_Study.BJ_BS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_BS_S10816 {
    static long[] card;
    static int N;
    static int find(long input) {
        int l_min = 0;
        int l_max = N - 1;
        boolean have = false;
        int pointer = 0;
        while (l_min <= l_max) {
            pointer = (l_min + l_max) / 2;
            if (card[pointer] >= input) {
                if(card[pointer] == input) have =true;
                l_max = pointer -1;
            } else if (card[pointer] < input) {
                l_min = pointer +1;
            }
        }

        int r_min = 0;
        int r_max = N - 1;
        while (r_min <= r_max) {
            pointer = (r_min + r_max) / 2;
            if (card[pointer] > input) {
                r_max = pointer - 1;
            } else if (card[pointer] <= input) {
                if(card[pointer] == input) have =true;
                r_min = pointer + 1;
            }
        }

        if (have) return r_max-l_min+1;
        else return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        card = new long[N];
        for(int i =0; i<N;i++){
            card[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(card);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<M;i++){
            bw.write(find(Long.parseLong(st.nextToken()))+" ");
        }
        bw.flush();
        bw.close();

    }
}
