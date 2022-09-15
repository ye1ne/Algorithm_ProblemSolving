package leetcode.ch4_비성형자료구조;

import java.util.Arrays;

public class A32_200_섬의개수 {


    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) {
        char[][] grid = {
        {'1','1','1','1','0'},
            {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                        };

        int count =0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }


        System.out.println(count);
    }

    static void dfs(char[][] grid, int r, int c){
        if(!isInRange(r, grid.length) || !isInRange(c, grid[0].length) || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        for(int i=0; i<4; i++){
            dfs(grid,r+dr[i],c+dc[i]);
        }
    }

    static boolean isInRange(int num,int size){
        if(num>=0 && num<size) return true;
        return false;
    }
}
