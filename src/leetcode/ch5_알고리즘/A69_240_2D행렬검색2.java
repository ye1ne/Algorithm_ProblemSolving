package leetcode.ch5_알고리즘;

import java.util.Arrays;

public class A69_240_2D행렬검색2 {
    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] matrix = {{1,3,5}};
        int[][] matrix = {{2,5},{2,8},{7,9},{7,11},{9,11}};
        int target = 7;

        System.out.println(searchMatrix(matrix,target));
    }
    static public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0, col = matrix[0].length-1;
        while(row <matrix.length && col>=0 ){
            if(target ==matrix[row][col]) return true;
            if(target < matrix[row][col]){
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
