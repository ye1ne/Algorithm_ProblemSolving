package x09_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1926 {

    static int[][] map;
    static boolean[][] isVisited;
    static class Index{
        int x, y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m, MAX, count;
    static Queue<Index> q = new LinkedList<>();
    static List<Index> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    list.add(new Index(i,j));
                }

            }
        }

        for(Index i : list) {
            if(isVisited[i.x][i.y]) continue;
            q.add(new Index(i.x,i.y));
            int tmpSize =0;
            while (!q.isEmpty()) {
                Index index = q.poll();
                if (isVisited[index.x][index.y]) continue;
                isVisited[index.x][index.y] = true;

                tmpSize++;

                if (index.x + 1 < n && map[index.x + 1][index.y] == 1 && !isVisited[index.x + 1][index.y]) {
                    q.add(new Index(index.x + 1, index.y));
                }
                if (index.y + 1 < m && map[index.x][index.y + 1] == 1 &&!isVisited[index.x][index.y + 1]) {
                    q.add(new Index(index.x, index.y + 1));
                }
                if (index.x - 1 >= 0 && map[index.x - 1][index.y] == 1 && !isVisited[index.x - 1][index.y]) {
                    q.add(new Index(index.x - 1, index.y));
                }
                if (index.y - 1 >= 0 && map[index.x][index.y - 1] == 1 && !isVisited[index.x][index.y - 1]) {
                    q.add(new Index(index.x, index.y - 1));
                }
            }

            if(tmpSize >MAX) MAX = tmpSize;
            count++;
        }
        System.out.println(count);
        System.out.println(MAX);

    }

}
