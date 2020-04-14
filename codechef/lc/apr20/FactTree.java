package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FactTree {

    private static int MOD = 1000000007;
    private static boolean[] isPrime = new boolean[1000000];

    private static void computePrime() {
        Arrays.fill(isPrime, true);
        int max =  (int) Math.ceil(Math.sqrt(isPrime.length));
        for (int i=2; i<=max; i++) {
            if (isPrime[i]) {
                for (int k = 2 * i; k < isPrime.length; k += i) {
                    isPrime[k] = false;
                }
            }
        }
    }

    private static void addEdge(int u, int v, List<Integer>[] edges) {
        edges[u].add(v);
        edges[v].add(u);
    }

    private static void dfs(int v, int p, int d, int[] parent, int[] depth, List<Integer>[] edges) {
        parent[v] = p;
        depth[v] = d;

        for (int vert : edges[v]) {
            if (vert != p) dfs(vert, v, d+1, parent, depth, edges);
        }
    }

    private static int countFact(long n) {
        long res = 1L;
        int max = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                long c = 0;
                if (n % i == 0) {
                    while (n % i == 0) {
                        n /= i;
                        ++c;

                    }
                    res = (res * (c + 1)) % MOD;
                }
            }
        }

        if (n > 2) res = (res * 2) % MOD;
        return (int)res;
    }

    private static int getPathVal(int u, int v, int[] cost, int[] depth, int[] parent, Map<Long, Integer> dmap) {
        long c = 1L; // ((long)cost[u] * cost[v]) % MOD;
        while (u != v) {
            if (depth[u] < depth[v]) {
                c = (c * cost[v]);
                v = parent[v];
            } else if (depth[u] > depth[v]) {
                c = (c * cost[u]);
                u = parent[u];
            } else if (depth[u] == depth[v]) {
                c = (c * cost[u]);
                c = (c * cost[v]);
                u = parent[u];
                v = parent[v];
            }
        }
        c = c * cost[u];
//        System.out.println("c = " + c);
        if (dmap.containsKey(c)) return dmap.get(c);

        int res = countFact(c);
        dmap.put(c, res);

        return res;

    }

    private static int swap(int a, int b) {
        return a;
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        computePrime();

        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> dmap = new HashMap<>();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> pathResult = new HashMap<>();

            int SIZE = n + 1;
            List<Integer>[] edges = (List<Integer>[]) new List[SIZE];
            for (int i =0; i<edges.length; i++) {
                edges[i] = new ArrayList<>();
            }

            int[] parent = new int[SIZE];
            int[] depth = new int[SIZE];
            int[] cost = new int[SIZE];

            for (int i=0; i<n-1; i++) {
                String[] s = br.readLine().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);

                addEdge(u, v, edges);
            }

            //for (List<Integer> v: edges) System.out.println(v);

            String[] cs = br.readLine().split(" ");
            for (int i=0; i<cs.length; i++) {
                cost[i+1] = Integer.parseInt(cs[i]);
            }

            int r = 0;
            for (int i=1; i<=n; i++) {
                if (edges[i].size() <= 2) {
                    r = i;
                    break;
                }
            }

            dfs(r, -1, 1, parent, depth, edges);

            int q = Integer.parseInt(br.readLine());

            for (int i=0; i<q; i++) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);
                if (u > v) u = swap(v, v = u);

                String ansKey = u + "#" + v;
                // System.out.println("key: " + ansKey);
                int ans = -1;
                if (pathResult.containsKey(ansKey)) {
                    ans = pathResult.get(ansKey);
                } else {
                    ans = getPathVal(u, v, cost, depth, parent, dmap);
                }
                sb.append(ans + "\n");
            }

//            System.out.println(Arrays.toString(parent));
//            System.out.println(Arrays.toString(depth));

        }
        System.out.print(sb);
    }

}
