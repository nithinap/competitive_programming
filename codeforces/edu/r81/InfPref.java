package edu.r81;

import com.sun.xml.internal.ws.util.QNameMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class InfPref {

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nx = br.readLine().split(" ");
            String s = br.readLine();
            int c0 = 0, c1 = 0;

            int n = Integer.parseInt(nx[0]);
            int x = Integer.parseInt(nx[1]);
            // int[] pc = new int[n];
            Map<Integer, Integer> pc = new HashMap<>();
            int ptot = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '0') c0++;
                else c1++;
                int b = c0-c1;
                pc.put(b, pc.getOrDefault(b, 0) +1);
                if (i == n-1) ptot = b;
            }

            

            c0 = 0; c1 = 0;
            Map<Integer, Integer> sc = new HashMap<>();
            for (int i=n-1; i>= 0; i--) {
                if (s.charAt(i) == '0') c0++;
                else c1++;
                int b = c0-c1;
                pc.put(b, sc.getOrDefault(b, 0) +1);
            }


            int res = 0;
            if (ptot == 0) {
                if (x == 0) {// infinite
                    res = -1;
                } else {
                    int pcount = pc.getOrDefault(x, 0);
                    int scount = sc.getOrDefault(x, 0);
                    res = pcount + scount;
                }
            } else if (ptot < 0) {
                int pcount = pc.getOrDefault(x, 0);
                int scount = sc.getOrDefault(x, 0);
                if (x == 0) {
                    res += pcount;
                } else if (x > 0) {
                    res += pcount;
                    res += ways(ptot, x, pc);

                } else {

                }
            } else {

            }

        }
    }

    private static int ways(int ptot, int x, Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

        }
        return 0;
    }

}
