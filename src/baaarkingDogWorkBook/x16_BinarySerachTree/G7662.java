package baaarkingDogWorkBook.x16_BinarySerachTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class G7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        while(TC-->0){
            int k = Integer.parseInt(br.readLine());
            //앞은 키값, 뒤는 해당 값의 갯수
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            while(k-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char word = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                switch (word){
                    case 'I' :
                        if(treeMap.containsKey(n)) treeMap.put(n,treeMap.get(n)+1);
                        else treeMap.put(n,1);
                        break;
                    case 'D' :
                        if(treeMap.isEmpty()) break;
                        int key = 0;
                        if(n == 1) key = treeMap.lastKey();
                        else key = treeMap.firstKey();

                        if(treeMap.get(key)>1)
                            treeMap.put(key,treeMap.get(key)-1);
                        else treeMap.remove(key);
                        break;

                }

            }


            if(treeMap.isEmpty()) sb.append("EMPTY"+"\n");
            else{
                sb.append(treeMap.lastKey()+" "+treeMap.firstKey()+"\n");
            }
        }
        System.out.println(sb);
    }
}
