package Programmers.KAKAO2021RECRUITMENT;

import java.util.*;

public class 광고삽입3 {

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
        int[] countWatching = new int[playTime + 1];
        int[] totalCountWatching = new int[playTime + 1];
        if (playTime == advTime) return "00:00:00";

        List<int[]> list = new ArrayList<>();

        int[][] times = new int[logs.length][2];
        //각시청시간에 대해
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            StringTokenizer st = new StringTokenizer(log, "-");
            int startTime = stringToTimestamp(st.nextToken());
            int endTime = stringToTimestamp(st.nextToken());

            times[i][0] = startTime;
            times[i][1] = endTime;
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int min = 0;
        int max = playTime;
        for (int i = 0; i < times.length; i++) {
            int start = times[i][0];
            int end = times[i][1];
            for (int time = start; time <= end; time++) {
                countWatching[time]++;
            }
//            min = Math.min(min, start);
//            max = Math.max(max, end);
//            if(!list.isEmpty()){
//                int[] tmp = list.get(list.size()-1);
//                if(tmp[1] >= times[i][0]){
//                    list.get(list.size()-1)[1] = Math.max( list.get(list.size()-1)[1] , times[i][1]);
//                }else{
//                    list.add(new int[]{times[i][0],times[i][1]});
//                }
//            }else{
//                list.add(new int[]{times[i][0],times[i][1]});
//            }
        }


        for (int i = min; i <= max; i++) {
            if (i == 0) totalCountWatching[i] = countWatching[i];
            else totalCountWatching[i] = totalCountWatching[i - 1] + countWatching[i];
        }


        //min =1 max =5 adv = 3
        int MAX = Integer.MIN_VALUE;
        int MAXIndex = 0;
        for (int i = advTime + min; i <= max; i++) {
            if (totalCountWatching[i] - totalCountWatching[i - advTime] > MAX) {
                MAX = totalCountWatching[i] - totalCountWatching[i - advTime];
                MAXIndex = i - advTime+1;
            }
        }

//        if(adv_time.equals("25:00:00")){
//
//            int[] arr = Arrays.copyOfRange(totalCountWatching,3599,3699);
//            int[] arr2 = Arrays.copyOfRange(totalCountWatching,93599,93699);
//            System.out.println();
//        }
        String answer = timestampToString(MAXIndex);
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