package lc.oct19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EvenEdges {

    public static String getStrArray(int[] a) {
        StringBuilder res = new StringBuilder();
        String space= "";
        for (int i=0; i<a.length; i++) {
            res.append(space + a[i]);
            space = " ";
        }
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        int t, n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            String[] nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);


            int[] subg = new int[n];
            Arrays.fill(subg, 1);

            if (m % 2 == 0) {
                for (int i = 0; i<m; i++) br.readLine(); // eat m lines
                sb.append("1\n");
                sb.append(getStrArray(subg) + "\n");
            } else {
                Map<Integer, Set<Integer>> map = new HashMap<>();
                int[] adj = new int[n];
                for (int i = 0; i < m; i++) { // m edges
                    String[] uv = br.readLine().split(" ");
                    int u = Integer.parseInt(uv[0]);
                    int v = Integer.parseInt(uv[1]);
                    adj[u - 1]++;
                    adj[v - 1]++;
                    addEdges(map, u-1, v-1);
                    addEdges(map, v-1, u-1);
                }
                // all adj lists
//                System.out.println(map);
//                System.out.println("adj: " + Arrays.toString(adj));
                int node = pickOddVertex(adj);
//                System.out.println("odd vert: " + node);
                if (node != -1) {
                    // has a odd vertex, mark node in diff subgraph
                    sb.append("2\n");
                    subg[node] = 2;
                    sb.append(getStrArray(subg) + "\n");
                } else {
                    // no odd degree nodes
                    sb.append("3\n");
                    // pick two even degree(non-zero) connected vertices
                    int c = 0, vert = -1;
                    for (int i=0; i<n; i++) {
                        if (adj[i] > 0 && adj[i] % 2==0) {
                            vert = i;
                            break;
                        }
                    }
//                    System.out.println("========");
//                    System.out.println("vert: " + vert);

                    subg[vert] = 3;
                    int vertAdj = map.get(vert).iterator().next();
                    subg[vertAdj] = 2;
                    sb.append(getStrArray(subg) + "\n");
                }
            }
        }
        System.out.print(sb);
    }

    private static int pickOddVertex(int[] adj) {
        for (int i=0; i<adj.length; i++) {
            if (adj[i] % 2 != 0) {
                return i;
            }
        }
        return -1;
    }

    private static void addEdges(Map<Integer, Set<Integer>> map, int u, int v) {
        // add to v to adjacent edges of u
        if (map.containsKey(u)) {
            Set<Integer> adj = map.get(u);
            adj.add(v);
            map.put(u, adj);
        } else {
            Set<Integer> adj = new HashSet<>();
            adj.add(v);
            map.put(u, adj);
        }
    }
}
