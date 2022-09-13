package Programmers.KAKAO2022RECRUITMENT;

import java.util.*;

public class 주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitFee = fees[3];
        int unitTime = fees[2];
        Map<Integer,Integer> list = new HashMap<>();
        Map<Integer,Integer> totalFee = new HashMap<>();

        for(int i=0; i<records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            int time = strToTime(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            String flag = st.nextToken();

            if(flag.equals("IN")){
                list.put(number,time);
            }else{

                int inTime = list.get(number);
                int totalTime = time-inTime;

                list.remove(number);
                if(totalFee.containsKey(number)) totalFee.put(number,totalFee.get(number)+totalTime);
                else totalFee.put(number,totalTime);
                System.out.println(number +" "+totalTime);
            }

        }

        if(!list.isEmpty()){
            List<Integer> keyList = new ArrayList<>(list.keySet());
            List<Integer> valueList = new ArrayList<>(list.values());
            int time = 60*23 +59;
            for(int i =0; i<keyList.size(); i++){
                int inTime = valueList.get(i);
                int totalTime = time-inTime;

                if(totalFee.containsKey(keyList.get(i))) totalFee.put(keyList.get(i),totalFee.get(keyList.get(i))+totalTime);
                else totalFee.put(keyList.get(i),totalTime);
                System.out.println(keyList.get(i) +" "+totalTime);
            }
        }


        List<Integer> numberList = new ArrayList<>(totalFee.keySet());
        int[][] results = new int[numberList.size()][2];
        List<Integer> timeList = new ArrayList<>(totalFee.values());

        for(int i =0; i<numberList.size(); i++){
            int number = numberList.get(i);
            int totalTime = timeList.get(i);

            int fee = 0;
            if(totalTime>basicTime){
                fee = basicFee;
                if(((totalTime-basicTime)%unitTime) == 0) fee += ((totalTime-basicTime)/unitTime)*unitFee;
                else fee += ((totalTime-basicTime)/unitTime +1)*unitFee;
            }else {
                fee = basicFee;
            }

            results[i][0] = number;
            results[i][1] = fee;

        }


        Arrays.sort(results, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] result = new int[numberList.size()];

        for(int i=0; i<results.length; i++){
            result[i] = results[i][1];
        }
        System.out.println();

    }

    static int strToTime(String time){
        StringTokenizer st = new StringTokenizer(time,":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        return hour*60 +minute;
    }
}
