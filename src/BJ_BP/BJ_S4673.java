package BJ_BP;
import java.io.*;

public class BJ_S4673 {
    static boolean[] isTrue = new boolean[10100];
    static public void main(String[] args) throws IOException{
        int max = -1;
        int pointer = 1;
        while( max <=10050){
            String str = Integer.toString(pointer);
            int sum = pointer;
            for(int i=0; i<str.length();i++){
                sum += str.charAt(i) -'0';
            }
            isTrue[sum] = true;
            if(sum>=max) max = sum;
            pointer++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=10000;i++){
            if(!isTrue[i]) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
