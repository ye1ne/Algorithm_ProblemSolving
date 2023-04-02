package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 카드섞기 {
    /**
     * 카드를 섞을때마다, 몇번째에 있는 카드가 몇번째로 이동함
     */
    static int[] sortRule;
    static int[][] curCard;
    static int[] resultCard;

    static int count, N;

    static Set<String> cardLog = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sortRule = new int[N];
        curCard = new int[2][N];
        resultCard = new int[N];
        for (int i = 0; i < N; i++) {
            curCard[1][i] = i % 3;
            curCard[0][i] = i;
        }
        cardLog = new HashSet<>();
        count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            resultCard[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sortRule[i] = Integer.parseInt(st.nextToken());
        }

        while (!isSame(curCard[1], resultCard)) {
            shuffleCard();
            count++;
            if (cardLog.contains(Arrays.toString(curCard[1]))) {
                count = -1;
                break;
            }
            cardLog.add(Arrays.toString(curCard[1]));
        }
        System.out.println(count);
    }

    private static void shuffleCard() {
        int[][] newCard = new int[2][N];
        for (int i = 0; i < N; i++) {
            newCard[0][i] = curCard[0][i];
            int tmpCard =curCard[1][sortRule[i]];
            newCard[1][i] = curCard[1][sortRule[i]];
        }
        curCard = newCard;
    }

    private static boolean isSame(int[] curCard, int[] resultCard) {
        for (int i = 0; i < N; i++) {
            if (curCard[i] != resultCard[i])
                return false;
        }
        return true;
    }
}
