package BOJ_Study.BJ_STR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class S15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> hashMap= new HashMap<>();
        String str =  br.readLine();
        for(int i=0; i<str.length(); i++){
            if(hashMap.containsKey(str.charAt(i))) continue;
            hashMap.put(str.charAt(i),i);
        }

        for(char c = 'a'; c <= 'z'; c++){
            if(hashMap.containsKey(c)) sb.append(hashMap.get(c)+" ");
            else sb.append(-1+" ");
        }
        System.out.println(sb);

    }
}
