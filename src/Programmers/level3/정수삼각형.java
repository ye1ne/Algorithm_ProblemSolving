package Programmers.level3;

public class 정수삼각형 {
    public static void main(String[] args) {

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];

        int totalMax =0;
        for(int i=0; i<triangle.length;i++){
            for(int j=0; j<triangle[i].length; j++){
                if(i == 0 && j == 0) {
                    dp[0][0] = triangle[0][0];
                    continue;
                }
                int max = 0;
                if(j ==0 ){
                    max = dp[i-1][j];
                }else if( j == triangle[i].length-1){
                    max = dp[i-1][j-1];
                }else{
                    max = Math.max(dp[i-1][j],dp[i-1][j-1]);
                }
                dp[i][j] = max + triangle[i][j];

                totalMax = Math.max(totalMax,dp[i][j]);
            }
        }

        System.out.println(totalMax);
    }
}
