package BJ_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3085 {
    static int N;
    static int[][] map;
    static final int C=1,P=2,Z=3,Y=4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                switch (tmp.charAt(j)){
                    case 'C':
                        map[i][j] = C;
                        break;
                    case 'P':
                        map[i][j] = P;
                        break;
                    case 'Z':
                        map[i][j] = Z;
                        break;
                    case 'Y':
                        map[i][j] = Y;
                        break;

                }
            }
        }
    }
}
