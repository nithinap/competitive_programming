package lc.jun19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumGcd {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
//            Set<Integer> a = new HashSet<Integer>();
            int[] a = new int[n];
            String[] numArr = br.readLine().split(" ");
            int max = -1, smax = -1, val;
            if (n == 2) {
                int n1 = Integer.parseInt(numArr[0]);
                int n2 = Integer.parseInt(numArr[1]);
                System.out.println(n1+n2);
            } else {
                for (int i = 0; i < n; i++) {
                    val = Integer.parseInt(numArr[i]);
//                a.add(val);
                    a[i] = val;
                    if (val > max) max = val;
                }

                for (int i = 0; i < n; i++) {
                    if (a[i] > smax && a[i] != max) smax = a[i];
                }

                if (smax == -1) System.out.println(2*max);
                else {
//                    boolean maxRemoved = false, smaxRemoved = false;
                    for (int i = 0; i < n; i++) {
                        if (a[i] == max || a[i] == smax) {
                            a[i] = 0;
//                            maxRemoved = true;
//                        } else if () {
//                            a[i] = 0;
//                            smaxRemoved = true;
                        }
                    }

                    System.out.println(Arrays.toString(a));
                    int gcd = computeGCD(a);

                    int res = Math.max(max + GCD(gcd, smax), smax + GCD(gcd, max));
                    System.out.println(res);
                }
            }
        }
    }

    private static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a%b);
    }

    private static int computeGCD(int[] a) {
        int ans = a[0];
        for (int i=1; i<a.length; i++) {
            ans = GCD(ans, a[i]);
        }
        return ans;
    }
}
