package x0C_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class G9663 {
    static class Location {
        int x,y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static List<Location> queenList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];



    }

    static void solve(int x, int y){

    }

}
