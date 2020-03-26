package lc.jan20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Doraemon {
    public static void main(String[] args) throws IOException {
        int t, n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);

            int[][] ar = new int[n][m];
            for (int i=0; i<n; i++) {
                String[] nums = br.readLine().split(" ");
                for (int j=0; j<m; j++) {
                    ar[i][j] = Integer.parseInt(nums[j]);
                }
            }

            long ans = n*m;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    int l = j, r = m-l-1 , u = i, d = n - u-1;
                    int min = Math.min(Math.min(l, r), Math.min(u, d));
                    ans += palLength(ar, i, j, min);
                    //System.out.println(i+ "," + j + ": " + ans);
                }
            }
            System.out.println(ans);
        }
    }

    private static int palLength(int[][] ar, int i, int j, int min) {
        int c = 0;
        for (int k=1; k<=min; k++) {
            if (ar[i-k][j] == ar[i+k][j] && ar[i][j-k] == ar[i][j+k]) c++;
            else break;
        }
        // int res = (c > 0) ? 1 : 0;
        return c;
    }
}
