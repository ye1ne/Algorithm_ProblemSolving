package Programmers.practice.hash;

import java.util.*;

public class 전화번호목록 {

    public static void main(String[] args) {
        String[] phone_book = {"1230589475937492","123"};
        System.out.println(solution(phone_book));
    }
    public static boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book);
        for(String phone: phone_book){

            StringBuilder sb = new StringBuilder();
            for(int c=0; c<phone.length(); c++){
                sb.append(phone.charAt(c));
                if(set.contains(sb.toString()))
                    return false;
            }
            set.add(phone);
        }
        return true;
    }

}
