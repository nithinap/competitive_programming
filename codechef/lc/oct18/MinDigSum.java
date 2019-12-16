package lc.oct18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinDigSum {

    public static void main(String[] args) throws IOException {
        int t;
        long n, d;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nd = br.readLine().split(" ");
            n = Integer.parseInt(nd[0]);
            d = Integer.parseInt(nd[1]);
            int min = 0, minStep = 0;

//            if (n == 1) {
//                min = (int) n;
//                System.out.println(min + " " + minStep);
//            } else {
                computeSteps(n, d);
//            }
        }
    }

    private static void computeSteps(long n, long d) {
        long[] steps = new long[10];
        boolean[] found = new boolean[10];
        long min = 0, minStep = 0, moves = 0;
        for (int i = 0; i < 10; i++)
            steps[i] = Long.MIN_VALUE;

        while (true) {
            if (n < 10) {
                found[(int) n] = true;
                steps[(int) n] = moves;
                moves++;
                n += d;
            } else {
                long num = n, s = 0;
                while (num > 9) {
                    num = digitSum(num);
                    s++;
                }

                if (num == 1) {
                    // we are done here
                    min = 1;
                    if (steps[(int) num] != Long.MIN_VALUE && (steps[(int) num] < moves + s)) {
                        minStep = steps[(int) num];
                    } else {
                        minStep = moves + s;
                    }
                    break;
                } else {
                    if (!found[(int) num]) {
                        found[(int) num] = true;
                        steps[(int) num] = moves + s;
                        moves++;
                        n += d;
                    } else {
                        for (int i = 1; i < 10; i++) {
                            if (min == 0 && found[i]) {
                                min = i;
                                break;
                            }
                        }
                        minStep = steps[(int) min];
                        break;
                    }
                }
            }
        }
        System.out.println(min + " " + minStep);
    }

    private static long digitSum(long num) {
        long res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
