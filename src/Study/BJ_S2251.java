package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_S2251 {

    static class Info{
        int a,b,c;

        public Info(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static Queue<Info> q= new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    static int A,B,C,total;
    static boolean[][][] isVisit;

    static void bfs (){
        while (!q.isEmpty()){
            Info info = q.poll();
            int a = info.a;
            int b = info.b;
            int c = info.c;
            if(isVisit[a][b][c]){
                continue;
            }
            isVisit[a][b][c] = true;
            if(a==0) list.add(c);

            if(a+c <=A) q.offer(new Info(a+c,b,0));
            else q.offer(new Info(A,b,c-(A-a)));
            if(b+c <=B) q.offer(new Info(a,b+c,0));
            else q.offer(new Info(a,B,c-(B-b)));

            if(a+b<=A)q.offer(new Info(a+b,0,c));
            else q.offer(new Info(A,b-(A-a),c));
            if(c+b<=C)q.offer(new Info(a,0,c+b));
            else q.offer(new Info(a,b-(C-c),C));

            if(b+a <=B)q.offer(new Info(0,b+a,c));
            else q.offer(new Info(a-(B-b),B,c));
            if(c+a <=C)q.offer(new Info(0,b,c+a));
            else q.offer(new Info(a-(C-c),b,C));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        total = C = Integer.parseInt(st.nextToken());
        isVisit = new boolean[A+1][B+1][C+1];
        q.offer(new Info(0,0,C));
        bfs();
        Collections.sort(list);
        for(Integer i : list){
            System.out.print(i+" ");
        }
    }
}
