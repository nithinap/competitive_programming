package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnsLeak {
    public static void main(String[] args) throws IOException {
        int t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);
            int k = Integer.parseInt(inp[2]);



            int[][] sheet = new int[n][k];
            for (int i = 0; i < n; i++) {
                String[] ans = br.readLine().split(" ");
                for (int j = 0; j < k; j++) {
                    sheet[i][j] = ans[j].charAt(0) - '0';
                }
            }

            Set<Integer> viable = new HashSet<>();
            for (int i = 0; i < k; i++) viable.add(i);
            for (int i = 0; i < n; i++) {
                Map<Integer, HashSet<Integer>> map = new HashMap<>();
                for (int j = 0; j < k; j++) {
                    if (viable.contains(j)) {
                        HashSet<Integer> set = map.getOrDefault(sheet[i][j], new HashSet<Integer>());
                        set.add(j);
                        map.put(sheet[i][j], set);
                    }
                }

                int maxSize = -1, op = -1;
                for (Map.Entry<Integer, HashSet<Integer>> e : map.entrySet()) {
                    HashSet<Integer> set = e.getValue();
                    int slen = set.size();
                    if (slen > maxSize) {
                        op = e.getKey();
                        maxSize = slen;
                    }
                }

                if (op != -1) viable.removeAll(map.get(op));
                if (viable.size() == 0) {
                    for (int q = 0; q < k; q++) viable.add(q);
                }

                sb.append(op + " ");
            }
        }
        System.out.println(sb);
    }
}
