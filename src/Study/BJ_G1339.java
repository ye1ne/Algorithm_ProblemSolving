package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BJ_G1339 {

    static class Info{
        char character;
        int num;
        public Info(char character, int num){
            this.character = character;
            this.num = num;
        }
    }

    static ArrayList<Info> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String str  = br.readLine();
            midLoop:
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);

                for(Info k: list) {
                    if (k.character == c) {
                        k.num += (int) (Math.pow(10, str.length() - j -1));
                        continue midLoop;
                    }
                }
                list.add(new Info(c,(int)(Math.pow(10, str.length() - j -1))));

            }
        }
        //Info class의 num을 기준으로 내림차순 정렬
        Collections.sort(list, new Comparator<Info>(){
            @Override
            public int compare(Info o1, Info o2) {
                return o2.num - o1.num;
            }
        });

        int tmpNum = 9;
        int result = 0;
        for(Info i : list){
            result += i.num*(tmpNum--);
        }

        System.out.println(result);
    }
}
