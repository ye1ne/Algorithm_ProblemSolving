package x0B_recursive;

import java.io.*;

public class S11729 {

    static int N,count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        count = 0;
        hanoiTower(N,1,2,3);
        bw.write(count+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void hanoiTower(int num, int from, int via ,int to) throws IOException{
        if(num == 1) {
            sb.append(from+" "+to+"\n");
            count++;
            return;
        }
        hanoiTower(num-1,from,to,via);
        sb.append(from +" "+to+"\n"); count++;
        hanoiTower(num-1,via,from,to);
    }
}
