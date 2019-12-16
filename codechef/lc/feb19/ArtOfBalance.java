package lc.feb19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ArtOfBalance {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();

            int len = s.length();
            if (len <= 2) {
                System.out.println(0);
            } else {
                Integer[] cmap = genCharMAp(s);
                int D = 0;
                Arrays.sort(cmap, Collections.reverseOrder());

                for (int i=0; i<cmap.length; i++) {
                    if (i!=0) D++;
                }

                long min = Long.MAX_VALUE;
                for (int d = 1; d <= 26; d++) {
                    if (len % d == 0) {
                        long moves = computeMoves(cmap, d, len, D);
                        if (moves < min) min = moves;
                    }
                }
                System.out.println(min);
            }
        }

    }

    private static long computeMoves(Integer[] cmap, int d, int len, int initD) {
        int charCount = len/d;
        long steps = 0;
        if (d == initD) {
            for (int i=0; i<cmap.length; i++) {
                if (cmap[i] <= charCount) break;
                steps += (cmap[i] - charCount);
            }
        } else if (d < initD) {
            for (int i = 0; i < d; i++) steps += Math.abs(cmap[i] - charCount);
            for (int i = d; i < initD; i++) steps += cmap[i];
            steps >>= 1;
        } else {
            for (int i = 0; i < cmap.length; i++)
                steps += Math.abs(cmap[i] - charCount);
            steps += ((d - initD) * charCount);
            steps >>= 1;
        }
        return steps;
    }

    private static Integer[] genCharMAp(String s) {
        Integer[] cmap = new Integer[26];
        Arrays.fill(cmap, 0);
        for (Character c : s.toCharArray()) {
            cmap[c-'A'] += 1;
        }
        return cmap;
    }
}
