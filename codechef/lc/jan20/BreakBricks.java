package lc.jan20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BreakBricks {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] in = br.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int[] a = new int[3];
            int w1 = Integer.parseInt(in[1]);
            int w2 = Integer.parseInt(in[2]);
            int w3 = Integer.parseInt(in[3]);

            if (s >= w1 + w2 + w3) {
                System.out.println("1");
            } else if (s >= w1 + w2 || s >= w2 + w3) {
                System.out.println("2");
            } else {
                System.out.println("3");
            }
        }
    }
}
