package r642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();


        while (t-- > 0) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);

            if ( n <= 2 ) {
                if (n == 1) ans.append("0\n");
                else ans.append(m + "\n");
            } else {

                int r = (m / n);
                int e = m % n;

                int t1 = (n - 2) / 2;
                int tmp = t1 * 2;


                long a = tmp * 3 * r;
                if (n % 2 == 0) {
                    a +=  2 * (2 *r + e) + r;
                } else {
                    a += (m - a) * 2;
                }


                ans.append(a + "\n");
            }
        }
        System.out.print(ans);
    }
}
