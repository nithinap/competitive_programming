package r616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MindControl {
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

            String[] as = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = Integer.parseInt(as[i]);

            int res = solve(a, n, m, k);
            System.out.println(res);

        }
    }

    private static int solve(int[] a, int n, int m, int k) {
        int i = 0, j = n-1;
        if (m == 1) return Math.max(a[0], a[n-1]);

        if (k == 0) {
            int y = m -1;
            List<Integer> l = new ArrayList<>(y);
            for (; i<n && j>=0 && y>0; y--) {
                l.add(a[i++]);
                l.add(a[j--]);
            }
            Collections.sort(l);
            int ind = l.size() - y;
            return l.get(ind);
        }


        int y = Math.min(k, m-1);
        int ind = y;
        List<Integer> list = new ArrayList<>(y);
        i=0; j=n-1;
        for (; i<n && j >= 0 && k>0; k--) {
            list.add(a[i++]);
            list.add(a[j--]);
        }

        Collections.sort(list);
        //System.out.println(list);
        return list.get(ind);
    }
}
