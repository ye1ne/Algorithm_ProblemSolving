package BOJ_Study.BJ_BP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S15654 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] isVisited;
    static int[] arr;
    static int[] result;
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backTracking( M);
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int count) throws IOException{
        if (count == 0) {
            printArr();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isVisited[i])
                continue;
            isVisited[i] = true;
            result[M-count] = arr[i];
            backTracking(count-1);
            isVisited[i] = false;
        }
    }

    static void printArr() throws IOException {
        for(int i =0;i<M;i++){
            bw.write(result[i]+" ");
        }
        bw.newLine();
    }
}
