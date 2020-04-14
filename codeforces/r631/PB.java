package r631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class PB {

    public static void main(String[] args) throws IOException {
        int t;
        int SIZE = 200002;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] sr = br.readLine().split(" ");
            int[] arr = new int[n+1];
            for (int i=0; i<n; i++) arr[i] = Integer.parseInt(sr[i]);

            boolean[] l = new boolean[SIZE];
            boolean[] r = new boolean[SIZE];

            HashSet<Integer> hs = new HashSet<>();
            long s = 0;
            for (int i=0; i<n; i++) {
                if (!hs.contains(arr[i])) {
                    s += arr[i];
                    hs.add(arr[i]);
                    long tmp = i+1;
                    if (s == (tmp * (tmp+1)) /2) {
                        l[i] = true;
                    }
                } else
                    break;
            }

            hs = new HashSet<>(); s= 0;
            for (int i=n-1; i>=0; i--) {
                if (!hs.contains(arr[i])) {
                    s += arr[i];
                    hs.add(arr[i]);
                    long tmp = n-i;
                    if (s == (tmp * (tmp+1)) /2) {
                        r[i] = true;
                    }
                } else
                    break;
            }

            StringBuilder sb = new StringBuilder();

            int count = 0;
//            System.out.println(Arrays.toString(l));
//            System.out.println(Arrays.toString(r));

            for (int i=0; i<n; i++) {
                if (l[i] && r[i+1]) {
                    ++count;
                    sb.append((i+1)  + " " + (n - i - 1) + "\n");
                }
            }

            // if (l[0] && r[1]) sb.append(1 + " " + (n-1) + "\n");
            // if (l[n-1] && r[n-1]) sb.append((n-1) + "" + 1 + "\n");

            String res = count + "\n" + sb.toString();
            System.out.print(res);
        }
    }
}
