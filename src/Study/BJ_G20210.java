package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_G20210 {
    static int N;
    static String[] strings;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strings = new String[N];
        for(int i=0; i<N;i++){
            strings[i] = br.readLine();
        }
        Arrays.sort(strings, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                int str1Length = o1.length();
                int str2Length = o2.length();
                int minLength = str1Length;
                if(str2Length<minLength) minLength = str2Length;

                boolean beforeIsNumber = false;


                for(int i=0;i<minLength;i++){
                    int ch1 = o1.charAt(i);
                    int ch2 = o2.charAt(i);
                    if(ch1 != ch2) {
                        if(ch1 <10 && ch2>64){
                            return -1;
                        }
                        if(ch1 <10 && ch2 <10){

                        }
                        if(ch1 >64 && ch2<10){
                            return 1;
                        }
                        if(ch1 >64 && ch2 >64){

                        }
                    }else{

                    }
                }
                return 0;
            }
        });
        System.out.println();
    }
}
