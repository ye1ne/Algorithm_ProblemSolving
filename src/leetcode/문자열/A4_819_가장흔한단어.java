package leetcode.문자열;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A4_819_가장흔한단어 {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        paragraph = paragraph.replaceAll("[^\uAC00-\uD7A30-9a-zA-Z]"," ");
        paragraph = paragraph.toLowerCase();
        StringTokenizer st = new StringTokenizer(paragraph);
        Map<String,Integer> count = new HashMap<>();
        String keys = "";

        OuterLoop:
        while(st.hasMoreTokens()){
            String tmpWord = st.nextToken();
            for(String banWord : banned) {
                if (tmpWord.equals(banWord)) continue OuterLoop;
            }
            if(count.containsKey(tmpWord)) count.put(tmpWord, count.get(tmpWord)+1);
            else count.put(tmpWord,1);

            if(!keys.equals("")) keys = Math.max(count.get(keys),count.get(tmpWord)) == count.get(tmpWord) ? tmpWord : keys;
            else keys = tmpWord;
        }

        System.out.println(keys);
    }
}
