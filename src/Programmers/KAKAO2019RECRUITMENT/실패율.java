package Programmers.KAKAO2019RECRUITMENT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class 실패율 {

    public static void main(String[] args) {
        int N = 4;
        int[] stages = {5,1,2,3,3};
//        int N = 3;
//        int[] stages = {1,1};
        solution(N,stages);
    }

    /**
     * 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
     */
    static public int[] solution(int N, int[] stages) {
        //[][0] = 스테이지에 도달했으나 클리어 ㄴㄴ
        //[][1] = 스테이지에 도달한 플레이어 수
        int[][] arr = new int[N+2][2];

        for(int i=0; i<stages.length; i++){
            int stage = stages[i];
            for(int j=0; j<=stage; j++){
                arr[j][1]++;
            }
            arr[stage][0]++;
        }
        float[][] result = new float[N][2];
        for(int i=1; i<=N; i++){
            result[i-1][1] = i;
            result[i-1][0] = arr[i][0] == 0 ? 0 : (float) (arr[i][0])/(float) arr[i][1];
        }
        Arrays.sort(result, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                if(o1[0]>o2[0]) return -1;
                else return 1;

            }
        });
        int[] answer = new int[N];
        for(int i=0; i<N; i++) answer[i] = (int)result[i][1];
        return answer;
    }
}
