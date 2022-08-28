package BOJ_Study.BJ_IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ1_IO_10951 {
    public static void main(String[] args) throws IOException{
        /** scanner 이용하는 방법
        int a,b;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){ //EOF 처리 해주는 방법
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(a+b);
        }
        scanner.close();
         **/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;

        while((str = br.readLine())!= null){
            st = new StringTokenizer(str," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
    }
}
