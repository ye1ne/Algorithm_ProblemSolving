package Programmers.KAKAO2019인턴;

import java.util.*;

public class 불량사용자 {
    public static void main(String[] args) {
        String[] user_id = {"aac","aad","b","c"};

        String[] banned_id = {"aa*","*"};
        System.out.println(solution(user_id,banned_id));
    }


    static int answer;
    public static int solution(String[] user_id, String[] banned_id) {

        List<String>[] blackUserCount = new List[banned_id.length];
        for(int source =0; source<banned_id.length; source++) {
            blackUserCount[source] = new ArrayList<>();
            for (int target = 0; target < user_id.length; target++) {
                if(isBlackUser(banned_id[source],user_id[target])) blackUserCount[source].add(user_id[target]);
            }
        }

        answer = 0;
        backTracking(new HashSet<String>(),0, blackUserCount);

        return answer;
    }

    static Set<Set<String>> permutation = new HashSet<>();

    private static void backTracking(HashSet<String> set, int count, List<String>[] blackUserCount) {
        if(count == blackUserCount.length){
            if(permutation.contains(set)) return;
            answer++;
//            System.out.println(set.toString());
            Set<String> inputSet = new HashSet<>();
            for (String input : set) inputSet.add(input);
            permutation.add(inputSet);
            return;
        }
        for(int i=0; i<blackUserCount[count].size(); i++){
            String user = blackUserCount[count].get(i);
            if(!set.contains(user)){
                set.add(user);
                backTracking(set,count+1,blackUserCount);
                set.remove(user);
            }
        }
    }


    public static boolean isBlackUser(String sourceUser, String targetUser){
        if(sourceUser.length() != targetUser.length()) return false;
        for(int c=0; c<sourceUser.length(); c++){
            if(sourceUser.charAt(c) == '*') continue;
            if(sourceUser.charAt(c) != targetUser.charAt(c)) return false;
        }

        return true;
    }
}
