package r637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PC {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] a = new int[n];
            int[] f = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(s[i]);
                map.put(a[i], i);
                if (a[i] == 1) f[i] = 1;
            }

            int[] r = new int[n+1];
            int[] c = new int[n+1];
            for (int i=2; i<=n; i++) {

            }
        }
    }
}
