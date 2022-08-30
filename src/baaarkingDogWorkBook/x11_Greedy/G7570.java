package baaarkingDogWorkBook.x11_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G7570 {
    static int N, max = 0;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int studentNum = Integer.parseInt(st.nextToken());
            dp[studentNum] = dp[studentNum-1] +1;
            max= Math.max(dp[studentNum],max );
        }

        System.out.println(N-max);

    }
}
