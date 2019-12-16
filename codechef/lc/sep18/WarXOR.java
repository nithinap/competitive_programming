package lc.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WarXOR {
//    static int[] exclude = new int[73];
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] st = br.readLine().split(" ");
            int e = 0, o = 0;
            Map<Integer, Integer> cmap = new HashMap<Integer, Integer>();

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st[i]);
                if (cmap.containsKey(num)) {
                    cmap.put(num, cmap.get(num) + 1);
                } else {
                    cmap.put(num, 1);
                }
                if ((num & 1) == 1)
                    o++;
                else {
                    e++;
                }
            }

            long res = 0;
            res = countPairs(e) + countPairs(o);


            for (Map.Entry<Integer, Integer> entry : cmap.entrySet()) {
                int num = entry.getKey();
                if (entry.getValue() > 1)
                    res -= countPairs((long) entry.getValue());
                if (cmap.containsKey(num+2) && ((num ^ (num+2)) == 2))   {
                    res -= (entry.getValue() * cmap.get(num+2));
                }
            }

            System.out.println(res);
        }
    }

    private static long countPairs(long n) {
        long res = 0;
        if ((n &1) == 1) {
            res = ((n - 1) >> 1) * n;
        } else {
            res = (n >> 1) * (n - 1);
        }
        return res;
    }
}
