package BOJ_Study.BJ_IM;


import java.io.*;
import java.util.*;

public class BJ_S1292 {
    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[] array = new int[B];
        int index = 0;

        for (int i = 1; i <= B; i++) {
            for (int j = 0; j < i; j++) {
                if (index == B) break;
                array[index++] = i;
            }
        }
        int sum = 0;
        for (int i = A; i <= B; i++) sum += array[i - 1];


        System.out.println(sum);
    }
}


