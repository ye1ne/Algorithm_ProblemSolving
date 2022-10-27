package Programmers.KAKAO2021RECRUITMENT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 순위검색 {
    public static void main(String[] args) {
        String[] info ={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        solution(info,query);
    }

    static public int[] solution(String[] info, String[] query) {

        String[][] infos = new String[info.length][5];
        for(int i=0; i<info.length; i++){
            String tmp = info[i];
            StringTokenizer st = new StringTokenizer(tmp);
            infos[i][0] = st.nextToken();
            infos[i][1] = st.nextToken();
            infos[i][2] = st.nextToken();
            infos[i][3] = st.nextToken();
            infos[i][4] = st.nextToken();

        }
        Arrays.sort(infos, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])){
                    if(o1[1].equals(o2[1])){
                        if(o1[2].equals(o2[2])){
                            if(o1[3].equals(o2[3])){
                                return o1[4].compareTo(o2[4]);
                            }else return o1[3].compareTo(o2[3]);
                        }else return o1[2].compareTo(o2[2]);
                    }else return o1[1].compareTo(o2[1]);
                }else return o1[0].compareTo(o2[0]);
            }
        });

        int[] answer = new int[query.length];

        for(int i=0; i< query.length; i++) {
            StringTokenizer st = new StringTokenizer(query[i]);
            String lang = st.nextToken(); st.nextToken();
            String tech = st.nextToken();st.nextToken();
            String work = st.nextToken();st.nextToken();
            String food = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int person = 0; person < info.length; person++) {
                if (!infos[person][0].equals(lang) && !lang.equals("-")) continue;
                else {
                    if (!infos[person][1].equals(tech) && !tech.equals("-")) continue;
                    else {
                        if (!infos[person][2].equals(work)&& !work.equals("-")) continue;
                        else {
                            if (!infos[person][3].equals(food)&& !food.equals("-")) continue;
                            else {
                                if (Integer.parseInt(infos[person][4]) >= num) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}

