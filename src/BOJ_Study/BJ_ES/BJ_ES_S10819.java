package BOJ_Study.BJ_ES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_ES_S10819 {
    static int res = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        permu(N, 0, 0, input, 0);
        System.out.println(res);

    }
    public static void permu(int n, int cnt, int sum, int[] arr,int before){
        if(cnt == n){
            res = Math.max(res, sum);
            return;
        }
        for (int i=0; i<n; i++){
            if(visit[i]) continue;

            visit[i] = true;
            if( cnt == 0){
                permu(n,cnt+1,sum,arr,i);
            }else{
                int tmp = Math.abs(arr[i] - arr[before]);
                permu(n, cnt + 1, sum + tmp, arr, i);
            }
            visit[i] = false;


        }
    }
}
