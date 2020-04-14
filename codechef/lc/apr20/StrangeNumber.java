package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StrangeNumber {
    private static double log2 = Math.log(2);
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        //Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, Integer> dcount = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] xk = br.readLine().split(" ");
            int x = Integer.parseInt(xk[0]);
            int k = Integer.parseInt(xk[1]);

            //System.out.println( divisorCount(x, dcount));
            int res = solve(x, k, dcount);
            //System.out.println(res);
            sb.append(res + "\n");
        }

        System.out.print(sb);
    }

    private static int solve(int x, int k, Map<Integer, Integer> map) {
        if (k == 0) {
            if (x == 1) return 1;
            else return 0;
        }

        if (k == 1) {
            if (x >= 2)
                return 1;
            else
                return 0;
        }

        //if (Math.log(x) / log2 >= k && divisorCount(x, map) >= k) {
        // if ((int)Math.pow(Math.sqrt(x), 2) == x && k == 2) return 1;
        if (x >= Math.pow(2, k) && divisorCount(x, map) >= k) {
            return 1;
        } else {
            return 0;
        }

    }

    private static int divisorCount(int x, Map<Integer, Integer> map) {
        if (map.containsKey(x)) return map.get(x);
        //ArrayList<Integer> list = new ArrayList<>();

        int c = 0;
        while (x % 2 == 0) {
            ++c;
            x /= 2;
        }

        for (int i=3; i*i <=x; i++) {
            while (x % i == 0) {
                ++c;
                x /= i;
            }
        }

        if (x > 2) c++;
        //System.out.println(" ---- " + c);
        // int c = list.size();
        map.put(x, c);
        return c;
    }
}
