package Programmers.practice.완전탐색;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8,1)));
    }
    public static int[] solution(int brown, int yellow) {

        int row =0, col =0;
        brown = (brown -4)/2;
        for(int i=1; i<brown; i++){
            row = i;
            col = brown-i;
            if( row * col == yellow) return new int[]{col+2,row+2};
            if(row>col) break;
        }

        return null;
    }
}