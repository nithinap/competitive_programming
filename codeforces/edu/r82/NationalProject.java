package edu.r82;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NationalProject {

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] ngb = br.readLine().split(" ");
            int n = Integer.parseInt(ngb[0]);
            int g = Integer.parseInt(ngb[1]);
            int b = Integer.parseInt(ngb[2]);

            long ans = solve(n, g, b);
            System.out.println(ans);
        }
    }

    private static long solve(int n, int g, int b) {
        if (g >= n) return n;

        long repeat = ((n+1)/2 - 1)/g;
        long extra = (n+1)/2 - repeat * g;

        long ans = Math.max(repeat * (b+g) + extra, n);
        return ans;
    }

}
