package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class 후보추천하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int TOTAL = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Vote> votes = new ArrayList<>();


        OUTER_LOOP:
        for (int i = 0; i < TOTAL; i++) {
            int number = Integer.parseInt(st.nextToken());


            int minCount = Integer.MAX_VALUE;
            int location = 0;
            //있으면 업데이트 시키고
            for(int j=0; j<votes.size(); j++){
                Vote vote = votes.get(j);
                if(vote.number == number){
                    vote.count++;
                    continue OUTER_LOOP;
                }

                if(minCount > vote.count){
                    minCount = vote.count;
                    location = j;
                }
            }

            //크기가 넘치면
            if(votes.size() >= N){
                votes.remove(location);
                votes.add(new Vote(number,0,1));
            }else{
                votes.add(new Vote(number,0,1));
            }
        }

        Collections.sort(votes, new Comparator<Vote>() {
            @Override
            public int compare(Vote o1, Vote o2) {
                return o1.number-o2.number;
            }
        });
        for (int i =0; i<votes.size(); i++){
            System.out.print(votes.get(i).number);
            System.out.print(" ");
        }
    }

    static class Vote implements Comparator<Vote> {
        int count;
        int number;
        int time;

        public Vote(int number, int time, int count) {
            this.count = count;
            this.time = time;
            this.number = number;
        }


        @Override
        public int compare(Vote o1, Vote o2) {
            if (o1.count == o2.count) {
                return o1.time - o2.time;
            }
            return o1.count - o2.count;
        }
    }

}
