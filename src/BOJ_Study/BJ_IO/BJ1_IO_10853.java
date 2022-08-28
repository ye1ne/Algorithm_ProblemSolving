package BOJ_Study.BJ_IO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1_IO_10853 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i <count; i++){
            str = br.readLine();
            st = new StringTokenizer(str,",");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a+b);
        }

    }
}
