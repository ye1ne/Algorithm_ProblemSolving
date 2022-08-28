package BOJ_Study.BJ_various;

import java.io.*;
import java.util.Arrays;

public class BJ_STR_S11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] A = new  String[str.length()];
        for(int i =0; i<str.length();i++){
            A[i] = str.substring(i);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.sort(A);
        for(int i =0; i<A.length;i++){
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
