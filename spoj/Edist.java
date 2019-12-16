package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edist {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m+1][n+1];

            for (int i=0; i<=m; i++) {
                for (int j=0; j<=n; j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    }
                    else if  (j == 0) {
                        dp[i][j] = i;
                    } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                    }
                }
            }

            System.out.println(dp[m][n]);
        }
    }
}
