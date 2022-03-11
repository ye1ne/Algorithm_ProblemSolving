package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G12851 {
    static class Info{
        int location,time;
        boolean isVisit;

        public Info(int location, int time, boolean isVisit) {
            this.location = location;
            this.time = time;
            this.isVisit = isVisit;
        }
    }

    static Queue<Info> q = new LinkedList<>();
    final static int MAX_NUM = 100_000;
    static Info[] isVisit = new Info[MAX_NUM+1];
    static int N,K,result,count;

    static void DFS(){
        while(!q.isEmpty()){
            Info tmp = q.poll();
            int time = tmp.time;
            int location = tmp.location;

            if(isVisit[location].time != time && isVisit[location].isVisit){
                continue;
            }else{
                isVisit[location].isVisit = true;
                isVisit[location].time = time;
            }
            if(location == K){
                result = time; count++;
                COUNT();
                return;
            }else{
                int nextTime = ++time;
                if(location-1>=0) q.offer(new Info(location-1,nextTime,false));
                if(location <K && location+1<=MAX_NUM) q.offer(new Info(location+1,nextTime,false));
                if(location <K && 0 < location*2 && location*2<=MAX_NUM) q.offer(new Info(2*location,nextTime,false));
            }
        }
    }
    static void COUNT(){
        while(!q.isEmpty()){
            Info tmp = q.poll();
            int time = tmp.time;
            int location = tmp.location;
            if(time != result) break;
            if(location == K) count++;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0;i<=MAX_NUM;i++) isVisit[i] = new Info(i,0,false);
        result = MAX_NUM; count = 0;
        q.offer(new Info(N,0,false));
        DFS();
        System.out.println(result +"\n"+count);
    }
}
