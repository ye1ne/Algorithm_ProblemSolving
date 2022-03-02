package BJ_GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_GRD_G1700 {

    static public class Info{
        int id, count;
        private Info(int id){
            this.id = id;
            this.count = 1;
        }
    }
    static LinkedList<Info> list = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] input = new int[K];
        int[] plug = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        boolean isUse = false;
        for(int  i=0; i<K;i++){
            input[i] =Integer.parseInt(st.nextToken());
            for(Info L :list){
                if(L.id == input[i]){
                    L.count++;
                    isUse = true;
                }
            }
            if(!isUse) list.add(new Info(input[i]));
            isUse = false;
        }
        int tmpCount = 0;
        OuterLoop:
        for(int i=0; tmpCount<N;i++){
            if(i>=K) break;
            for(int tmpId: plug){ //처음꽂을때 이미 꽂혀있으면 패스
                if(tmpId == input[i]) continue OuterLoop;
            }
            plug[tmpCount] = input[i];
            tmpCount++;
            for(Info tmp: list){
                if(tmp.id == input[i]) {
                    tmp.count--; break;
                }
            }
        }
        int count =0;
        OuterLoop:
        for(int i =N; i<K; i++){
            //이미 꽂혀있으면 패스
            for(int tmpId: plug){
                if(tmpId == input[i]){
                    for(Info tmpInfo: list){
                        if(tmpInfo.id == tmpId) {
                            tmpInfo.count--;
                            continue OuterLoop;
                        }
                    }
                }
            }

            for(int j =0; j<N; j++) {
                for(Info tmpInfo : list){
                    if(tmpInfo.id == plug[j] && tmpInfo.count == 0){
                        plug[j] = input[i];
                        count++;
                        continue OuterLoop;
                    }
                }
            }
            int lastId = -1;
            int lastIndex = K;
            for(int tmpId: plug) {
                InnerLoop:
                for(int j = list.size()-1;j>=0;j--){
                    if(list.get(j).id == tmpId && j <lastIndex){
                        lastId =tmpId;
                        lastIndex = j;
                        break InnerLoop;
                    }
                }
            }
            for(int j=0; j<N;j++){
                if(plug[j] == lastId){
                    plug[j] = input[i];
                    count++;
                }
            }

        }

        System.out.println(count);
    }
}
