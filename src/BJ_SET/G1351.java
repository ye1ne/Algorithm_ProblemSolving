package BJ_SET;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G1351 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Long,Long> map = new HashMap<>();
    static long N;
    static int P,Q;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        bw.write(dp(N).toString());

        bw.flush();
        bw.close();

    }

    static Long dp(long num){
        if(num == 0) return (long)1;
        if( map.containsKey(num)) return map.get(num);
        long a = (long)Math.floor(num/P);
        long b = (long)Math.floor(num/Q);
        map.put(num,dp(a)+dp(b));
        return map.get(num);
    }
}
