
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        int count = 0;
        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            if(set.contains(tmp)) {
                count++;
                list.add(tmp);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String tmp : list) sb.append(tmp + "\n");
        System.out.println(count);
        System.out.println(sb);

    }

}