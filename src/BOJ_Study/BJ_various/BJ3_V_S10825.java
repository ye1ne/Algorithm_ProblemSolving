package BOJ_Study.BJ_various;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ3_V_S10825 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        String[][] A = new String[N][4];
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            A[i][0] = st.nextToken();
            A[i][1] = st.nextToken();
            A[i][2] = st.nextToken();
            A[i][3] = st.nextToken();
        }

        Arrays.sort(A, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){
                    if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])){
                        if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])){
                            return o1[0].compareTo(o2[0]);
                        }
                        return -1*Integer.compare(Integer.parseInt(o1[3]),Integer.parseInt(o2[3]));
                    }
                    return Integer.compare(Integer.parseInt(o1[2]),Integer.parseInt(o2[2]));
                }
                return -1*Integer.compare(Integer.parseInt(o1[1]),Integer.parseInt(o2[1]));
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<N;i++){
            bw.write(A[i][0]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
