package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G1629 {

    static int A,B,C;
    static long result;
    static long solve(int i){
        if(i == 1){
            return A%C;
        }
        long x = solve(i/2)%C;
        if(i%2 == 0){
            return (x*x)%C;
        }else{
            return ((x*x)%C)*(A%C);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = solve(B);
        System.out.println(result%C);

    }
}
