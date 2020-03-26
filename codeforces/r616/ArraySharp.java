package r616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySharp {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i=0; i<n; i++) a[i] = Integer.parseInt(s[i]);

            String ans = solve(a, n);
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }

    private static String solve(int[] a, int n) {
        if (n == 1) return "Yes";
        int i = 0;
        for (; i<n; i++) {
            if (i > a[i]) {
                break;
            }
        }

        if (i != n) {
            int t = i;
            //System.out.println("i = " + i + "; " + a[i-1]);
            if (a[i-1] == i - 1 && i - 1 == n - 1 - i) return "No";
            for (; t < n; t++) {
                if (a[t] < n-1 - t) return "No";
            }
        }

        return "Yes";
    }
}
