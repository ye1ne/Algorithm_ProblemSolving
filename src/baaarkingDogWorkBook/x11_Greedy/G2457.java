package baaarkingDogWorkBook.x11_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G2457 {
    static int N;
    static int[][] date;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        date = new int[N][4];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            date[i][0]= Integer.parseInt(st.nextToken());
            date[i][1]= Integer.parseInt(st.nextToken());
            date[i][2]= Integer.parseInt(st.nextToken());
            date[i][3]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(date, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]){
                        if(o1[2] == o2[2]){
                            return o1[3]-o1[3];
                        }else return o1[2]-o2[2];
                    }else return o1[1]-o2[1];
                }else return o1[0]-o2[0];
            }
        });
        int count = 0;
        int month = 3;
        int day = 1;
        int selectDate = 0;
        //기준날이 11.30 이전이면 계속한다
        while(!isAfter(11,31,month,day)){
            int maxMonth = 1;
            int maxDay = 1;
            boolean isSelected = false;
            while(selectDate<N && isAfter(date[selectDate][0],date[selectDate][1],month,day)){
               if(isAfter(maxMonth,maxDay,date[selectDate][2],date[selectDate][3])){
                   maxMonth = date[selectDate][2];
                   maxDay = date[selectDate][3];
                }
                selectDate++;
            }
            if(maxMonth == 1 && maxDay == 1 && !isSelected) {
                count = 0;
                break;
            }
            month =maxMonth;
            day = maxDay;
            count++;
        }
        System.out.println(count);

    }

    static boolean isAfter(int month, int day, int newMonth, int newDay){
        if(month < newMonth) {
            return true;
        }else if(month == newMonth){
            if(day <= newDay)
                return true;
            else return false;
        }else{
            return false;
        }
    }

}
