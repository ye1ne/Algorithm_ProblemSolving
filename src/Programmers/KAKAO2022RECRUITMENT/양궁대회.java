package Programmers.KAKAO2022RECRUITMENT;

import java.util.Arrays;

public class 양궁대회 {
    public static void main(String[] args) {
        int n =10;
        int[] info = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        solution(n,info);
    }


    static public int[] solution(int n, int[] info) {
        N = n;
        gapMax = 1;
        infos = info;
        result = new int[]{-1};
        solved(0,n,0,0,new int[11]);
        return result;
    }

    static int gapMax;
    static int apeach;
    static int N;
    public static int[] result;
    static int[] infos;

    static void solved(int count, int leave, int rianTotal, int apeachTotal,int[] arr){
        if(count == 11){
            System.out.println(Arrays.toString(arr));
            System.out.println(apeachTotal+" "+ rianTotal);
            if(gapMax < rianTotal-apeachTotal){
                result = arr.clone();
                gapMax = rianTotal-apeachTotal;
                apeach = apeachTotal;
                System.out.println(Arrays.toString(result));
                System.out.println(apeachTotal+" "+ rianTotal);
//                if(Arrays.toString(result).equals("[0, 2, 0, 0, 1, 1, 1, 0, 0, 0, 0]"))
//                    System.out.println();

            }else if(gapMax == rianTotal-apeachTotal){
                result = findMinArr(arr,result).clone();
//                System.out.println(Arrays.toString(result));
//                if(Arrays.toString(result).equals("[0, 2, 0, 0, 1, 1, 1, 0, 0, 0, 0]"))
//                    System.out.println();
            }
            return;
        }
        if(leave == 0){
            arr[count] = 0;
            System.out.println(Arrays.toString(infos)+" "+apeachTotal+" "+rianTotal);
            if(infos[count] == 0) solved(count+1,leave,rianTotal,apeachTotal,arr);
            else solved(count+1,leave,rianTotal,apeachTotal+(10-count+1),arr);
        }else{
            //이겼을때
            if(leave>infos[count]){
                if(count ==10) arr[count] = leave;
                else arr[count] = infos[count]+1;
                solved(count+1,leave-(infos[count]+1),rianTotal +(10-count+1),apeachTotal,arr);
            }
            //졌을때
            if(count ==10) arr[count] = leave;
            else arr[count] = 0;
            if(infos[count] == 0) solved(count+1,leave,rianTotal,apeachTotal,arr);
            else solved(count+1,leave,rianTotal,apeachTotal+(10-count+1),arr);
        }

    }

    static int[] findMinArr(int[] arr1, int[] arr2){
        for(int i =10; i>=0; i--){
            if(arr1[i] > arr2[i]) return arr1;
            else return arr2;
        }
        return arr1;
    }

}

