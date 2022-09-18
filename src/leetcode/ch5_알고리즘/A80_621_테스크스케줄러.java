package leetcode.ch5_알고리즘;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class A80_621_테스크스케줄러 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        leastInterval(tasks,n);
    }

    static public int leastInterval(char[] tasks, int n) {

        int all[] = new int[26];
        int max = 0;
        int index = 0;
        for(char task: tasks){
            all[task-'A']++;
            if(all[task-'A']>max){
                max = all[task-'A'];
                index = task -'A';
            }
        }
        int plus = 0;
        int idle = (all[index]-1)*n;
         for(int i=0; i<26; i++){
             if(idle == 0) break;
             if(all[i] == 0 || i == index) continue;
             int tmp = Math.min(max-1,all[i]);
             idle-=tmp;
             if(idle <0){
                 plus= Math.abs(idle);
                 break;
             }
         }
        int answer = idle+tasks.length+plus;
        return answer;
    }
}
