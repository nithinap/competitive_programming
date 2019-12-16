package lc.nov18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefRidge {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tests = br.readLine().split(" ");
        t = Integer.parseInt(tests[0]);
        int[] num = new int[26];
        int[] den = new int[26];
        num[1] = 1;
        den[1] = 2;
        for(int i=2; i<=25; i++) {
//            int N = Integer.parseInt(tests[i]);
            num[i] = den[i-1] - num[i-1];
            den[i] = den[i-1]*2;
        }

        for(int i=1; i<=t; i++) {
            int n = Integer.parseInt(tests[i]);
            System.out.print(num[n]+" "+den[n]+" ");
        }
    }
}
