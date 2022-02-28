package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G13460 {

    final static int goUp = 1;
    final static int goDown = 2;
    final static int goLeft = 3;
    final static int goRight = 4;

    static int N;
    static int M;
    static char[][] map;
    static int count;

    static class Info{
        int x,y,dirt,count;
        public Info(int x, int y,int dirt,int count){
            this.x = x;
            this.y = y;
            this.dirt = dirt;
            this.count = count;
        }
    }

    static Stack<Info> s = new Stack<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static void solve(){
        while(!s.isEmpty()){
            Info tmp = s.pop();
            int x = tmp.x;
            int y = tmp.y;
            int dirt = tmp.dirt;
            int count = tmp.count;
            if(count>=10)
                return;
            if(map[x][y] == '#') continue;
            if(map[x][y] == 'O'){
                System.out.println("WOW");
                return;
            }

            switch(dirt){
                case goUp:
                    if(!(map[x-1][y] == '#')) s.push(new Info(x-1,y,goUp,count));
                    else{
                        s.push(new Info(x,y-1,goRight,count+1));
                        s.push(new Info(x,y+1,goLeft,count+1));
                    }
                    break;
                case goDown:
                    if(!(map[x+1][y] == '#')) s.push(new Info(x+1,y,goDown,count));
                    else{
                        s.push(new Info(x,y-1,goRight,count+1));
                        s.push(new Info(x,y+1,goLeft,count+1));
                    }
                    break;
                case goRight:
                    if(!(map[x][y+1] == '#')) s.push(new Info(x,y+1,goRight,count));
                    else{
                        s.push(new Info(x+1,y,goDown,count+1));
                        s.push(new Info(x-1,y,goUp,count+1));
                    }
                    break;
                case goLeft:
                    if(!(map[x][y-1] == '#')) s.push(new Info(x,y-1,goLeft,count));
                    else{
                        s.push(new Info(x+1,y,goDown,count+1));
                        s.push(new Info(x-1,y,goUp,count+1));
                    }
                    break;
            }

        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i =0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R') {
                    s.push(new Info(i+1,j,goDown,1));
                    s.push(new Info(i,j-1,goLeft,1));
                    s.push(new Info(i,j+1,goRight,1));
                    s.push(new Info(i-1,j,goUp,1));
                }
            }
        }
        solve();
        System.out.println();
    }
}
