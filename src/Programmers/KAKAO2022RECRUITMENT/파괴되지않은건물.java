package Programmers.KAKAO2022RECRUITMENT;

public class 파괴되지않은건물 {
    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4}, {1,2,0,2,3,2}, {2,1,0,3,1,2}, {1,0,1,3,3,1}};

        int row = board.length;
        int col = board[0].length;
        int arr[] = new int[row*col];
        int nonBreak= row*col;
        boolean beforeBreak , afterBreak;

        for(int i = 0; i<skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            for(int r = r1; r<=r2; r++){
               for(int c = c1; c<=c2; c++){
                   beforeBreak = (board[r][c]<=0)? true : false;

                   if(type == 1) board[r][c] -= degree;
                   else board[r][c] += degree;

                   afterBreak = (board[r][c]<=0)? true : false;
                   if(beforeBreak && !afterBreak) nonBreak++;
                   else if(!beforeBreak && afterBreak)
                       nonBreak--;
               }
            }
        }

        System.out.println(nonBreak);
    }
}
