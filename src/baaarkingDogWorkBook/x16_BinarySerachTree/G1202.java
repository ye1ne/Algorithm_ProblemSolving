package baaarkingDogWorkBook.x16_BinarySerachTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //앞에는 가격, 그리고 뒤에는 무게들 list 삽입
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //만약 이미 있는 가격이면
            if(treeMap.containsKey(v)) treeMap.get(v).add(m);
            else treeMap.put(v,new ArrayList<>(Arrays.asList(m)));

        }
        //가방의 최대 무게합들 저장 및 오름차순 정렬
        int[] bagList = new int[K];
        for(int i=0; i<K; i++) bagList[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bagList);

        List<Map.Entry<Integer, List<Integer>>> list = new LinkedList<>(treeMap.entrySet());
        List<boolean[]> isSum = new ArrayList<>();
        //value값 다 정렬하고, 똑같은 모양 sum 만듬
        for(int j=0; j<list.size(); j++){
            List<Integer> tmpList = list.get(j).getValue();
            Collections.sort(tmpList,Comparator.reverseOrder());
            list.set(j,Map.entry(list.get(j).getKey(),tmpList));
            isSum.add(new boolean[list.get(j).getValue().size()]);

        }

        long totalValue =0;
        //제일 작은 크기의 가방처럼
        for(int i =0; i<K; i++){
            int bagWeight = bagList[i];

            Loop:
            //각 보석의 무게에 따라 확인
            for(int j=list.size()-1; j>=0; j--){

                //해당 보석 무게에 해당하는 가방들 전부 끄집어내서
                for(int k =0; k< list.get(j).getValue().size(); k++){
                    //만약 가방무게보다 보석무게가 작으면
                    if(list.get(j).getValue().get(k) <= bagWeight && !isSum.get(j)[k]){
                        totalValue+= list.get(j).getKey();
                        list.get(j).getValue().remove(k);
                        break Loop;
                    }
                }
            }

        }
        System.out.println(totalValue);
    }
}
