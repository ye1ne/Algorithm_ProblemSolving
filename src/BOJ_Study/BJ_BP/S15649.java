package BOJ_Study.BJ_BP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S15649 {

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

    }

    static void backTracking(int start, int count){
        if(count == 0){
            printArr();
            return;
        }

        for(int i = 1; i<=N; i++){
            if(isVisited[i]){
                continue;
            }
            isVisited[i] = true;
            arr[M-count] = i;
            backTracking(i+1,count-1);
            isVisited[i] = false;
        }

    }

    static void printArr(){

        for(int i =0;i<M;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("");
    }
}
