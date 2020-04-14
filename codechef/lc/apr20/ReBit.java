package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReBit {
    private static int MOD = 998244353;

    private static int power(int x, int y) {
        if (y == 0) return 1;
        int p = power(x, y/2) % MOD;
        p = (int) (((long)p * p) % MOD);

        if (y % 2 == 1) return (int) (((long)x * p) % MOD);
        return p;
    }

    private static int modInverse(int q) {
        return power(q, MOD-2);
    }

    private static int compute(int p, int q) {
        long r = p;
        r = (r * modInverse(q)) % MOD;
        return (int)r;
    }

    private static int mux(int p1, int p2) {
        long r = p1;
        r = (r * p2) % MOD;
        return (int) r;
    }

    private static int union(int p1, int p2) {
        long r = p1;
        r = ((r + p2) %MOD);
        int tmp = mux(p1, p2);
        if (tmp > r) r = (r - tmp + MOD) % MOD;
        else r = (r - tmp) % MOD;
        return (int) r;
    }

    private static String solve(String s) {
        Stack<String> st = new Stack<>();
        int id = 1;
        if (s.length() == 1) {
            int p = compute(1,4);
            return String.format("%d %d %d %d\n", p, p, p, p);
        } else {
            Map<String, Integer> valMap = new HashMap<>();
            int pa0 = 0, pa1 = 0, pb0 = 0, pb1 = 0;
            int half = compute(1, 2);

            for (int i = 0; i < s.length(); i++) {
                String ch = Character.toString(s.charAt(i));
                if (ch.equals(")")) {
                    String e2 = st.pop();
                    String op = st.pop();
                    String e1 = st.pop();
                    st.pop(); // remove opening brace

                    if (e1.startsWith("$")) {
                        pa0 = valMap.get((e1 + "_0"));
                        pa1 = valMap.get((e1 + "_1"));
                    } else {
                        pa0 = half;
                        pa1 = half;
                    }

                    if (e2.startsWith("$")) {
                        pb0 = valMap.get((e2 + "_0"));
                        pb1 = valMap.get((e2 + "_1"));
                    } else {
                        pb0 = half;
                        pb1 = half;
                    }

                    int res0 = 0, res1 = 0;
                    switch (op) {
                        case "|":
                            res0 = mux(pa0, pb0);
                            res1 = union(pa1, pb1); // (int) ((long)pa1 + pb1 - mux(pa1, pb1));
                            break;

                        case "^":
                            res0 = (int) (((long)mux(pa0, pb0)  + mux(pa1, pb1)) % MOD);
                            res1 = (int) (((long)mux(pa0, pb1) + mux(pa1, pb0)) % MOD);
                            break;

                        case "&":
                            res0 = union(pa0, pb0); //(int) ((long)pa0 + pb0 - mux(pa0, pb0));
                            res1 = mux(pa1, pb1);
                            break;
                    }

                    // push val back to stack
                    String key = "$" + id;
                    st.push(key);
                    valMap.put(key + "_0", res0);
                    valMap.put(key + "_1", res1);
                    ++id;

                } else {
                    st.push(ch);
                }
            }

            // get result
            String resKey = st.pop();
            int p0 = valMap.get(resKey + "_0");
            int p1 = valMap.get(resKey + "_1");

            int r0 = mux(p0, p0);
            int r1 = mux(p1, p1);
            int ra = mux(p0, p1);
            int rb = ra;

            return String.format("%d %d %d %d\n", r0, r1, ra, rb);
        }
    }

    public static void main(String[] args) throws IOException {
        int t;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            String result = solve(s);
            sb.append(result);
        }
        System.out.println(sb);
    }
}
