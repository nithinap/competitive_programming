package lc.feb20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HardCash {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            String[] as = br.readLine().split(" ");
            long sum = 0;
            for (int i=0; i<n; i++) sum += Integer.parseInt(as[i]);
            System.out.println(sum % k);
        }
    }
}
