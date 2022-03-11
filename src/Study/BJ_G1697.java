package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1697 {
    static class Info{
        int location,time;

        public Info(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
    static Queue<Info> q = new LinkedList<>();
    final static int MAX_NUM = 100_000;
    static int N,K,result;
    static boolean[] isVisit = new boolean[MAX_NUM+1];

    static void dfs(){
        while(!q.isEmpty()){
            Info tmp = q.poll();
            int time = tmp.time;
            int location = tmp.location;

            if(isVisit[location]){
                continue;
            }else{
                isVisit[location] = true;
            }

            if(location == K){
                result = time;
                return;
            }else{
                int nextTime = ++time;
                if(location-1>=0) q.offer(new Info(location-1,nextTime));
                if(location <K && location+1<=MAX_NUM) q.offer(new Info(location+1,nextTime));
                if(location <K && 0 < location*2 && location*2<=MAX_NUM) q.offer(new Info(2*location,nextTime));
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = MAX_NUM;
        q.offer(new Info(N,0));
        dfs();
        System.out.println(result);
    }
}
