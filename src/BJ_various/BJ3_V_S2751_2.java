package BJ_various;


import java.io.*;

public class BJ3_V_S2751_2 {
    static int max_num = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] A = new boolean[2000001];

        for(int i =0; i<N;i++){
            A[Integer.parseInt(br.readLine())+1000000] = true;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i =0; i<A.length;i++){
             if(A[i]){
                 bw.write((i-1000000)+"\n");
             }
        }
        bw.flush();
        bw.close();
    }
}
