package snackdown.y19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class QualPrel {
    public static void main(String[] args) throws IOException {
        int t, n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);
            String[] num = br.readLine().split(" ");

            int c = 0;
            Integer[] sc = new Integer[n];
            for (int i=0; i<n; i++) {
               sc[i] = Integer.parseInt(num[i]);
            }
            Arrays.sort(sc, Collections.reverseOrder());
            int minScore = sc[k-1];

            for (int i=0; i<n; i++) {
                if (sc[i] >= minScore)
                    c++;
            }

            System.out.println(c);
        }
    }
}
