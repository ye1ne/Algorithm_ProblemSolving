package BJ_Array;

import java.io.*;
import java.util.StringTokenizer;

public class S3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<N; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());
        boolean[] isInArr = new boolean[2000001];
        int count = 0;
        for(int i =0; i<N;i++) {
            if(X-arr[i] >0 && isInArr[X-arr[i]]) count++;
            isInArr[arr[i]] = true;
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
