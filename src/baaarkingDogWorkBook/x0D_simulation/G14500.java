package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G14500 {

    static boolean[][][] tetromino = {
            {{true,true,true,true}},
            {{true,true}, {true,true}},
            {{true,false},{true,false},{true,true}},
            {{true,false},{true,true},{false,true}},
            {{true,true,true}, {false,true,false}}
    };

    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N ;i++){
            st=  new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int MAX = 0;

        for(int tetroNum=0; tetroNum<5; tetroNum++){
            //대칭시키기
            for(int symmetryNum=0; symmetryNum<2; symmetryNum++) {
                //회전시키기
                for (int rotationNum = 0; rotationNum < 4; rotationNum++) {
                    int rowLength = tetromino[tetroNum].length;
                    int colLength = tetromino[tetroNum][0].length;
                    //1.1부터 확인 (범위 침범 안할때까지)
                    for (int i = 0; i <= N - rowLength; i++) {
                        for (int j = 0; j <= M - colLength; j++) {
                            int count = 0;
                            //확인
                            for (int r = 0; r < rowLength; r++) {
                                for (int c = 0; c < colLength; c++) {
                                    //테트로미노가 있으면
                                    if (tetromino[tetroNum][r][c] == true) {
                                        count += map[i + r][j + c];
                                    }
                                }
                            }
                            //맥스값과 비교후 갱신
                            MAX = Math.max(count, MAX);
                        }
                    }
                    //확인 후 방향 변경
                    rotation(tetroNum);
                }
                symmetry(tetroNum);
            }
        }

        System.out.println(MAX);
    }

    static void rotation(int num){
        boolean[][] tmpTetromino = new boolean[tetromino[num][0].length][tetromino[num].length];
        for(int i=0; i<tetromino[num].length; i++){
            for(int j=0; j<tetromino[num][0].length; j++){
                tmpTetromino[j][tetromino[num].length-i-1] = tetromino[num][i][j];
            }
        }
        tetromino[num] = tmpTetromino;
    }
    static void symmetry(int num){
        boolean[][] tmpTetromino = new boolean[tetromino[num].length][tetromino[num][0].length];
        for(int i=0; i<tetromino[num].length; i++){
            for(int j=0; j<tetromino[num][0].length; j++){
                tmpTetromino[i][tetromino[num][0].length-j-1] = tetromino[num][i][j];
            }
        }
        tetromino[num] = tmpTetromino;
    }
}
