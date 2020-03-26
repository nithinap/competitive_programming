package r615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectingCoins {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            int n = Integer.parseInt(s[3]);

            long sum = a + b + c + n;
            if (sum%3 == 0) {
                long ns = sum / 3;
                long ra = (ns - a);
                long rb = (ns - b);
                long rc = (ns - c);
                if ((ra + rb + rc) == n && ns >= a && ns>=b && ns >= c) System.out.println("YES");
                else System.out.println("NO");
            } else
                System.out.println("NO");
        }
    }
}
