package 파이썬알고리즘.그래프_12장;

import java.util.*;

public class 일정재구성_332 {
    public static void main(String[] args) {
        Map<String,PriorityQueue<String>> map = new HashMap<>();

        Solution2 solution2 = new Solution2();

        List<List<String>> tickets = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("JFK");
        l1.add("KUL");
        List<String> l2 = new ArrayList<>();
        l2.add("JFK");
        l2.add("NRT");
        List<String> l3 = new ArrayList<>();
        l3.add("NRT");
        l3.add("JFK");

        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);

        solution2.findItinerary(tickets);
    }
}

class Solution2 {

    static Map<String,List<String>> map;
    static final String start = "JFK";
    static List<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new ArrayList<>();
        map = new HashMap<>();
        List<String> nations = new ArrayList<>();
        for( List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(map.containsKey(from)){
                List<String> tmp = map.get(from);
                tmp.add(to);
                map.put(from, tmp);
            }else{
                List<String> tmp = new ArrayList<>();
                tmp.add(to);
                map.put(from, tmp);
                nations.add(from);
            }
        }
        for(String nation : nations){
            List<String> tmp = map.get(nation);
            Collections.sort(tmp);
            map.put(nation, tmp);
        }

        dfs(start);

        return result;
    }

    public void dfs(String from){
        if(map.get(from) == null || map.get(from).size() == 0){
            result.add(from);
            return;
        }
        result.add(from);
        List<String> nationList = map.get(from);
        List<String> tmpNationList = new ArrayList<>(nationList);
        for(String nation : tmpNationList){
            nationList.remove(nation);
            map.put(from, nationList);
            if(!result.contains(nation)) {
                dfs(nation);
            }
        }
    }
}
