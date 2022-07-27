package BJ_BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class G1174 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static String str;
    static final long max = 9876543210l;
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        str = "";
        N = Integer.parseInt(br.readLine());
        if(N == 1023){
            System.out.println(9876543210l);
            return;
        }
        if(N>1022){
            System.out.println(-1);
            return;
        }
        for(int i =1; list.size()<=N;i++) {
            combination(9, i);
        }
        Collections.sort(list);
        System.out.println(list.get(N-1));
    }
    static void combination(int start, int placeNum){
        if(placeNum == 0){
            list.add(Long.parseLong(str));
            return;
        }
        for(int i = start; i>=0;i--){
            String tmpStr = str;
            str += i;
            combination(i-1,placeNum-1);
            str = tmpStr;
        }
    }
}
