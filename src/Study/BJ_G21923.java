package Study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G21923 {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] up = new int[N][M];
        int[][] down = new int[N][M];

        up[N-1][0] = map[N-1][0];
        for (int i = N-1; i >= 0; i--) {
            if(i == N-1) {
                for (int j = 1; j < M; j++) {up[i][j] = up[i][j - 1] + map[i][j];}
                continue;
            }
            up[i][0] =  up[i+1][0] + map[i][0];
            for (int j = 1; j < M; j++) {up[i][j] = Math.max(up[i][j - 1],up[i+1][j])+ map[i][j];}
        }

        down[N-1][M-1] = map[N-1][M-1];
        for (int i = N-1; i >= 0; i--) {
            if(i== N-1){
                for(int j=M-2;j>=0;j--){
                    down[i][j] = down[i][j+1] + map[i][j];
                }
                continue;
            }
            down[i][M-1] =  down[i+1][M-1] + map[i][M-1];
            for (int j = M-2; j >=0; j--) {down[i][j] = Math.max(down[i+1][j],down[i][j+1])+ map[i][j];}

        }
        long maxNum = -10_000_000_000l;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(up[i][j]+down[i][j]>maxNum)
                    maxNum = up[i][j]+down[i][j];
            }
        }
        System.out.println(maxNum);
    }
}
