package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G1043 {

    static class Info{
        int partyNum, peopleNum;
        int[] people;
        Info(int partyNum, int peopleNum){
            this.partyNum = partyNum;
            this.peopleNum = peopleNum;
            this.people = new int[peopleNum];
        }
    }

    static int N;
    static int M;
    static int knowTruthNum;
    static boolean[] isKnowTruth;
    static Info[] partyInfo;
    static boolean[][] partyGraph;
    static boolean[] isVisitParty;

    static void setIsKnowTruth(int partyNum){
        if(isVisitParty[partyNum]){
            return;
        }
        isVisitParty[partyNum] = true;
        int peopleNum = partyInfo[partyNum].peopleNum;
        int[] peopleList = partyInfo[partyNum].people;
        for(int i=0; i<peopleNum;i++){
            isKnowTruth[peopleList[i]] = true;
            for(int j= 0;j<M;j++){
                if(partyGraph[peopleList[i]][j]){
                    setIsKnowTruth(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        partyGraph = new boolean[N+1][M];
        isVisitParty = new boolean[M];

        st = new StringTokenizer(br.readLine());
        knowTruthNum = Integer.parseInt(st.nextToken());
        isKnowTruth = new boolean[N+1];
        for(int i=0;i<knowTruthNum; i++){
            isKnowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        partyInfo = new Info[M];
        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int attendNum = Integer.parseInt(st.nextToken());
            partyInfo[i] = new Info(i, attendNum);
            for(int j=0;j<attendNum;j++){
                partyInfo[i].people[j] = Integer.parseInt(st.nextToken());
                partyGraph[partyInfo[i].people[j]][i] = true;
            }
        }
        for(int i=0; i<M;i++){
            int peopleNum = partyInfo[i].peopleNum;
            int[] list = partyInfo[i].people;
            MiddleLoop:
            for(int j=0; j<peopleNum;j++){
                if(isKnowTruth[list[j]]){
                    setIsKnowTruth(i);
                }
            }
        }
        int result =0;
        for(int i=0; i<M;i++){
            int peopleNum = partyInfo[i].peopleNum;
            int[] list = partyInfo[i].people;
            if(peopleNum == 0){
                result++;
            }else if(!isKnowTruth[list[0]]){
                result++;
            }
        }
        System.out.println(result);
    }
}
