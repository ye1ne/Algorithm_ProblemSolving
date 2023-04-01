package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 랜선자르기 {

    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        list = new ArrayList<>();
        long max = 0;

        for (int i = 0; i < N; i++) {
            long size =Long.parseLong(br.readLine());
            list.add(size);
            max = Math.max(max, size);
        }

        max++;
        long min = 0;
        while (min < max) {

            //하나더 적게 할당해줌
            long mid = (min + max) / 2;
            long count = countLAN(mid);
            //만약, LAN 의 갯수가 더 많으면
            if (count >= K) {
                min = mid +1 ;
            } else {
                max = mid;
            }
        }
        System.out.println(min - 1);
    }

    private static int countLAN(long size) {
        int total = 0;
        for (long lan : list) {
            total += (lan / size);
        }
        return total;
    }


}
