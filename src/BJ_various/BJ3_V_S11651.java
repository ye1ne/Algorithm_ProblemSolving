package BJ_various;

import java.io.*;
import java.util.*;

public class BJ3_V_S11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        String[][] A = new String[N][2];
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            A[i][0] = st.nextToken();
            A[i][1] = st.nextToken();
        }

        Arrays.sort(A, new Comparator<String[]>(){

            @Override
            public int compare(String[] o1, String[] o2) {
                /*
                if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }
                 */
                return Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0]));
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<N;i++){
            bw.write(A[i][0]+" "+A[i][1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
