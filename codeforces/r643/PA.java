package r643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        // StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            String[] in = br.readLine().split(" ");
            long a = Long.parseLong(in[0]);
            long b = Long.parseLong(in[1]);

            long x = b, tmp = -1;
            int min, max, r;
            while (x != 1) {

                long k = a;
                min = 10; max = -1;
                while (k != 0) {
                    r = (int) (k % 10);

                    if (r > max) max = r;
                    if (r < min) min = r;

                    k /= 10;
                }

                a += (max * min);
                if (min == 0) break;
                --x;
            }

            System.out.println(a);
        }
    }
}
