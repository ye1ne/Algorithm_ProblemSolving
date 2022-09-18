package leetcode.ch5_알고리즘;

import java.util.*;

public class A79_406_키에따른대기열재구성 {
    public static void main(String[] args) {

        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
    }
    static public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });

        List<int[]> result = new LinkedList<>();
        for(int i=0; i<people.length; i++){
            int index = people[i][1];

            if(index >result.size()) result.add(people[i]);
            else result.add(index,people[i]);

        }
        int[][] result2 = new int[result.size()][];
        for(int i =0; i<result2.length; i++) result2[i] = result.get(i);
        System.out.println();
        return result2;
    }
}
