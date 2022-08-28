package Programmers.KAKAO2022RECRUITMENT;

import java.util.*;

public class ParkingFeeCalculation {

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(Solution.solution(fees,records)));
    }
}

class Solution {
    static Integer[][] data;
    final static int IN= 1;
    final static int OUT = 0;
    static class Info implements Comparable<Info> {
        Integer num, totalTime;
        Info(int num, int totalTime){
            this.num = num;
            this.totalTime = totalTime;
        }
        @Override
        public int compareTo(Info o) {
            return num - o.num;
        }
    }
    static List<Info> result;

    public static int[] solution(int[] fees, String[] records) {

        result = new ArrayList();
        int totalLineNum = records.length;
        data = new Integer[totalLineNum][3];

        for(int i=0; i<totalLineNum; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            String str = st.nextToken();
            data[i][1]= Integer.parseInt(st.nextToken());
            if(st.nextToken().equals("IN")){
                data[i][2] = IN;
            }else
                data[i][2] = OUT;

            st = new StringTokenizer(str,":");
            data[i][0] = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());

        }
        Stack<Integer[]> s1= new Stack();
        Stack<Integer[]> s2= new Stack();
        for(int i=totalLineNum-1; i>=0; i--){
            s1.push(data[i]);
        }
        while(!s1.isEmpty()){

            Integer[] now = s1.pop();
            Integer carNum = now[1];
            boolean isFind = false;
            InnerLoop:
            while(!isFind && !s1.isEmpty()){
                Integer[] tmp = s1.pop();

                if(tmp[1].equals(carNum)){
                    isFind = true;
                    while(!s2.isEmpty()){
                        Integer[] move = s2.pop();
                        s1.push(move);
                    }
                    insertData(carNum,tmp[0]-now[0]);
                }else{
                    s2.push(tmp);
                }
            }
            if(!isFind){
                Integer[] lastOut = {23*60+59,now[1],OUT};
                insertData(carNum,lastOut[0]-now[0]);
            }
            while(!s2.isEmpty()){
                Integer[] move = s2.pop();
                s1.push(move);
            }
        }
        Collections.sort(result);
        int[] answer = new int[result.size()];
        int count =0;
        for(Info info: result){
            answer[count] = calculationFee(fees,info.totalTime);
            count++;
        }
        return answer;
    }
    static int calculationFee(int[] fees, int totalTime){

        if(totalTime<=fees[0]){
            return fees[1];
        }

        totalTime -= fees[0];

        if(totalTime%fees[2] == 0){
            return (fees[1] + (totalTime/fees[2])*fees[3]);
        }else{
            return (fees[1] + (totalTime/fees[2] +1)*fees[3]);
        }
    }
    static void insertData(Integer num, Integer totalTime){

        boolean hasNum = false;
        for (Info info : result) {
            if (info.num.equals(num)) {
                info.totalTime += totalTime;
                return;
            }
        }
        Info info = new Info(num,totalTime);
        result.add(info);
        return;
    }

}
