package lc.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BadShuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n > 1) {
            StringBuilder sb = new StringBuilder();
            int mid = ((n & 1) == 1)?  (int)(n/2) + 1: (int)n/2;
            for (int i = 2; i <= mid; i++) {
                sb.append(i + " ");
            }
            sb.append("1 ");
            for (int i=(mid+2); i<=n; i++) {
                sb.append(i+" ");
            }
            sb.append((mid+1)+"\n");

            sb.append(n+" ");
            for (int i = 1; i < n; i++) {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println("1\n1");
        }
    }
}
