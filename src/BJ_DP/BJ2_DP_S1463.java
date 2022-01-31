package BJ_DP;

import java.io.*;


public class BJ2_DP_S1463 {
    static Integer[] find;
    static int recur_find_min(int num){
        if(find[num] == null) {
            if (num % 6 == 0) {
                find[num] = Math.min(recur_find_min(num - 1), Math.min(recur_find_min(num / 2), recur_find_min(num / 3)))+1;
            } else if (num % 3 == 0) {
                find[num] = Math.min(recur_find_min(num - 1), recur_find_min(num / 3))+1;
            } else if (num % 2 == 0) {
                find[num] = Math.min(recur_find_min(num - 1), recur_find_min(num / 2))+1;
            } else {
                find[num] = recur_find_min(num - 1)+1;
            }
        }
        return find[num];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        find = new Integer[(num + 1)];
        find[0] = find[1] = 0;
        System.out.println(recur_find_min(num));

    }

}

/**
 *
 *         for(int i = 4; i<=num; i++){
 *             if(i%2==0 && i%3 ==0){
 *                 int[] tmp = new int[3];
 *                 tmp[0] = find[i-1] +1;
 *                 tmp[1] = find[i/2] +1;
 *                 tmp[2] = find[i/3] +1;
 *                 find[i] = Arrays.stream(tmp).min().getAsInt();
 *             }else if (i%3==0 &&!(i%2 ==0)){
 *                 int[] tmp = new int[2];
 *                 tmp[0] = find[i-1] +1;
 *                 tmp[1] = find[i/3] +1;
 *                 find[i] = Arrays.stream(tmp).min().getAsInt();
 *
 *             }else if (i%2==0 &&!(i%3 ==0)){
 *                 int[] tmp = new int[2];
 *                 tmp[0] = find[i-1] +1;
 *                 tmp[1] = find[i/2] +1;
 *                 find[i] = Arrays.stream(tmp).min().getAsInt();
 *
 *             }else{
 *                 find[i] = find[i-1] +1;
 *             }
 */