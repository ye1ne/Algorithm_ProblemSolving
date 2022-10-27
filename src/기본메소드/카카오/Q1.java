package 기본메소드.카카오;


import java.util.*;

public class Q1 {
    public static void main(String[] args) {

//        String today = "2022.05.19";
//        String[] terms = {"A 6","B 12", "C 3"};
//        String[] p = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C","2022.02.20 C"};
        String today = "2021.01.01";
        String[] terms = {"Z 13"};
        String[] p = {"2019.11.01 Z"};
        solution(today,terms,p);
    }

    //14번 17번
    static int[] solution(String today, String[] terms, String[] privacies) {

        Map<String,Integer> map = new HashMap<>();
        for(String term : terms){
            StringTokenizer st = new StringTokenizer(term);
            String name = st.nextToken();
            String month = st.nextToken();
            map.put(name,Integer.parseInt(month));
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            String privacy = privacies[i];

            StringTokenizer st = new StringTokenizer(privacy);
            String inDay = st.nextToken();
            String name = st.nextToken();


            if(i==0)
                System.out.println();
            int month = map.get(name);
            String destructionDay = addMonth(inDay,month);
            if(i==0)
                System.out.println();


            int between = dayBetweenTwo(destructionDay,today);
            if(between<=0){
                list.add(i+1);
            }

            if(i==0)
                System.out.println();

        }
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    static String addMonth(String str1,int month){
        StringTokenizer st = new StringTokenizer(str1,".");
        int year1 = Integer.parseInt(st.nextToken());
        int month1  = Integer.parseInt(st.nextToken());
        int day1 = Integer.parseInt(st.nextToken());


        if(month1+month>12){
            if((month1+month)%12 == 0){
                year1 += (month1+month)/12 -1;
                month1 = 12;

            }else {
                year1 += (month1 + month) / 12;
                month1 = (month1 + month) % 12;
            }
        }else{
            month1 = month1+month;
        }
        return year1+"."+month1+"."+day1;

    }
    static int dayBetweenTwo(String str1, String str2) {
        StringTokenizer st = new StringTokenizer(str1,".");
        int year1 = Integer.parseInt(st.nextToken());
        int month1  = Integer.parseInt(st.nextToken());
        int day1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(str2,".");
        int year2 = Integer.parseInt(st.nextToken());
        int month2 = Integer.parseInt(st.nextToken());
        int day2 = Integer.parseInt(st.nextToken());

        if(year1 == year2){
            if(month1 == month2){
                return day1-day2;
            }else{
                return month1 -month2;
            }
        }else{
            return year1-year2;
        }
    }

}
