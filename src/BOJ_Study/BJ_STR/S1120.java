package BOJ_Study.BJ_STR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int lengthA = A.length();
        int lengthB = B.length();
        int min = 100;

        for(int i=0; i<=lengthB-lengthA; i++){
            int count =0;
            for(int j=0;j<lengthA;j++){
                if(A.charAt(j)!=B.charAt(j+i)){
                    count++;
                }
            }
            if(min>count){
                min = count;
            }
        }
        System.out.println(min);


    }
}
