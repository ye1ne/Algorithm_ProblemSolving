package BJ_Array;

import java.io.*;

public class B2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalNum = 1;
        for(int i =0 ; i<3; i++) {
             totalNum *= Integer.parseInt(br.readLine());
        }
        String strNum = String.valueOf(totalNum);
        for(int i =0; i<10;i++) {
            int count = 0;
            for (int j = 0; j < strNum.length(); j++) {
                if (strNum.charAt(j) -'0' == i) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
