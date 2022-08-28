package baaarkingDogWorkBook.x0D_simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G15686 {
    static int N, M, MIN;
    static int[][] map = new int[51][51];
    static List<Integer[]> chickenHouse = new ArrayList<>();
    static boolean[] isSelected;
    static final int chicken = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MIN = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==chicken) chickenHouse.add(new Integer[]{i,j}); //치킨 집이면 치킨집 리스트에 삽입
            }
        }
        isSelected = new boolean[chickenHouse.size()];
        selectChickenHouse(0,0);
        System.out.println(MIN);
    }
    static void selectChickenHouse(int count,int start){
        if(count == M){
            //총 치킨 거리 계산
            int sum = calculateLength();
            MIN = Math.min(MIN,sum);
            return;

        }

        for(int i= start; i<chickenHouse.size(); i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            selectChickenHouse(count+1,i+1);
            isSelected[i] = false;

        }
    }

    private static int calculateLength() {
        int totalLength = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1) {
                    int minChickenLength = 101;
                    for (int k = 0; k < chickenHouse.size(); k++) {
                        if (isSelected[k]) {
                            minChickenLength = Math.min(minChickenLength, Math.abs(chickenHouse.get(k)[0] - i) + Math.abs(chickenHouse.get(k)[1] - j));
                        }
                    }
                    totalLength += minChickenLength;
                }
            }
        }
        return totalLength;
    }
}
