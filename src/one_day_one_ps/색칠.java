package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 색칠 {
    static int W = 0, H = 1, f = 2, c = 3, x1 = 4, y1 = 5, x2 = 6, y2 = 7;
    static long[] inputNumber = new long[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 8; i++) {
            inputNumber[i] = Integer.parseInt(st.nextToken());
        }

        if (inputNumber[W] / 2 < inputNumber[f]) {
            inputNumber[f] = inputNumber[W] - inputNumber[f];
        }

        long right = (inputNumber[x2] - inputNumber[x1]) *
                (inputNumber[y2] - inputNumber[y1]) *
                (inputNumber[c] + 1);

        long left = (inputNumber[f] - inputNumber[x1]) > 0 ?
                ((inputNumber[f] > inputNumber[x2]) ?
                        (inputNumber[x2] - inputNumber[x1]) :
                        (inputNumber[f] - inputNumber[x1])) *
                        (inputNumber[y2] - inputNumber[y1]) *
                        (inputNumber[c] + 1) : 0;

        System.out.println((inputNumber[W] * inputNumber[H]) - right - left);
    }
}
