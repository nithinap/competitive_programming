package r637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PB {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] a = new int[n];
            String[] sa = br.readLine().split(" ");
            for (int i=0; i<n; i++) a[i] = Integer.parseInt(sa[i]);

            int[] p = new int[n];

            for (int i=1; i<n-1; i++) {
                if (a[i] > a[i-1] && a[i] > a[i+1]) p[i] = 1;
            }

            int tot = 0;
            for (int i=0; i<k-1; i++) {
                if (p[i] == 1) tot++;
            }

            int b = 1, max = tot, ind = 0;
            for (int i = k; i<n; i++) {
                if (p[b] == 1) tot--;
                if (p[i] == 0 && p[i-1] == 1) tot++;
                if (max < tot) {
                    max = tot;
                    ind = b;
                }
                b++;
            }
            sb.append((max+1) + " " + (ind+1) + "\n");
        }
        System.out.print(sb);
    }
}
