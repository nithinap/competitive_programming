package lc.oct18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinDigsum2 {
    private static long digitSum(long num) {
        long res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int t;
        long n, d;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nd = br.readLine().split(" ");
            n = Integer.parseInt(nd[0]);
            d = Integer.parseInt(nd[1]);
            int min = 0, steps = 0;
            int[] minStep = new int[10];
            Arrays.fill(minStep, -1);

            if (n < 10) {
                while(n< 10) {
                    n += d;
                }
            }

        }
    }
}
