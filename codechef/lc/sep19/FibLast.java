package lc.sep19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibLast {
//    public static final double LOG_2 = Math.log(2.0);

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        int[] fib = new int[60];
        computeFib(fib);
//        System.out.println(Arrays.toString(fib));

        while(t-- > 0) {
            long num = Long.parseLong(br.readLine());
//            int p = (int)(Math.log(num) / Math.log(2));
            int bits = 0;
            while ((num>>=1) > 0) {
                bits++;
            }
//            System.out.println(bits);
            double res = Math.pow(2, bits);
            System.out.println(fib[(int)(res%60 - 1)]);
        }
    }

    private static void computeFib(int[] fib) {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % 10;
        }
    }
}
