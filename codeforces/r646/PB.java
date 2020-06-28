package r646;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PB {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s  = br.readLine();
            int n= s.length();
            int[] f1 = new int[n];
            int[] f0 = new int[n];

            if (s.charAt(0) == '1') f1[0]++;
            else f0[0]++;
            for (int i = 1; i<n; i++) {
                if (s.charAt(i) == '1') f1[i]++;
                else f0[i]++;
                f1[i] += f1[i-1];
                f0[i] += f0[i-1];
            }

            int t1 = f1[n-1];
            int t0 = f0[n-1];

            int cost = n;
            for (int i = 0; i<n; i++) {
                int c1 = f0[i] + t1 - f1[i];// 1*0*
                int c2 = f1[i] + t0 - f0[i];//0*1*;
                cost = Math.min(cost, Math.min(c1,c2));
            }
            System.out.println(cost);
        }
    }
}
