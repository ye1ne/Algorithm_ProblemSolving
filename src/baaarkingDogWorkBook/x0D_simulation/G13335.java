package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G13335 {
    static int n,w,L;
    static int[] array;
    static int[] load;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        array = new int[n];
        load = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int countTime = getCountTime();

        System.out.println(countTime);

    }

    private static int getCountTime() {
        int totalWeight = 0;
        int countTime = 0;
        int curTruck = 0;
        int countTruckOnBridge = 0;
        int lastTruckLocation = 0;
        while((curTruck<=n)){
            if(curTruck==n && countTruckOnBridge!=0){
                countTime += lastTruckLocation+1;
                break;
            }
            int cur = array[curTruck];
            if(load[0] != 0) countTruckOnBridge--;
            lastTruckLocation--;
            totalWeight -= load[0];
            load[0] = 0;
            for(int i =0; i<w-1; i++){
                if(load[i+1]>0){
                    load[i] = load[i+1];
                    load[i+1] = 0;
                }
            }

            if(totalWeight + cur >L){
                lastTruckLocation--;
                countTime++;
            }else{
                load[w-1] = cur;
                lastTruckLocation = w-1;
                countTime++;
                curTruck++;
                totalWeight += cur;
                countTruckOnBridge++;
            }
        }
        return countTime;
    }
}
