package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodSubseq {

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] two = new int[n];
            for (int i=0; i<n; i++) {
                two[i] = count(Integer.parseInt(s[i]));
            }
//            System.out.println(Arrays.toString(two));

            int[] r = new int[n];
            for (int i=0; i<n; i++) {
                if (two[i] == 1) {
                    r[i] = 1;
                    int j = i + 1;
                    for (; j<n; j++) {
                        if (two[j] != 0) break;
                    }
                    if (j == n) {
                        r[i] = n - i;
                    } else {
                        r[i] = j - i;
                    }
                    i = j-1;
                }
            }

            int[] l = new int[n];
            for (int i = n-1; i>=0; i--) {
                if (two[i] == 1) {
                    l[i] = 1;
                    int j = i - 1;
                    for (; j>=0; j--) {
                        if (two[j] != 0) break;
                    }
                    if (j == -1) {
                        l[i] = i + 1;
                    } else {
                        l[i] = i - j;
                    }
                    i = j + 1;
                }
            }

//            System.out.println(Arrays.toString(l));
//            System.out.println(Arrays.toString(r));

            long remove = 0;
            for (int i = 0; i<n; i++) {
                remove += ((long)l[i] * r[i]);
            }

            long res = n;
            res = (res * (n+1)) /2 ;
            res -= remove;
            System.out.println(res);
        }
    }

    private static int count(int n) {
        if (n % 4 == 0) return 2;
        if (n % 2 == 0) return 1;
        return 0;
    }
}
