package edu.r82;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ErasingZeroes {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            boolean one = false;
            int ans = solve(s);
            System.out.println(ans);

        }
    }

    static int solve(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') i++;

        int ind = -1, res = 0;
        for (; i<s.length(); i++) {
            if ((s.charAt(i) == '1' && ind == i-1) || (ind == -1)) ind = i;
            else if (s.charAt(i) == '1' && ind != i-1) {
                res += (i - ind - 1);
                ind = i;
            }
        }

        return res;
    }
}
