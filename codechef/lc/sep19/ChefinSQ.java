package lc.sep19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChefinSQ {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] astr = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0; i<n; i++)
                a[i] = Integer.parseInt(astr[i]);

            Arrays.sort(a);
            int minSum = 0;
            for (int i=0; i<k; i++) {
                minSum += a[i];
            }
            int lastTerm = a[k-1], count = 0;
            for (int i=k; i<n; i++) {
                if(a[i] == lastTerm) count++;
                else break;
            }

            System.out.println(count+1);
        }
    }
}
