package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1474 {

    public static void main(String[] args) throws Exception {
        List<String> wordList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int totalLength = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            totalLength += str.length();
            wordList.add(str);
        }

        int default_len = (M - totalLength) / (N-1);
        int leave_default_len = (M - totalLength) % (N-1);
        StringBuilder sb = new StringBuilder();
        sb.append(wordList.get(0));
        for(int i =1; i<N; i++){
            if(wordList.get(i).charAt(0)>= 'a' && leave_default_len != 0){
                leave_default_len--;
                sb.append("_".repeat(Math.max(0, (default_len + 1))));
                sb.append(wordList.get(i));
            }else if (i + leave_default_len == N){
                leave_default_len--;
                sb.append("_".repeat(Math.max(0, (default_len + 1))));
                sb.append(wordList.get(i));
            }else {
                sb.append("_".repeat(Math.max(0, default_len)));
                sb.append(wordList.get(i));
            }
        }

        System.out.println(sb);

    }

}
