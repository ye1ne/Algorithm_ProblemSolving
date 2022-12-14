package Programmers.KAKAO2019인턴;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer>[] boardStack = new Stack[board[0].length];
        for(int i=board.length-1 ;i>=0; i--){
            for(int j=0; j<board[i].length; j++){
                if(i == board.length-1) boardStack[j] = new Stack<>();
                if(board[i][j] != 0 ) boardStack[j].add(board[i][j]);
            }
        }
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        for(int move : moves){
            move--;
            if(boardStack[move].isEmpty()) continue;
            int doll = boardStack[move].pop();
            if(!bucket.isEmpty() && bucket.peek() == doll){
                answer+=2;
                bucket.pop();
            }else bucket.push(doll);
        }
        return answer;
    }
}
