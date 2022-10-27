package Programmers.KAKAO2021RECRUITMENT;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 광고삽입 {
    public static void main(String[] args) {
        String[] p = {"02:03:55","99:59:59","50:00:00"};
        String[] a = {"00:14:15","25:00:00","50:00:00"};
        String[][] logs = {
                {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"},
                {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"},
                {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}};
        for (int i=0; i<3 ;i++){
            System.out.println(solution(p[i],a[i],logs[i]));
        }
    }
    static public String solution(String play_time, String adv_time, String[] logs) {

        int playTime = stringToTimestamp(play_time);
        int advTime = stringToTimestamp(adv_time);
        int[] countWatching = new int[playTime+1];
        int[] totalCountWatching = new int[playTime+1];
        if(play_time == adv_time) return "00:00:00";

        //각시청시간에 대해
        for(int i=0; i<logs.length; i++){
            String log = logs[i];
            StringTokenizer st = new StringTokenizer(log,"-");
            int startTime = stringToTimestamp(st.nextToken());
            int endTime = stringToTimestamp(st.nextToken());
            //시청시간 시작부터 끝까지 1씩 더해준다
            for(int time=startTime; time<=endTime; time++){
                countWatching[time]++;
            }
        }



        for(int i =0; i<=playTime; i++){
            if(i == 0) totalCountWatching[i] = countWatching[i];
            else totalCountWatching[i] = totalCountWatching[i-1] +countWatching[i];
        }

        int MAX = Integer.MIN_VALUE;
        int MAXIndex = 0;
        for(int i=advTime; i<=playTime; i++){
            if(i ==advTime){
                MAX = totalCountWatching[i];
                MAXIndex = i;
                continue;
            }
            if(totalCountWatching[i]-totalCountWatching[i-advTime-1] > MAX){
                MAX = totalCountWatching[i]-totalCountWatching[i-advTime-1];
                MAXIndex = i-advTime;
            }
        }

        int[] arr =Arrays.copyOfRange(totalCountWatching,3558,totalCountWatching.length);
        String answer = timestampToString(MAXIndex);
        return answer;
    }
    static int stringToTimestamp(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        return hour*60*60 + minute*60 + second;
    }

    static String timestampToString(int timestamp){
        String result = "";

        int hour = timestamp / 3600;
        if(hour<10) result += "0";
        result += Integer.toString(hour) +":";

        int minute = (timestamp %3600) /60;
        if(minute<10) result += "0";
        result += Integer.toString(minute)+":";
        int second = (timestamp %3600) %60;
        if(second<10) result += "0";
        result += Integer.toString(second);

        return result;
    }
}
