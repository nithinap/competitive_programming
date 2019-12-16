package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heat {
    public static void main(String[] args) throws IOException {
        int t = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int c, sum;
            String[] cs = br.readLine().split(" ");
            c = Integer.parseInt(cs[0]);
            sum = Integer.parseInt(cs[1]);

            int d = sum/c;
            int m = sum % c;
            long ans = d* d * (c - m);
            if (m != 0) {
                ans += (d+1) * (d+1) * m;
            } else
                ans += (d*d * m);

            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }
}
