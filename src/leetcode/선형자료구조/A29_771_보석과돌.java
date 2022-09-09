package leetcode.선형자료구조;

import java.util.HashMap;

public class A29_771_보석과돌 {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbbbbbaA";

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i <stones.length();i++){
            if(map.containsKey(stones.charAt(i))) map.put(stones.charAt(i),map.get(stones.charAt(i))+1);
            else  map.put(stones.charAt(i),1);
        }
        int result = 0;
        for(int i=0; i<jewels.length(); i++){
            if(map.containsKey(jewels.charAt(i))) result += map.get(jewels.charAt(i));
        }

    }
}
