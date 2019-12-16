package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MultiplyXY {
    static Set<Long> fact(long z) {
        Set<Long> set = new HashSet<>();
        boolean f = false;
        while (z % 2 == 0) {
            z /= 2;
            f = true;
        }

        if (f) set.add(2L);

        for (long i=3; i<=Math.sqrt(z); i += 2) {
            f = false;
            while (z % i == 0) {
                z /= i;
                f = true;
            }
            if (f) set.add(i);
        }

        set.add(1L);
        if (z > 2) set.add(z);
        return set;
    }


    public static void main(String args[] ) throws Exception {

        // Write your code here
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
//            String[] s = br.readLine().split(" ");
            long z = sc.nextLong(); //Integer.parseInt(s[0]);
            long m = sc.nextLong();//Integer.parseInt(s[1]);
            long n = sc.nextLong(); //Integer.parseInt(s[2]);


            Set<Long> set = fact(z);
            System.out.println(set);
            long ans = 0;
            if (m < n) {
                long tmp = m;
                m = n;
                n = tmp;
            }

            Set<Long> got = new HashSet<>();
            for (long fact : set) {
                if (fact <= m && !got.contains(fact)) {
                    long d = z/fact;
                    if (d <= n) {
                        got.add(d);

                        if (d != fact && fact <= n) ans+= 2;
                        else ans++;

                    }

//                    System.out.println(" == f "+ fact + ":" + ans );
                }
            }
            System.out.println(ans);
        }

    }
}
