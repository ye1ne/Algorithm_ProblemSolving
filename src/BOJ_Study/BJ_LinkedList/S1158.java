package BOJ_Study.BJ_LinkedList;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class S1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int location = 0;
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=N;i++){
            list.add(i);
        }

        for(int i=1;i<=N;i++){

            location = (location+K-1)%(N-i+1);
            result.add(list.get(location));
            list.remove(location);

        }
        String str = new StringTokenizer(result.toString(),"[").nextToken();
        str = new StringTokenizer("<"+str,"]").nextToken() + ">";

        System.out.println(str);
    }
}
