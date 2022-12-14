package Programmers.practice.dp;

public class N으로표현 {
    public static void main(String[] args) {
        System.out.println(solution(5,12));
    }

    public static int solution(int N, int number) {


        int[] dp = new int[number+1];
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 6;
        dp[4] = 3;
        dp[5] = 1;
        int answer = -1;
        return answer;
    }
}
