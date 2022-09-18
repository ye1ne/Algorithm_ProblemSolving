package leetcode.ch5_알고리즘;

import java.util.Arrays;

public class A62_242_유효한애너그램 {
    public static void main(String[] args) {
        String s = "anagrame";
        String t = "nagaramq";
        System.out.println(isAnagram(s,t));
    }

    static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
