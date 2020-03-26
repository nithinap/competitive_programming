package r615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProductOfNumbers {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            solve(sb, n);

        }

        System.out.println(sb);
    }

    private static void solve(StringBuilder sb, int n) {
        //System.out.println("for  : " + n);

        Map<Integer, Integer> m = new HashMap<>();

        int num = n;
        int i = 0;
        for (i = 2; i * i <= n; i++) {
            int p = 0;
            while (n % i == 0) {
                n /= i;
                ++p;
            }
            if (p > 0) m.put(i, p);
        }


        if (n > 1) m.put(n, 1);

        //System.out.println(m);

        m.remove(0);
        if (m.size() == 0) {
            sb.append("NO\n");
        } else {

            if (m.size() == 1) {
                int v = 0;
                for (int val : m.values()) v += val;
                if (v < 6) sb.append("NO\n");
                else {
                    Set<Integer> keys = m.keySet();

                    int k = keys.iterator().next();
                    sb.append("YES\n");
                    int k2 = k * k;
                    int k3 = k2 * k;

                    //System.out.println(" ======  " +  k2 + "  |  " + (num/k2));
                    sb.append(k + " " + k2 + " " + (num / k3) + "\n");
                }
            } else if (m.size() >= 3) {
                //int v = 0;
                //for (int value : m.values()) v += value;
                sb.append("YES\n");
                Set<Integer> keys = m.keySet();
                Iterator<Integer> it = keys.iterator();

                long k1 = it.next(); //System.out.println(k1 + " ===== ");
                k1 = (long)Math.pow(k1, m.get((int)k1));
                long k2 = it.next(); //System.out.println(k2 + " ===== ");
                k2 = (long)Math.pow(k2, m.get((int)k2));

                long rem = (num / (k1 * k2));
                sb.append(k1 + " " + k2 + " " + rem + "\n");

            } else if (m.size() == 2) {
                int v = 0;
                for (int val : m.values()) v += val;

                Set<Integer> keys = m.keySet();

                Iterator<Integer> it = keys.iterator();
                int k = it.next();
                int k2 = it.next();
                int k3 = num / (k * k2);

                if (k3 == k || k3 == k2 || k3 == 1) {
                    sb.append("NO\n");
                } else {
                    sb.append("YES\n" + k + " " + k2 + " " + k3 + "\n");
                }
            } else {
                sb.append("NO\n");
            }
        }

    }
}
