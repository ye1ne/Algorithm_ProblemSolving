package BJ_SET;

import java.io.*;
import java.util.*;

public class G22252 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int Q,k,b;
    static long info;
    static String index,name;
    static List<Integer> list;

    static Map<String, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        info = (long)0;
        Q = Integer.parseInt(br.readLine());

        while(Q-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            index = st.nextToken();
            name = st.nextToken();

            if(index.equals("1")){
                k = Integer.parseInt(st.nextToken());

                if(map.containsKey(name))   list = map.get(name);
                else    list = new ArrayList<>();


                while (k-->0){
                    list.add(Integer.parseInt(st.nextToken()));
                }
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
                map.put(name,list);
            }else{
                if(!map.containsKey(name)) continue;
                b = Integer.parseInt(st.nextToken());
                list = map.get(name);
                InnerLoop:
                while(b-->0){
                    if(list.isEmpty()) break InnerLoop;
                    info += list.get(0);
                    list.remove(0);
                }

            }

        }
        System.out.println(info);

    }
}
