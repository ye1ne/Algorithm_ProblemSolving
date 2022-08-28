package BOJ_Study.BJ_SET;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S1620 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<String,Integer> strMap = new HashMap<>();
    static Map<Integer,String> intMap = new HashMap<>();
    static int N,M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i =1; i<=N;i++){
            String tmpStr= br.readLine();
            strMap.put(tmpStr, i);
            intMap.put(i,tmpStr);
        }


        while(M-->0){
            String str = br.readLine();
            if(checkNumber(str)) findStr(Integer.parseInt(str));
            else findInt(str);


        }
        bw.flush();
        bw.close();
        System.out.println();
    }

    private static boolean checkNumber(String str) throws IOException {
        if(str.charAt(0) < 48 ||str.charAt(0) > 58)
            return false;
        return true;
    }

    private static void findStr(int str) throws IOException {
        bw.write(intMap.get(str));
        bw.newLine();
    }

    private static void findInt(String str) throws IOException {
        bw.write(strMap.get(str).toString());
        bw.newLine();
    }

}
