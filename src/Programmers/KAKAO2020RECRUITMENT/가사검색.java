package Programmers.KAKAO2020RECRUITMENT;

import java.util.Arrays;
import java.util.HashMap;

public class 가사검색 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?","?"};

        HashMap<String,Integer> overlap = new HashMap<>();
        int[] answer = new int[queries.length];

        OuterLoop:
        for(int i=0; i<queries.length; i++){
            String query = queries[i];
            if(overlap.containsKey(query)){
                answer[i] = answer[overlap.get(query)];
                continue OuterLoop;
            }
            int count =0;

            if(query.charAt(0) == '?' && query.charAt(query.length()-1) == '?'){
                WordLoop:
                for(int j=0; j<words.length; j++) {
                    if (query.length() != words[j].length()) continue WordLoop;
                    count++;
                }
                answer[i] = count;
                overlap.put(query,i);
                continue OuterLoop;
            }
            //접미사일 경우

            if(query.charAt(0)=='?'){
                LastWordLoop:
                for(int j=0; j<words.length; j++){

                    //길이 다르면 애초에 땡이니까 바이
                    if(query.length() != words[j].length()) continue LastWordLoop;
                    for(int k=query.length()-1; k>=0; k--){
                        if(query.charAt(k)=='?') break;
                        if(query.charAt(k)!=words[j].charAt(k)) continue LastWordLoop;
                    }
                    count++;
                }
            }else { //접두사일 경우
                FirstWordLoop:
                for(int j=0; j<words.length; j++){

                    //길이 다르면 애초에 땡이니까 바이
                    if(query.length() != words[j].length()) continue FirstWordLoop;
                    for(int k=0; k<query.length();k++){
                        if(query.charAt(k)=='?') break;
                        if(query.charAt(k)!=words[j].charAt(k)) continue FirstWordLoop;
                    }
                    count++;
                }
            }

            answer[i] = count;
            overlap.put(query,i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
