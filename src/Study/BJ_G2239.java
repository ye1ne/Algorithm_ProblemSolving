package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_G2239 {

    static int map[][] = new int[9][9];
    static boolean end;
    static void dfs(int depth){
        if(depth == 81){
            end = true;
            return;
        }
        int row = depth /9;
        int col = depth %9;

        if(map[row][col] != 0){
            dfs(depth+1);
        }else{
            for(int i=1;i<=9;i++){
                if(!isValid(row,col,i)) continue;
                map[row][col] = i;
                dfs(depth+1);
                if(end) return;
                map[row][col] = 0;
            }
        }
     }

    static boolean isValid(int row, int col, int num) {
        for(int i=0;i<9;i++){
            if(map[row][i] == num || map[i][col] == num)
                return false;
        }
        int miniRow = row/3*3;
        int miniCol = col/3*3;
        for(int i = miniRow; i<miniRow+3;i++){
            for(int j= miniCol; j<miniCol+3;j++){
                if(map[i][j] == num) return false;
            }
        }
        return true;
    }

    static void printMap(){
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                if(j==8){
                    System.out.print(map[i][j]+"\n");
                    continue;
                }
                System.out.print(map[i][j]);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i<9;i++){
            String str = br.readLine();
            for(int j =0;j<9; j++){
                map[i][j] = str.charAt(j) - '0';

            }
        }
        dfs(0);
        printMap();

        System.out.println();
    }
}
