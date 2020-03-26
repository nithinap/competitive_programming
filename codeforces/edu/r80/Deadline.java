package edu.r80;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deadline {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n, d;
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            d = Integer.parseInt(s[1]);

            if (d <= n) System.out.println("YES");
            else {
                int res = bsearch(n, d, 1, n-1);
                //System.out.println(res);
                String out =  (res == -1) ? "NO" : "YES";
                System.out.println(out);
            }
        }
    }

    private static int bsearch(int n, int d, int l, int h) {
        while (l <= h) {
            int mid = l + (h-l)/2;
            double v = mid + Math.ceil((double)d/(mid+1));
            if (v <= n) {
                return mid;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
