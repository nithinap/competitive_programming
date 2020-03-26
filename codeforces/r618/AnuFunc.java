package r618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnuFunc {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int[] a = new int[n];
        int max = -1, ind = -1;
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a);

        sb.append(a[n-1] + " ");
        for (int i=0; i<n-1; i++) {
            sb.append(a[i] + " ");
        }

        System.out.println(sb);
    }
}