package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G15685 {
    static int N,x,y,d,g;
    static int[][] map= new int[101][101];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(N-->0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();

            list.add(d%4); //방향을 더하고
            map[y][x] = 1;
            //0세대에서 원하는 세대까지
            while(g-->0){
                int listSize = list.size();
                for(int j=listSize-1; j>=0; j--){
                    list.add((list.get(j)+1)%4); //90도로 튼 방향을 넣음
                }
            }

            for(int i=0; i<list.size();i++){
                int dir = list.get(i);
                if(dir ==0) x++;
                else if(dir == 1) y--;
                else if(dir == 2) x--;
                else if(dir == 3) y++;
                map[y][x] = 1;
            }
        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] == 0) continue;
                if(map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1) count++;
            }
        }

        System.out.println(count);
    }
}
