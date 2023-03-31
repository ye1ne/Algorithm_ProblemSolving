package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class S1446 {

    static int N, D;
    static List<int[]> list;
    static int[] dp;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        inputNumbers();

        System.out.println(dp[D]);
    }

    private static void inputNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[D + 2];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            list.add(new int[]{start, end, length});

            if (dp[end] > dp[start] + length) {
                dp[end] = dp[start] + length;
                int tmp = dp[end];

                for (int j = end; j <= D; j++) {
                    dp[j] = tmp;
                    tmp++;
                }
            }
        }
        for (int i = 0; i <= D; i++) {
            System.out.println(dp[i]);
        }
    }

}
