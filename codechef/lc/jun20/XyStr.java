package lc.jun20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XyStr {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            int n = s.length();
            int[] dp = new int[n];

            if ((s.charAt(1) == 'y' && s.charAt(0) == 'x') || (s.charAt(1) == 'x' && s.charAt(0) == 'y')) {
                dp[1] = 1;
            }

            for (int i=2; i<n; i++) {
                dp[i] = dp[i-1];
                if ((s.charAt(i) == 'y' && s.charAt(i-1) == 'x') || (s.charAt(i) == 'x' && s.charAt(i-1) == 'y')) {
                    dp[i] = Math.max(dp[i-2] + 1, dp[i-1]);
                }
            }
            // System.out.println(Arrays.toString(dp));
            System.out.println(dp[n-1]);
        }
    }
}
