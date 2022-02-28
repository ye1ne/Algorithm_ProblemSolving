package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G21924 {

    static class Node{
        int from, to, w;
        public Node(int from, int to ,int w){
            this.from = from;
            this. to = to;
            this.w= w;
        }
    }
    static ArrayList<Node>[]  list;
    static int N;
    static int M;
    static boolean[] isSelect;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSelect = new boolean[N + 1];
        list = new ArrayList[N + 1];

        long sum = 0;
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[n1].add(new Node(n1, n2, w));
            list[n2].add(new Node(n2, n1, w));
            sum += w;
        }
        Node min = new Node(100_000, 100_000, 1_000_000);
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i], new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.w - o2.w;
                }
            });
            if (list[i].get(0).w < min.w) {
                min = list[i].get(0);
            }
        }

        isSelect[min.from] = true;
        isSelect[min.to] = true;
        long count = min.w;
        int selectNum = 2;
        boolean noLink = true;

        while (selectNum < N) {
            noLink = true;
            min = new Node(100_000, 100_000, 1_000_000);
            for (int i = 1; i <= N; i++) {
                if (isSelect[i]) {
                    InnerLoop:
                    for (Node node : list[i]) {
                        if (!isSelect[node.to]) {
                            if (min.w > node.w) {
                                min = node;
                                noLink = false;
                            }
                            break InnerLoop;
                        }
                    }
                }
            }
            if (!noLink) {
                isSelect[min.to] = true;
                isSelect[min.from] = true;
                count += min.w;
                selectNum++;
            } else {
                break;
            }

        }
        if (noLink) System.out.println(-1);
        else System.out.println(sum - count);
    }
}
