package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G14890 {
    static int N,L;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalRoot =0;
        //각 행/열 에대해 확인
        for (int i = 0; i < N; i++) {
            OuterLoop:
            for (int rotationNum = 0; rotationNum < 2; rotationNum++) {
                boolean[] hasUsed = new boolean[N];
                int start = 0;
                //일단 각 행에 대하여 가능한지 판별
                while (start < N) {

                    if (isInBoundary(start+1) && map[i][start] == map[i][start + 1]) start++; //다음칸이랑 같으면
                    else if (isInBoundary(start+1) && map[i][start] == map[i][start + 1] + 1) { // 다음칸보다 1칸 크면
                        //앞으로 갈 길에 경사로 깔 수 있는지 체크
                        for (int next = 0; next < L; next++) {
                            if (!isInBoundary(start+next+1) || map[i][start + next+1] != map[i][start + 1]|| hasUsed[start+next+1]) { //만약 경사로를 못깔면
                                rotation();
                                continue OuterLoop; //이번행은 불가능 , 다음것 체크
                            }
                        }
                        //경사로를 깔 수 있으면
                        for (int next = 0; next < L; next++) hasUsed[start+next+1] = true;
                        start += L;
                    } else if (isInBoundary(start+1) && map[i][start] + 1 == map[i][start + 1]) { //다음칸보다 1칸 작으면
                        //지금까지 지나온길에 경사로 깔 수 있는지 체크
                        for (int next = 0; next < L; next++) {
                            if (!isInBoundary(start-next) || map[i][start - next] != map[i][start] || hasUsed[start-next]) { //만약 경사로를 못깔면
                                rotation();
                                continue OuterLoop; //이번행은 불가능 , 다음것 체크
                            }
                        }
                        //경사로를 깔 수 있으면 다음칸으로
                        for (int next = 0; next < L; next++) hasUsed[start-next] = true;
                        start++;
                    }else if(start == N-1){ ///마지막칸인 경우
                        start++;
                    }else { //그외에 높이가 2이상 차이나는 경우
                        rotation();
                        continue OuterLoop; //이번행 불가능, 다음것 체크
                    }
                }

                totalRoot++;
                rotation();
            }
            //180회전한 상태이므로 나머지 180 또 회전하여 원상태 복귀
            rotation();
            rotation();
        }

        System.out.println(totalRoot);

    }

    static void rotation(){
        int[][] tmpMap = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                tmpMap[j][N-1-i] = map[i][j];
            }
        }
        map = tmpMap;
    }

    static boolean isInBoundary(int number){
        if(number>=0 && number<N) return true;
        else return false;
    }
}
