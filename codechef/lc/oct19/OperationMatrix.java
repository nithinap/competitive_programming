package lc.oct19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OperationMatrix {

    public static void main(String[] args) throws IOException {
        int n, m, q;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String[] nq = br.readLine().split(" ");
            n = Integer.parseInt(nq[0]);
            m = Integer.parseInt(nq[1]);
            q = Integer.parseInt(nq[2]);
            int[] rCount = new int[n];
            int[] cCount = new int[m];

            while (q-- > 0) {
                String[] rc = br.readLine().split(" ");
                int r = Integer.parseInt(rc[0]);
                int c = Integer.parseInt(rc[1]);
                rCount[r-1]++;
                cCount[c-1]++;
            }

            int odd = 0, even = 0;
            for (int i = 0; i < cCount.length; i++) {
                if (cCount[i] % 2 == 0) even++;
                else odd++;
            }

            long totOdds = 0;
//            System.out.println("odds: " + odd + "; evens: " + even);
//            System.out.println(Arrays.toString(rCount));

            for (int i = 0; i < rCount.length; i++) {
                if (rCount[i] % 2 != 0){ // odd case
                    totOdds += even;
                } else { // even case
                    totOdds += odd;
                }
//                System.out.println(totOdds + " ===> ");
            }
            System.out.println(totOdds);
        }
    }
}
