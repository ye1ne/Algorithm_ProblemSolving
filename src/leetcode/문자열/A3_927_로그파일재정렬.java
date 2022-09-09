package leetcode.문자열;

import java.util.*;

public class A3_927_로그파일재정렬 {
    public static void main(String[] args) {
        String[] logs =
                {"u 4374249", "q 2066 2 6", "fz tgthz w", "j 31227 50", "lm 91 25 6", "ow uhjqes", "v jmkmsi b", "0 amxan w", "0y q wssft", "d ekx ls d"};

        List<String> digLogs = new ArrayList<>();
        List<String> letLogs = new ArrayList<>();

        for(int i=0; i<logs.length; i++){
            StringTokenizer st = new StringTokenizer(logs[i]);
            st.nextToken(); String log = st.nextToken();
            if(log.charAt(0)>='0' && log.charAt(0)<='9') digLogs.add(logs[i]);
            else {letLogs.add(logs[i]);}
        }
        StringTokenizer st = new StringTokenizer(logs[0]);
        String index = st.nextToken();

        Collections.sort(letLogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringTokenizer st = new StringTokenizer(o1);
                String index1 = st.nextToken();
                st = new StringTokenizer(o2);
                String index2 = st.nextToken();
                String tmpO1 = o1.substring(index1.length()+1);
                String tmpO2 = o2.substring(index2.length()+1);
                if(tmpO1.equals(tmpO2)) return o1.substring(0,index.length()).compareTo(o2.substring(0,index.length()));
                return tmpO1.compareTo(tmpO2);

            }
        });

        letLogs.addAll(letLogs.size(),digLogs);

        String[] answer = letLogs.toArray(new String[letLogs.size()]);
        System.out.println(Arrays.toString(answer));
    }
}
