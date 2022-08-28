package BOJ_Study.BJ_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G15686 {
    static int N, M;
    static int[][] map;
    static List<Integer[]> homeList = new ArrayList<>();
    static List<Integer[]> chikList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                Integer[] tmp = {i,j};
                if(map[i][j] == 1) homeList.add(tmp);
                if(map[i][j] == 2) chikList.add(tmp);
            }
        }
    }
}
