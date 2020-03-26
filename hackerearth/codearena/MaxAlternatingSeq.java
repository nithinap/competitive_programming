package codearena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxAlternatingSeq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];
            int[] ip = new int[n + 1];

            String[] s = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

            for (int i = 0; i < n; i++) {
                ip[i] = 1;
                dp[i] = 1;
            }

            int max = 1, md = 0, mi = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    ip[i] = Math.max(ip[i], dp[i-1] + 1);
                    dp[i] = Math.max(dp[i], ip[i-1] + 1);
                }
                max = Math.max(max, Math.max(dp[i], ip[i]));

            }
            System.out.println(Arrays.toString(dp));
            System.out.println(Arrays.toString(ip));
            System.out.println(max);
        }
    }
}

