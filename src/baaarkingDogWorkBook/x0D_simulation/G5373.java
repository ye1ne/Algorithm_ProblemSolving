package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5373 {
    static int n;
    static char[][][] cube = new char[6][3][3];
    static char[] color = new char[]{'w', 'y', 'r', 'o', 'g', 'b'};
    static final int U = 0,  D =1, F=2,B=3,L=4,R=5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        while(TC-->0){
            initCube();
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(n-->0){
                String str = st.nextToken();
                if(str.charAt(0) == 'F') rotateside(F,str.charAt(1) );
                else if(str.charAt(0) == 'B') rotateside(B,str.charAt(1));
                else if(str.charAt(0) == 'U') rotateside(U,str.charAt(1));
                else if(str.charAt(0) == 'D') rotateside(D,str.charAt(1));
                else if(str.charAt(0) == 'L') rotateside(L,str.charAt(1));
                else if(str.charAt(0) == 'R') rotateside(R,str.charAt(1));
            }
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j)
                    sb.append(cube[U][i][j]+"");
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void rotateside(int side, char dir) {
        rotate(side,dir);
        int rotationNum = 1;
        if(dir == '-') rotationNum = 3;
        char tmp;
        while(rotationNum-->0){
            if(side == F){
                for(int i = 0; i < 3; ++i){
                    tmp = cube[U][2][i];
                    cube[U][2][i] = cube[L][2 - i][2];
                    cube[L][2 - i][2] = cube[D][0][2 - i];
                    cube[D][0][2 - i] = cube[R][i][0];
                    cube[R][i][0] = tmp;
                }
            }
            else if(side == B){
                for(int i = 0; i < 3; ++i){
                    tmp = cube[U][0][i];
                    cube[U][0][i] = cube[R][i][2];
                    cube[R][i][2] = cube[D][2][2 - i];
                    cube[D][2][2 - i] = cube[L][2 - i][0];
                    cube[L][2 - i][0] = tmp;
                }
            }
            else if(side == L){
                for(int i = 0; i < 3; ++i){
                    tmp = cube[U][i][0];
                    cube[U][i][0] = cube[B][i][0];
                    cube[B][i][0]  = cube[D][i][0];
                    cube[D][i][0] = cube[F][i][0];
                    cube[F][i][0] = tmp;
                }
            }
            else if(side == R){
                for(int i = 0; i < 3; ++i){
                    tmp = cube[U][i][2];
                    cube[U][i][2] = cube[F][i][2];
                    cube[F][i][2] = cube[D][i][2];
                    cube[D][i][2] = cube[B][i][2];
                    cube[B][i][2] = tmp;
                }
            }
            else if(side == U){
                for(int i = 0; i < 3; ++i){
                    tmp = cube[F][0][i];
                    cube[F][0][i] = cube[R][0][i];
                    cube[R][0][i] = cube[B][2][2 - i];
                    cube[B][2][2 - i] = cube[L][0][i];
                    cube[L][0][i] = tmp;
                }
            }
            else{ // DOWN
                for(int i = 0; i < 3; ++i){
                    tmp = cube[F][2][i];
                    cube[F][2][i] = cube[L][2][i];
                    cube[L][2][i] = cube[B][0][2 - i];
                    cube[B][0][2 - i] = cube[R][2][i];
                    cube[R][2][i] = tmp;
                }
            }
        }

    }

    static void rotate(int side, char dir) {
        int rotationNum = 1;
        if(dir == '-') rotationNum = 3;
        while(rotationNum-->0){
            char[][] tmp = new char[3][3];
            for(int i = 0; i < 3; ++i)
                for(int j = 0; j < 3; ++j)
                    tmp[j][2 - i] = cube[side][i][j];
            cube[side] = tmp;
        }
    }


    static void initCube(){
        for(int s = 0; s < 6; ++s)
            for(int i = 0; i < 3; ++i)
                for(int j = 0; j < 3; ++j)
                    cube[s][i][j] = color[s];
    }

}
