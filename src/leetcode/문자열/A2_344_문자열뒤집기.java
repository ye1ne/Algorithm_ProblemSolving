package leetcode.문자열;

import java.util.Arrays;

public class A2_344_문자열뒤집기 {
    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};

        int length = s.length%2 == 0 ? s.length/2 : s.length/2 +1;
        for(int i =0; i< length; i++){
            char tmp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = tmp;
        }

        System.out.println(Arrays.toString(s));
    }
}
