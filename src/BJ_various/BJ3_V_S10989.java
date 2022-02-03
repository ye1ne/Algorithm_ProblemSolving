package BJ_various;

import java.io.*;

public class BJ3_V_S10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] A = new int[10001];
        for(int i=0;i<N;i++){
            A[Integer.parseInt(br.readLine())]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1;i<=10000;i++){
            if(A[i]!=0){
                for(int j=0; j<A[i]; j++)
                    bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
