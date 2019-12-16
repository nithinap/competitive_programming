package lc.dec18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ChefXOT {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        Map<Integer, Integer> qCount = new HashMap<>();

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            int[] a = new int[n+1];
            for (int i = 1; i<=n; i++) {
                System.out.println("1 "+ i + " " + i +" "+ i);
                a[i] = Integer.parseInt(br.readLine());
            }

            System.out.print("2 ");
            for(int i = 1; i<=n; i++)
                System.out.print(a[i] + " ");
            System.out.println();
            int res = Integer.parseInt(br.readLine());
            if (res == -1) {
                System.exit(1);
            }
        }
    }
}
