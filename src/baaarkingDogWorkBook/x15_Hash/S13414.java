package baaarkingDogWorkBook.x15_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String,Integer> list = new HashMap<>();
        for(int i=0; i<L; i++) list.put(br.readLine(),i);

        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(list.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for(Map.Entry<String, Integer> tmp : entryList){
            if(K--==0) return;
            System.out.println(tmp.getKey());
        }

    }
}
