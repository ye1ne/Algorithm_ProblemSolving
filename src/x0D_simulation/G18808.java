package x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G18808 {
    static int N,M,K, totalSticker;
    static int[][] map;
    static int[][][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        totalSticker = 0;

        map = new int[N][M];
        sticker = new int[K][][];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int stickerN = Integer.parseInt(st.nextToken());
            int stickerM = Integer.parseInt(st.nextToken());
            sticker[i] = new int[stickerN][stickerM];
            for(int j=0; j<stickerN; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<stickerM; k++){
                    sticker[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        OuterLoop:
        for(int stickerIdx=0; stickerIdx<K; stickerIdx++){
            for(int rotation =0 ; rotation<4; rotation++) {
                int stickerN = sticker[stickerIdx].length;
                int stickerM = sticker[stickerIdx][0].length;
                for (int i = 0; i <=N-stickerN; i++) {
                    for (int j = 0; j <=M-stickerM; j++) {
                        //만약 붙일 공간이 있으면
                        if(canAttach(i,j,sticker[stickerIdx])){
                            attachSticker(i,j,sticker[stickerIdx]);
                            continue OuterLoop;
                        }
                    }
                }
                //90도 회전
                rotationSticker(stickerIdx);
            }


        }
        System.out.println(totalSticker);

    }

    private static void attachSticker(int x, int y, int[][] stickers) {
        for(int i=x;i<x+stickers.length; i++){
            for(int j =y; j<y+stickers[0].length; j++){
                if(stickers[i-x][j-y] == 1) {
                    map[i][j] = stickers[i - x][j - y];
                    totalSticker++;
                }
            }
        }
    }

    private static void rotationSticker(int stickerIdx) {
        int n = sticker[stickerIdx].length;
        int m = sticker[stickerIdx][0].length;
        int[][] rotationSticker = new int[m][n];
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                rotationSticker[i][j] = sticker[stickerIdx][n-1-j][i];
            }
        }
        sticker[stickerIdx] = rotationSticker;
    }

    private static boolean canAttach(int x, int y, int[][] stickers) {
        for(int i=x;i<x+stickers.length; i++){
            for(int j =y; j<y+stickers[0].length; j++){
                if(stickers[i-x][j-y] == 1 && map[i][j] == 1) return false;
            }
        }
        return true;
    }


}
