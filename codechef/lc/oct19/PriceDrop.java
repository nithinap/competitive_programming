package lc.oct19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PriceDrop {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] p = new int[n];
            for (int i=0; i<n; i++) {
                p[i] = Integer.parseInt(s[i]);
            }

            int count = 1; // p[0] - good
            if(n > 1 && p[1] < p[0]) count++;
            if(n > 2 && p[2] < p[1] && p[2] < p[0]) count++;
            if(n > 3 && p[3] < p[2] && p[3] < p[1] && p[3] < p[0]) count++;
            if(n > 4 && p[4] < p[3] && p[4] < p[2] && p[4] < p[1] && p[4] < p[0]) count++;

            for (int i=5; i<n; i++) {
                if (p[i] < p[i-1] && p[i] < p[i-2] && p[i] < p[i-3] && p[i] < p[i-4] && p[i] < p[i-5])
                    count++;
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
