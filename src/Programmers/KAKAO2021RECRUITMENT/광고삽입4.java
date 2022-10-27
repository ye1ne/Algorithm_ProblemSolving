package Programmers.KAKAO2021RECRUITMENT;

import java.util.*;

public class 광고삽입4 {
    public static void main(String[] args) {
        String[] p = {"02:03:55", "99:59:59", "50:00:00"};
        String[] a = {"00:14:15", "25:00:00", "50:00:00"};
        String[][] logs = {
                {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"},
                {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"},
                {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}};
        for (int i = 0; i < 3; i++) {
            System.out.println(solution(p[i], a[i], logs[i]));
        }
    }

    static public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = stringToTimestamp(play_time);
        int advTime = stringToTimestamp(adv_time);

        int[] totalCountWatching = new int[playTime + 1];

        if (play_time == adv_time) return "00:00:00";

        int[] start_sec = new int[logs.length];
        int[] end_sec = new int[logs.length];

        //일단 모든 시작이랑 끝나는 시간을 바탕으로 해당 시간대의 합을 구해놓는다
        for(int i=0; i<logs.length; i++) {
            StringTokenizer st = new StringTokenizer(logs[i],"-");
            start_sec[i] = stringToTimestamp(st.nextToken());
            end_sec[i] = stringToTimestamp(st.nextToken());
            for(int time=start_sec[i]; time <end_sec[i]; time++){
                totalCountWatching[time]++;
            }
        }

        int result = 0;
        long max = 0;
        //현재의 max값은 초기 1부터 advTime가 합이다
         for(int i=1; i<advTime; i++){
             max += totalCountWatching[i];
         }

         long now = max;
         //그다음부터, 하나를 제외시키고 합치는 방식으로 모든 합을 구해내면 오케
         for(int i=0,j=advTime; j<playTime; i++,j++){
            now = now-totalCountWatching[i] +totalCountWatching[j];
            if(now>max){
                result = i+1;
                max= now;
            }
         }


        String answer = timestampToString(result);
        return answer;
    }

    static int stringToTimestamp(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        return hour * 60 * 60 + minute * 60 + second;
    }

    static String timestampToString(int timestamp) {
        String result = "";

        int hour = timestamp / 3600;
        if (hour < 10) result += "0";
        result += Integer.toString(hour) + ":";

        int minute = (timestamp % 3600) / 60;
        if (minute < 10) result += "0";
        result += Integer.toString(minute) + ":";
        int second = (timestamp % 3600) % 60;
        if (second < 10) result += "0";
        result += Integer.toString(second);

        return result;
    }
}