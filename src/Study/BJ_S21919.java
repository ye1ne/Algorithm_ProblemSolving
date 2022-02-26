package Study;

import java.io.*;
import java.util.*;

public class BJ_S21919 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        boolean isDec = true;
        int countDec = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        ArrayList<Boolean> Eratos = new ArrayList<>(A[N-1]+1);
        Eratos.add(false);
        Eratos.add(false);
        for(int i=2; i<=A[N-1]; i++) Eratos.add(i, true);
        for(int i=2; (i*i)<=A[N-1]; i++){
            if(Eratos.get(i)){
                for(int j = i*i; j<=A[N-1]; j+=i)
                    Eratos.set(j, false);
            }
        }

        for(int i =0; i<N; i++){
            if(i>=1 && A[i] == A[i-1]){
                continue;
            }
            if(Eratos.get(A[i])){
                countDec++;
                list.add(A[i]);
            }
        }
        if(countDec == 0){
            System.out.println(-1);
        }else {
            long result = list.get(0);
            for (int i = 1; i < countDec; i++) {
                result *= list.get(i);

            }
            System.out.println(result);
        }
    }
}
