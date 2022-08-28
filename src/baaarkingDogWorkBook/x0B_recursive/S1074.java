package baaarkingDogWorkBook.x0B_recursive;

import java.io.*;
import java.util.StringTokenizer;

public class S1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recursive(N,r,c));

    }

    static int recursive(int n, int r, int c ){
        //종료 조건
        if(n==0) return 0;
        int half = (int) Math.pow(2,n-1);
        if(r<half && c<half) return recursive(n-1,r,c);
        if(r<half && c>=half) return half*half + recursive(n-1,r,c-half);
        if(r>=half && c<half) return 2*half*half + recursive(n-1,r-half,c);
        return 3*half*half +recursive(n-1,r-half,c-half);
    }
}
