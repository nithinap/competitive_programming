package edu.r81;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Display {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            String res = solve(num);
            System.out.println(res);
        }
    }

    private static String solve(int num) {
        int totdigits = num / 2;
        int rem = num % 2;
        StringBuilder sb = new StringBuilder();
        --totdigits;
        while (totdigits-- > 0) {
            sb.append("1");
        }

        //System.out.println("rem: " + rem);
        if (rem == 0) {
            sb.append("1");
            return sb.toString();
        } else {
            String res = "7" + sb.toString();
            return res;
        }
        //sb.append("\n");

    }
}
