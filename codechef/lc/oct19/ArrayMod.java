package lc.oct19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ArrayMod {
    public static void main(String[] args) throws IOException {
        int t, n; long k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            String[] array = br.readLine().split(" ");
            n = Integer.parseInt(nk[0]);
            k = Long.parseLong(nk[1]);
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(array[i]);
            }

            int[] xor = new int[(int) Math.ceil(n*1.0/2)];
            for (int i =0; i<xor.length; i++) {
                xor[i] = a[i] ^ a[n-i-1];
            }

//            System.out.println(Arrays.toString(xor));
            long cycles = k/n;
            int extra = (int) (k % n);
            int rounds = (int) (cycles % 3);
//            System.out.println("cycles: " + cycles + ";  extra: " + extra);

            int[] arr = null;
            switch (rounds) {
                case 0:
                    arr = a;
                    if (k>n && n%2 != 0)
                        arr[(int)n/2] = 0;
                    break;
                case 1:
                    arr = getShiftedArr(a, xor, n, 1);
                    break;
                case 2:
                    arr = getShiftedArr(a, xor,n, 2);
                    break;
            }

//            System.out.println(Arrays.toString(arr));
            // leftover k%n steps
            for (int i = 0; i<extra; i++) {
                arr[i] = arr[i] ^ arr[n-i-1];
            }

//            System.out.println(Arrays.toString(arr));
//            System.out.println("res ==>" + getStringArr(arr));
            sb.append(getStringArr(arr ) + "\n");
        }
        System.out.print(sb);
    }

    private static String getStringArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        String space = "";
        for (int i=0; i<arr.length; i++) {
            sb.append(space + arr[i]);
            space = " ";
        }
        return sb.toString();
    }

    private static int[] getShiftedArr(int[] a, int[] xor, int n, int round) {
        int[] res = new int[n];
        if (round == 1) {
            for (int i = 0; i < xor.length; i++) {
                res[i] = xor[i];
            }

            int j = 0;
            for (int i = n-1; i>=xor.length; i--) {
                res[i] = a[j++];
            }
            return res;
        }

        if (round == 2) {
            int i = 0, j=n-1;
            for (i=0; i < n - xor.length; i++) {
                res[i] = a[j--];
            }

            j = xor.length-1;
            for (; i < n; i++) {
                res[i] = xor[j--];
            }
            return res;
        }

        return a;
    }
}
