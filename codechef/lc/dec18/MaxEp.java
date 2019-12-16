package lc.dec18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxEp {
    public static void main(String[] args) throws IOException {
        int n, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        n = Integer.parseInt(nc[0]);
        c = Integer.parseInt(nc[1]);

        int maxC = 1000, X = 1;
        int cost = 0, step = 500;
        if (n <= step) {
            for (int t = 1; t <= n; t++) {
                System.out.println("1 " + t);
                cost++;
                int f = Integer.parseInt(br.readLine());

                if (f == 1) {
                    System.out.println("2");
                    System.out.println("3 " + t);
                    break;
                }
            }
        } else {
            int t, f = 0;
            for (t = step + 1; t <= n; t += step) {
                System.out.println("1 " + t);
                cost++;
                f = Integer.parseInt(br.readLine());

                if (f == 1) {
                    // check on prev bucket
                    System.out.println("2");
                    cost += c;
                    t = t - step;
                    break;
                }
            }

            if (f == 0) {
                t = t - step + 1;
                while (t <= n) {
                    System.out.println("1 " + t);
                    f = Integer.parseInt(br.readLine());
                    if (f == 1) {
                        System.out.println("2");
                        System.out.println("3 " + t);
                        break;
                    }
                    t++;
                }
            } else {
                int hi = t + step;
                int lo = t > 1 ? t + 1 : t;
                int mid = lo + (hi-lo) / 2;

                System.out.println("1 " + mid);
                f = Integer.parseInt(br.readLine());
                if (f == 1) {
                    if (mid > 1) {
                        boolean found = false;
                        // search lower
                        for (t = lo; t < mid; t++) {
                            System.out.println("1 " + t);
                            cost++;
                            f = Integer.parseInt(br.readLine());

                            if (f == 1) {
                                cost += c;
                                System.out.println("2");
                                System.out.println("3 " + t);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("2");
                            System.out.println("3 "+mid);
                        }
                    } else {
                        System.out.println("2");
                        System.out.println("3 1");
                    }
                } else {
                    // search from mid+1 to hi linear
                    for (t = mid + 1; t < hi; t++) {
                        System.out.println("1 " + t);
                        cost++;
                        f = Integer.parseInt(br.readLine());

                        if (f == 1) {
                            cost += c;
                            System.out.println("2");
                            System.out.println("3 " + t);
//                            System.out.println("cost: "+c);
                            break;
                        }
                    }
                }
            }
        }

    }
}
