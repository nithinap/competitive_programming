package lc.dec18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxPa {
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        int n, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        n = Integer.parseInt(nc[0]);
        c = Integer.parseInt(nc[1]);
        flag = false;
        int stepSize = 500;

        if (n <= 849) {
            lsearch(1, n, br);
        } else {
            int stepStart = stepSearch(1, n, stepSize, br);
            // search on stepStart, stepStart + Math.min(n, step+stepStart)
            int stepEnd = Math.min(n, stepSize+stepStart-2);
            int res = -1;
            if (flag) {
                res = stepStart +stepSize-1;
            }

            flag = false;

            if (c > 49) {
                int mid = stepStart + (stepEnd - stepStart) / 2;
                System.out.println("1 " + mid);
                int f = readNum(br);
                if (f == 1) {
                    System.out.println("2");
                    //search stepStart till mid-1
                    boolean found = lsearch(stepStart, mid - 1, br);
                    if (!found) {
                        System.out.println("3 " + mid);
                        flag = true;
                    }
                } else {
                    // search mid+1 till stepEnd
                    boolean found = lsearch(mid + 1, stepEnd, br);
                    if (!found) {
                        System.out.println("3 " + res);
                    }
                }
            } else {
                boolean found = lsearch(stepStart, stepEnd, br);
            }
        }
    }

    private static int stepSearch(int l, int h, int stepSize, BufferedReader br) throws IOException {
        int i = stepSize;
        for (i = stepSize; i<h; i+= stepSize) {
            System.out.println("1 "+i);
            int f = readNum(br);
            if (f == 1) {
                System.out.println("2");
                flag = true;
                return i-stepSize+1;
            }
        }
        // here if all stepEnd returned 0, we would be left with i-stepSize till n to check
        return i-stepSize+1;
    }

    private static boolean lsearch(int l, int h, BufferedReader br) throws IOException {
        for (int i=l; i<=h; i++) {
            System.out.println("1 " + i);
            int f = readNum(br);
            if (f == 1) {
                System.out.println("2");
                System.out.println("3 "+i);
                return true;
            }
        }
        return false;
    }

    private static int readNum(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
