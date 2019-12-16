package lc.nov18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HMappy1 {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, q, k;
        String[] nqk = br.readLine().split(" ");
        String[] ns = br.readLine().split(" ");
        String query = br.readLine();
        n = Integer.parseInt(nqk[0]);
        q = Integer.parseInt(nqk[1]);
        k = Integer.parseInt(nqk[2]);

        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(ns[i]);
        }

        int rot = 0;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<q; i++){
            char ch = query.charAt(i);
            if (ch == '?') {
                int res = computeLS(a, n, rot, k);
                sb.append(res + "\n");
            } else { // "!" -> rotation
                rot++;
            }
        }
        System.out.print(sb.toString());
    }

    private static int computeLS(int[] a,int n, int rot, int k) {
        int len = 0, num = -1, maxlen = 0;
//        System.out.println("Rot :" +rot);
        rot = rot % n;
        for (int i=0; i<n; i++) {
            if (i - rot >= 0)
                num = a[i - rot];
            else
                num = a[(i-rot)+n];
//            System.out.print(num+",");
            if (num == 0) {
                if(len > maxlen) {
                    maxlen = len;
                }
                len = 0;
            } else {
                ++len;
                if(len >= k) {
                    maxlen = k;
                    break;
                }
            }
        }
        return maxlen;
    }
}
