package Programmers.practice.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[1] == o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        }
    });

    public static int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int answer =0;
        int end =0;
        int jobsIndex = 0;
        int batched = 0;

        while(batched < jobs.length){
            //끝나는 시간이전에 시작되는 jobd을 큐에 넣는다
            while(jobsIndex <jobs.length && jobs[jobsIndex][0]<=end){
                pq.add(jobs[jobsIndex++]);
            }

            //만약에 pq가 비어있으면
            if(pq.isEmpty()){
                //현재 시간을 다음 순서의 시작으로 변경하고 위의 로직이 실행되도록 넘긴다
                end = jobs[jobsIndex][0];
            }else{
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                batched++;
            }
        }

        return answer/jobs.length;
    }


}