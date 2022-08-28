package BOJ_Study.BJ_BS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_BS_S10815 {
    static long[] card;
    static int min;
    static int max;
    static int result;
    static int N;
    static void find(long input){
        result =0;
        min = 0;
        max = N-1;
        while (min <= max){
            int pointer = (min+max)/2;
            if(card[pointer] > input){
                max = pointer-1;
            }else if(card[pointer] < input){
                min = pointer+1;
            }else{
                result = 1;
                break;
            }
        }
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
            find(Long.parseLong(st.nextToken()));
            bw.write(result+" ");
        }
        bw.flush();
        bw.close();

    }
}
