package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기 {

    static final String IMPOSSIBLE = "I'm Sorry Hansoo";

    public static void main(String[] args) throws IOException {
        int[] count = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        boolean hasCenter = false;
        char center = 'A';

        for (int i = 0; i < string.length(); i++) {
            count[string.charAt(i) - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                if (count[i] % 2 != 0) {
                    if(!hasCenter){
                        hasCenter = true;
                        center = (char) ('A' + i);
                        for(int j = 0; j < count[i]/2; j++) {
                            char ch = (char) ('A' + i);
                            sb.append(ch);
                        }
                    }else {
                        System.out.println(IMPOSSIBLE);
                        return;
                    }
                } else {
                    for(int j = 0; j < count[i]/2; j++) {
                        char ch = (char) ('A' + i);
                        sb.append(ch);
                    }
                }
            }
        }

        String result = sb.toString();
        if(hasCenter)
            result += Character.toString(center);
        result += sb.reverse().toString();
        System.out.println(result);
    }
}
