package codeforces.r608;

import java.util.Scanner;

public class Suits {
    public static void main(String[] args) {
        int a, b, c, d, e, f;
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c =sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        f = sc.nextInt();

        long t2 = Math.min(Math.min(b,c), d);
        long t1 = Math.min(a,d);

        long cost1 = t1 * e;
        if (d != t1) cost1 += (f * Math.min(Math.min(b, c), d  - t1));


        long cost2 = t2 * f;
        if (d != t2) cost2 += (e * Math.min(a, d-t2));

        long cost = Math.max(cost1, cost2);

        System.out.println(cost);
    }
}
