package x0B_recursive;

import java.io.*;

public class G2447 {
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        recursion(0,0,N);
        for (int i =0; i<N; i++) {
            for (int j =0; j<N; j++) {
                if (map[i][j]) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    static void recursion(int x,int y, int n){
        if(n==1) {map[x][y] = true; return;}
        for(int i =x;i<x+n;i+=n/3){
            for(int j =y;j<y+n;j+=n/3){
                if(i==x+n/3&&j==y+n/3) continue;
                recursion(i,j,n/3);
            }
        }
    }
}
