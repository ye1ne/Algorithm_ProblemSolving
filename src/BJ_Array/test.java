package BJ_Array;

import java.io.*;
import java.nio.Buffer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for(int i = 97; i<=122; i++){
            int count = 0;
            for(int j=0; j< str.length(); j++){
                if(str.charAt(j) == i){
                    count++;
                }
            }
            bw.write(count+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
