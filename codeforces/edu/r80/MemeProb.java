package edu.r80;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemeProb {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            // a = Integer.parseInt(s[0]);
            //int b = Integer.parseInt(s[1]);
            //int bs = s[1].length();
            int b = Integer.parseInt(s[1]);
            int pow = (int) Math.log10(b+1);
            int a = Integer.parseInt(s[0]);

            long res = (long)a * pow;
            System.out.println(res);
        }
    }
}
