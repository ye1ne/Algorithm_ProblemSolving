package Programmers.KAKAO2020RECRUITMENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 외벽점검 {

    public static void main(String[] args) {
        int n = 15;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};
        System.out.println(solution(n,weak,dist));
    }

    static public int solution(int n, int[] weak, int[] dist) {

        int[] arr = new int[n];
        //일단 -1로 다채우기

        isAdded = new boolean[dist.length];

        //일단 사람 콤비네이션 해서 모든가능한 조합 (순서유관) 만들어놓기
        personCombination(dist.length,new int[dist.length],dist.length );

        //모든 사람리스트에 대해서 하나씩 할당하기 시작
        for(int[] peopleList : personCombiList){
            for(int i=0; i< weak.length; i++) {
                weak = shiftArr(weak);
                isCleared = new int[weak.length];
                Arrays.fill(isCleared, -1);
                dfs(0, 0, n, weak, dist, peopleList);
            }
        }

        int answer = MIN;
        return answer;
    }
    static int[] shiftArr(int[] arr){
        int n = arr.length;
        int temp = arr[n-1];
        for(int i=n-1; i>=1; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        return arr;
    }
    static List<int[]> personCombiList = new ArrayList<>();
    static int[] isCleared;
    static int MIN = Integer.MAX_VALUE;
    static void dfs(int count,int peopleNum,int n,int[] weak, int[] dist, int[] peopleList){
        //약점 갯수가 0이면 끝낸다
        if(count == weak.length){
            MIN = Math.min(peopleNum,MIN);
            System.out.println(MIN +" "+ peopleNum);
            return;
        }
        //약점갯수가 0이 아닌데
        //만약 사람이 더 없으면 끝낸다

        //비어있는 약점 자리에 속속 넣는다


        int tmpCount = 0;
        if(isCleared[count] == -1) {
            isCleared[count] = peopleList[peopleNum];
            InnerLoop:
            for(int nextIndex = count; nextIndex< weak.length; nextIndex++){
                if((weak[nextIndex] +n )% n <(weak[count] + dist[peopleList[peopleNum]])%n){
                    isCleared[nextIndex] =  peopleList[peopleNum];
                    tmpCount++;
                }else{
                    break InnerLoop;
                }
            }
            peopleNum++;

            dfs(count+tmpCount, peopleNum,n, weak, dist, peopleList);

        }
    }

    static boolean[] isAdded;
    static void personCombination(int count, int[] num,int totalNum){
        if(count ==0){
            personCombiList.add(Arrays.copyOf(num,totalNum));
            return;
        }

        for(int i=0; i<totalNum; i++){
            if(!isAdded[i]) {
                isAdded[i] = true;
                num[totalNum - count] = i;
                personCombination(count - 1, num, totalNum);
                isAdded[i] = false;
            }
        }
    }


}
