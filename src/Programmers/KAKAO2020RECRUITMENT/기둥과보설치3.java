package Programmers.KAKAO2020RECRUITMENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 기둥과보설치3 {
    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        int[][] build_frame ={{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        //x, y ,기둥(0) 보(1) , 삽입(1) 삭제(0)
//        int[][] build_frame = {{2, 0, 0, 1}, {100, 0, 0, 1}, {100, 1, 1, 1}, {99, 1, 1, 1}, {99, 1, 0, 1}, {99, 0, 0, 1}};
//        int[][] build_frame = {{0,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{2,1,0,1},{3,0,0,1},{2,1,1,1},{1,1,1,1}};
        solution(n,build_frame);
    }


    static public int[][] solution(int n, int[][] build_frame) {

        N = n;
        paillarMap = new boolean[n + 3][n + 3];
        beamMap = new boolean[n+3][n+3];

        for (int i = 0; i < build_frame.length; i++) {
            int c = build_frame[i][0] +1;
            int r = build_frame[i][1] +1 ;
            int type = build_frame[i][2]; //기둥0, 보1
            int action = build_frame[i][3]; //삭제0, 설치1
            if(type == PAILLER){
                if(action == ADD&& isExistPailler(c,r)){
                    paillarMap[c][r] = true;
                }
                if(action == REMOVE && canRemove(c,r,PAILLER)){
                    paillarMap[c][r] = false;
                }
            }else {
                if(action == ADD && isExistBeam(c,r)){
                    beamMap[c][r] =true;
                }
                if(action == REMOVE && canRemove(c,r,BEAM)){
                    beamMap[c][r] = false;
                }
            }

        }
        List<int[]> result = new ArrayList<>();
        for(int c=1; c<=n+1; c++){
            for(int r=1; r<=n+1; r++){
                //기둥
                if(paillarMap[c][r]) result.add(new int[]{c-1,r-1,PAILLER});
                //보
                if(beamMap[c][r]) result.add(new int[]{c-1,r-1,BEAM});
            }
        }
        int[][] answer = new int[result.size()][3];
        int count =0;
        for(int[] arr : result){
            answer[count] = arr;
            count++;
        }
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(o1[1]==o2[1]) return o1[2]-o2[2];
                    else  return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        return answer;
    }

    static boolean[][] paillarMap,  beamMap;
    static final int PAILLER = 0, BEAM =1, REMOVE =0 , ADD =1;
    static int N;

    static boolean isExistPailler(int x, int y){
        if(y ==1) return true;
        if(paillarMap[x][y-1]) return true;
        if(beamMap[x][y]) return true;
        if(beamMap[x-1][y]) return true;
        return false;
    }

    static boolean isExistBeam(int x, int y){
        if(beamMap[x-1][y] && beamMap[x+1][y]) return true;
        if(paillarMap[x][y-1]) return true;
        if(paillarMap[x+1][y-1]) return true;
        return false;
    }

    static boolean canRemove(int x, int y, int flag){
        boolean result = true;

        //임시 삭제함
        if(flag == PAILLER) paillarMap[x][y] = false;
        else beamMap[x][y] = false;

        Loop:
        for(int i=1; i<=N+1; i++){
            for(int j=1; j<=N+1; j++){
                if(paillarMap[i][j] && !isExistPailler(i,j)){
                    result = false;
                    break Loop;
                }

                if(beamMap[i][j] && !isExistBeam(i,j)){
                    result = false;
                    break Loop;
                }
            }
        }
        if(flag == PAILLER) paillarMap[x][y] = true;
        else beamMap[x][y] = true;

        return result;
    }
}
