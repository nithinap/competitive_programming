package lc.oct18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


class Circle {
    int x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}

class Pair {
    double min;
    double max;

    public Pair(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }



}

class Point implements Comparable<Point> {
    double p;
    char c;

    public Point(double p, char c) {
        this.p = p;
        this.c = c;
    }

    @Override
    public int compareTo(Point o1) {
        if(this.p - o1.p > 0)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Point{" +
                "p=" + p +
                ", c=" + c +
                '}';

    }
}

public class Circles {

    public static void main(String[] args) throws IOException {
        int n, q;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        n = Integer.parseInt(nq[0]);
        q = Integer.parseInt(nq[1]);
        Circle[] car = new Circle[n];
        for(int i=0; i<n; i++) {
            String[] xyr = br.readLine().split(" ");
            car[i] = new Circle(Integer.parseInt(xyr[0]), Integer.parseInt(xyr[1]), Integer.parseInt(xyr[2]));
        }

        int pairs = (n%2 == 0) ? ((n/2)*(n-1)) : (n*((n-1)/2));
        Point[] p = new Point[2*pairs];
        int tot = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                double d = dist(car[i], car[j]);
                double maxDist, minDist;

                if (d >= (car[i].r + car[j].r)) { // disjoint or one point touching
                    maxDist = d + car[i].r + car[j].r;
                    minDist = d - car[i].r - car[j].r;
                } else {
                    int minr = Math.min(car[i].r, car[j].r);
                    int maxr = Math.max(car[i].r, car[j].r);
                    if (d + minr < maxr) {
                        minDist = maxr - (d + minr);
                        maxDist = maxr + d + minr;
                    } else {
                        minDist = 0;
                        maxDist = d + minr + maxr;
                    }
                }
                //p[tot++] = new Pair(minDist, maxDist);
                p[tot++] = new Point(minDist, 's');
                p[tot++] = new Point(maxDist, 'e');

//                System.out.println("--> "+ p[tot-2] + "; "+ p[tot-1]);
            }
        }

        Arrays.sort(p);
        int[] psum = new int[tot];

        for (int i=0; i<tot; i++) {
            if (p[i].c == 's')
                psum[i]++;
            else {
                if (i+1 < tot)
                psum[i + 1]--;
            }
        }
//        System.out.println("====> "+ Arrays.toString(psum));

        for (int i=1; i<tot; i++) {
                psum[i] += psum[i-1];
        }
//        System.out.println(Arrays.toString(p));
//        System.out.println(Arrays.toString(psum));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<q; i++) {
            long res = 0;
            int k = Integer.parseInt(br.readLine());
            int ind = bSearch(p, k);
//            System.out.println("ind: "+ ind);
            if (ind == 0 || ind == -1) {
                sb.append("0" + "\n");
            } else {
                if (p[ind-1].p >= k) {
                    if (p[ind-1].c == 'e')
                        sb.append(psum[ind-1] + "\n");
                    else
                        sb.append(psum[ind ]);
                } else { // k > p[ind-1]
                    if (p[ind-1].c == 'e')
                        sb.append(psum[ind] + "\n");
                    else
                        sb.append(psum[ind-1] + "\n");
                }

            }

            /*
            for (int j=0; j<tot; j++) {
                if (k >= p[j].min && k<=p[j].max)

            }*/

        }
        System.out.print(sb.toString());
    }

    private static int bSearch(Point[] p, int k) {
        int high = p.length-1;
        int low = 0;
        int succ = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (p[mid].p <= k) {
                low = mid + 1;
            } else {
                succ = mid;
                high = mid - 1;
            }
        }

        return succ;
    }

    private static double dist(Circle a, Circle b) {
        long x = a.x - b.x;
        long y = a.y - b.y;

        double dist = Math.sqrt(x*x + y*y);
        return dist;
    }
}
//1.5440037453175304