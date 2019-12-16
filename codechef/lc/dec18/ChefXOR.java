package lc.dec18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ChefXOR {

    public static void main(String[] args) throws IOException {
        int t, n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> qCount = new HashMap<>();
            int[] a = new int[n+1];

            int i = 1, j = 2, k = 3;
            System.out.printf("1 1 2 3");
            int x1 = read(br);
            System.out.println("1 3 4 5");
            int y1 = read(br);
            System.out.println("1 4 5 2");
            int z1 = read(br);
            a[1] = x1 ^ y1 ^ z1;

            System.out.printf("1 2 3 4");
            int x2 = read(br);
            System.out.println("1 4 5 6");
            int y2 = read(br);
            System.out.println("1 5 6 3");
            int z2 = read(br);
            a[2] = x2 ^ y2 ^ z2;

            a[3] = a[1] ^ a[2] ^ x1;
            a[4] = a[2] ^ a[3] ^ x2;
            a[5] = a[3] ^ a[4] ^ y1;
            a[6] = a[4] ^ a[5] ^ y2;

            qCount.put(1, 1);
            qCount.put(2, 3);

        }
     }

    private static int read(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
