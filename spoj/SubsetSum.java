package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {

    static boolean isPossible(int[] pie, int n, int sum) {
        boolean dp[][] = new boolean[n+1][sum+1];

        // for zero sum
        for(int i=0; i<=n; i++) {
            dp[i][0] = true;
        }

//        // not possible to achieve sum without any elements
//        for(int j=1; j<=sum; j++) {
//            dp[0][j] = false;
//        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {
                //if (j < pie[i-1]) // current size is less than the pie size
                dp[i][j] = dp[i-1][j];
                if (j >= pie[i-1])
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-pie[i-1]]; // without picking ith pie or pick the ith pie
            }
        }
        return dp[n][sum];
    }

/*
    static int[][] dp;


    static int isPossibleR(int[] pie, int n, int sum) {
        int a,b=2;
        if(sum == 0) {
            dp[n][sum] = 1;
            return 1;
        }
        if (sum !=0 && n==0) {
            dp[n][sum] = 2;
            return 2;
        }

        if (sum < pie[n-1]) {
            dp[n][sum]=isPossibleR(pie, n - 1, sum);
            return dp[n][sum];
        }

        if(dp[n-1][sum] == 0)
            a = isPossibleR(pie, n-1, sum);
        else {
            a = dp[n-1][sum];
        }

        if (a!=1) {
            int rem = sum - pie[n - 1];
            if (dp[n - 1][rem] == 0)
                b = isPossibleR(pie, n - 1, rem);
            else {
                b=dp[n-1][rem];
            }
        }

        dp[n][sum] = a==1 || b==1 ? 1 : 2;
        return dp[n][sum];
    }
*/
    public static void main(String[] args) throws IOException {
        int t;

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] inp = br.readLine().split(" ");
            int sum = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(inp[0]);

            int[] pie = new int[m];
//            dp =  new int[m+1][sum+1];

            for (int i=1; i<=m; i++) {
                pie[i-1] = Integer.parseInt(inp[i]);
            }


            String res = isPossible(pie, m, sum)? "YES\n" : "NO\n";
//            System.out.println(res);
            sb.append(res);
        }
        System.out.println(sb);
    }
}
