package Study;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_B13458 {
    static int N;
    static int[] A;
    static int B;
    static int C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long count =0;
        for(int i=0;i<N;i++){
            count++;
            if(A[i]-B>0) {
                if (((A[i] - B) % C) != 0) {
                    count += (A[i] - B) / C + 1;
                } else {
                    count += (A[i] - B) / C;
                }
            }

        }
        System.out.println(count);
    }
}
