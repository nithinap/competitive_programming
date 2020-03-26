package lc.jan20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrefixSuffixSums {
    public static int MOD = 1000000007;
    public static int MAX = 100001;

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    private static long[] computeFact() {
        long[] f = new long[MAX];
        f[0] = 1;
        f[1] = 1;
        //for (int i = 2; i < 13; i++) f[i] = (f[i - 1] * i);
        for (int i = 2; i < MAX; i++) f[i] = (f[i - 1] * i) % MOD;
        return f;
    }

    private static long[] computeModInv() {
        long[] inv = new long[MAX];
        long[] modInv = new long[MAX];
        inv[0] = inv[1] = 1;
        modInv[0] = 1;
        modInv[1] = 1;
        for (int i = 2; i < MAX; i++) {
            inv[i] = MOD - (MOD / i) * inv[MOD % i] % MOD;
            modInv[i] = (modInv[i - 1] * inv[i]) % MOD;
        }
        //System.out.println(Arrays.toString(inv));
        return modInv;
    }

    private static long power(long a, long b) {
        if (b == 0) return 1;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b = b >> 1;
        }

        return res;
    }

    private static long[] computePow2() {
        long[] p2 = new long[MAX];
        p2[0] = 1;
        p2[1] = 2;
        //for (int i = 2; i < 29; i++) p2[i] = p2[i - 1] * 2;
        for (int i = 2; i < MAX; i++) {
            p2[i] = (p2[i - 1] * 2) % MOD;
        }
        return p2;
    }

    public static void main(String[] args) throws IOException {
        int t;
        MyScanner sc = new MyScanner();

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //t = Integer.parseInt(br.readLine());
        t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        long[] fact = computeFact();
        //long[] modInv = computeModInv();
        //long[] p2 = computePow2();

        while (t-- > 0) {
            //int n = Integer.parseInt(br.readLine());
            int n = sc.nextInt();
            Map<Long, Integer> map = new HashMap<>();
            //String[] s = br.readLine().split(" ");

            long tot = 0;
            long[] a = new long[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                //a[i] = Long.parseLong(s[i]);
                a[i] = sc.nextLong();
                tot += a[i];
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }

            long sum = (tot / (n + 1));
            //System.out.println("tot: " + tot + "; sum: " + sum);
            //System.out.println(map);
            if (!(map.containsKey(sum) && (tot % (n + 1)) == 0)) {
                //System.out.println("0");
                sb.append("0\n");
                continue;
            } else if (n == 1) {
                if (a[0] != a[1]) sb.append("0\n");//System.out.println("0");
                else sb.append("1\n");//System.out.println("1");
                continue;
            } else if (map.get(sum) < 2) {
                //System.out.println("0");
                sb.append("0\n");
                continue;
            } else {
                boolean invalid = false;
                int pow2 = 0;
                long repeat = 1;

                if (map.get(sum) == 2) map.remove(sum);
                else map.put(sum, map.get(sum) - 2);

                Set<Long> checked = new HashSet<>();
                long mid = sum / 2;
                if (map.containsKey(mid)) {
                    if ((sum & 1) == 0) {
                        int freq = map.get(mid);
                        if ((freq & 1) == 0) {
                            //pairMap.put(p, freq / 2);
                            repeat = (repeat * fact[freq / 2]) % MOD;
                            checked.add(mid);
                        } else {
                            //System.out.println("0");
                            sb.append("0\n");
                            continue;
                        }
                    }
                }

                if (checked.contains(mid)) map.remove(mid);

                //for (long key : map.keySet()) {
                for (Map.Entry<Long, Integer> e : map.entrySet()) {
                    long key = e.getKey();
                    if (!checked.contains(key)) {
                        int freq = e.getValue();
                        //System.out.println("key: " + key);
                        //System.out.println("map: " + map);
                        //System.out.println("inv: " + invalid);
                        if (freq > 0) {
                            long rem = sum - key;
                            //System.out.println("key: " + key + "; rem: " + rem + "; freq: " + freq);
                            if (map.containsKey(rem) && !checked.contains(rem) && map.get(rem) == freq) {
                                if (key != rem) pow2 += freq;
                                if (freq > 1) repeat = (repeat * fact[freq]) % MOD;
                                checked.add(key);
                                checked.add(rem);
                            } else {
                                invalid = true;
                                break;
                            }
                        }
                    }
                }


                if (invalid) {
                    //System.out.println("0");
                    sb.append("0\n");
                    continue;
                } else {
                    long ways = power(2L, pow2);
                    //System.out.println("ways: "+ways + "; p2: " + p2 + "; f(n-1): " + fact[n-1] + "; repeats:" + repeats);
                    long ans = (fact[n - 1] * ways) % MOD;
                    repeat = power(repeat, MOD-2);
                    ans = (ans * repeat) % MOD;
                    //System.out.println(ans);
                    sb.append(ans + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
