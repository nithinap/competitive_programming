package r643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PB {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        // StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = Integer.parseInt(in[i]);

            Arrays.sort(a);

            int g = 0, p = 0;
            for (int j=0; j<n; j++) {
                if (a[j] <= j - p + 1) {
                    g++;
                    p = j + 1;
                }
            }
            System.out.println(g);
        }
    }
}
