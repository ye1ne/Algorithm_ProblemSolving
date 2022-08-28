package baaarkingDogWorkBook.x09_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1600 {
    static int K, W, H;
    static int result;
    static int[][] map;
    static boolean[][][] visited;
    static class info{
        int x, y, count, horseCount;

        public info(int x, int y, int count, int horseCount) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.horseCount = horseCount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        visited = new boolean[W][H][K+1];
        map = new int[W][H];
        for(int i =0; i<W;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<H; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = -1;
        bfs();
        System.out.println(result);

    }

    private static void bfs() {

        Queue<info> q = new LinkedList<>();
        q.add(new info(0, 0, 0, 0));

        while (!q.isEmpty()) {
            info cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            int horseCount = cur.horseCount;

            if (x == W - 1 && y == H - 1) {
                result = count;
                break;
            }

            System.out.println("x="+x+" y="+y+" count="+count+" horseCount="+horseCount+" map = " + Arrays.deepToString(map));
            if (x - 1 >= 0 && !visited[x - 1][y][horseCount] && map[x - 1][y] == 0) {
                q.add(new info(x - 1, y, count + 1, horseCount));
                visited[x-1][y][horseCount] = true;
            }

            if (x + 1 < W && !visited[x + 1][y][horseCount] && map[x + 1][y] == 0) {
                q.add(new info(x + 1, y, count + 1, horseCount));
                visited[x+1][y][horseCount] = true;
            }
            if (y - 1 >= 0 && !visited[x][y - 1][horseCount] && map[x][y - 1] == 0) {
                q.add(new info(x, y - 1, count + 1, horseCount ));
                visited[x][y-1][horseCount] = true;
            }
            if (y + 1 < H && !visited[x][y + 1][horseCount]     && map[x][y + 1] == 0) {
                q.add(new info(x, y + 1, count + 1, horseCount));
                visited[x][y+1][horseCount] = true;
            }

            //가장 좌측 상단
            if (horseCount < K && x - 1 >= 0 && y - 2 >= 0 && !visited[x - 1][y - 2][horseCount + 1] && map[x - 1][y - 2] == 0) {
                q.add(new info(x - 1, y - 2, count + 1, horseCount + 1 ));
                visited[x-1][y-2][horseCount+1] = true;
            }
            //좌측 최 상단
            if (horseCount < K && x - 2 >= 0 && y - 1 >= 0 && !visited[x - 2][y - 1][horseCount + 1] && map[x - 2][y - 1] == 0) {
                q.add(new info(x - 2, y - 1, count + 1, horseCount + 1 ));
                visited[x-2][y-1][horseCount+1] = true;
            }
            //우측 최 상단
            if (horseCount < K && x - 2 >= 0 && y + 1 < H && !visited[x - 2][y + 1][horseCount + 1]     && map[x - 2][y + 1] == 0) {
                q.add(new info(x - 2, y + 1, count + 1, horseCount + 1));
                visited[x-2][y+1][horseCount+1] = true;
            }
            //가장 우측 상단
            if (horseCount < K && x - 1 >= 0 && y + 2 < H && !visited[x - 1][y + 2][horseCount + 1] && map[x - 1][y + 2] == 0) {
                q.add(new info(x - 1, y + 2, count + 1, horseCount + 1));
                visited[x-1][y+2][horseCount+1] = true;
            }
            //좌측 최 하단
            if (horseCount < K && x + 2 < W && y - 1 >= 0 && !visited[x + 2][y - 1][horseCount + 1] && map[x + 2][y - 1] == 0) {
                q.add(new info(x + 2, y - 1, count + 1, horseCount + 1 ));
                visited[x+2][y-1][horseCount+1] = true;
            }
            //가장 좌측 하단
            if (horseCount < K && x + 1 < W && y - 2 >= 0 && !visited[x + 1][y - 2][horseCount + 1]     && map[x + 1][y - 2] == 0) {
                q.add(new info(x + 1, y - 2, count + 1, horseCount + 1 ));
                visited[x+1][y-2][horseCount+1] = true;
            }
            //우측 최 하단
            if (horseCount < K && x + 2 < W && y + 1 < H && !visited[x + 2][y + 1][horseCount + 1] && map[x + 2][y + 1] == 0) {
                q.add(new info(x + 2, y + 1, count + 1, horseCount + 1));
                visited[x+2][y+1][horseCount+1] = true;
            }
            //가장 우측 하단
            if (horseCount < K && x + 1 < W && y + 2 < H && !visited[x + 1][y + 2][horseCount + 1] && map[x + 1][y + 2] == 0) {
                q.add(new info(x + 1, y + 2, count + 1, horseCount + 1));
                visited[x+1][y+2][horseCount+1] = true;
            }
        }
    }
}
