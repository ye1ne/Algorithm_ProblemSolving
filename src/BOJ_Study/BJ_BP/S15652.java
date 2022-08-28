package BOJ_Study.BJ_BP;

import java.io.*;
import java.util.StringTokenizer;

public class S15652 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;
    static boolean[] isVisited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        arr = new int[M];

        backTracking(1, M);
        bw.flush();

    }

    static void backTracking(int start, int count) throws IOException{

        if(count == 0){
            printArr();
            return;
        }

        for(int i = start; i<=N; i++){

            isVisited[i] = true;
            arr[M-count] = i;
            backTracking(i,count-1);
            isVisited[i] = false;
        }

    }

    static void printArr() throws IOException{
        for(int i =0;i<M;i++){
            bw.write(arr[i]+" ");
        }
        bw.newLine();
    }
}
