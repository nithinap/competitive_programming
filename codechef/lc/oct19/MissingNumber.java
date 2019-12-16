package lc.oct19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());


        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] base = new int[n];
            String[] y = new String[n];
            int[] num = new int[n];

            for (int i = 0; i<n; i++) {
                String[] by = br.readLine().split(" ");
                base[i] = Integer.parseInt(by[0]);
                y[i] = by[1];
                if (base[i] != -1) num[i] = getDecimal(y[i], base[i]);
                else num[i] = -1;
            }

            int X = -1;
            boolean invalidX = false, knownBases = true;
            for (int i = 0; i < n; i++) {
                if (num[i] != -1) {
                    if(X == -1) X = num[i];
                    else if (num[i] != X) {
                        invalidX = true;
                        break;
                    }
                } else knownBases = false;
            }

            if (n == 1) {
                if (base[0] != -1) System.out.println(num[0]);
                else {
                    boolean found = false; int dec = -1;
                    for (int b =2; b<=36; b++) {
                        dec = getDecimal(y[0], b);
                        if (dec != -1) break;
                    }
                    System.out.println(dec);
                }
            }
            else if(invalidX) System.out.println("-1");
            else if (knownBases && !invalidX) System.out.println(X);
            else {
                int res = validateBases(y, base, num, X);
                System.out.println(res);
            }
        }
    }

    private static int validateBases(String[] y, int[] base, int[] num, int x) {
        if (x != -1) {
            boolean invalid = false;
            for (int i = 0; i < y.length; i++) {
                if (base[i] == -1) {
                    boolean foundBase = false;
                    for (int b = 2; b <= 36; b++) {
                        int dec = getDecimal(y[i], b);
                        if (dec == x) {
                            foundBase = true;
                            break;
                        }
                    }

                    if (!foundBase) {
                        invalid = true;
                        break;
                    }
                }
            }
            if (invalid) return -1;
            else return x;
        } else {
            Map<Integer, Set<Integer>> validNums = new HashMap<>();
            for (int i = 0; i < y.length; i++) {
                // validate if a base exists to reach x
                if (base[i] == -1) {
//                    System.out.println(base[i] + " ====== ");
                    int b = 2;
                    for (; b <= 36; b++) {
                        int dec = getDecimal(y[i], b);
                        if (dec != -1) {
                            // add dec number to the
                            if (validNums.containsKey(i)) {
                                Set<Integer> set = validNums.get(i);
                                set.add(dec);
                                validNums.put(i, set);
                            } else {
                                Set<Integer> set = new HashSet<>();
                                set.add(dec);
                                validNums.put(i, set);
                            }
                        }
                    }
                }
            }
//            System.out.println(validNums);

            if (validNums.size() != y.length) {
                return -1;
            }

            Set<Integer> set = validNums.get(0);
            for (int i = 1; i<y.length; i++) {
                Set<Integer> tmp = validNums.get(i);
                set.retainAll(tmp);
            }
//            System.out.println("====>" + set);

            int minX = Integer.MAX_VALUE;
            boolean flag = false;
            for(int number: set) {
                if (number < minX) minX = number;
                flag = true;
            }
            if (flag) return minX;

            return -1;
        }
    }

    static int getNum(char c) {
        if (c >= '0' && c <= '9')
            return (int)c - '0';
        else
            return (int)c - 'A' + 10;
    }

    private static int getDecimal(String num, int base) {
        int dec = 0;
        int len = num.length();
        int pow = 1;

        for (int i = len - 1; i>=0; i--) {
            int val = getNum(num.charAt(i));
            if (val >= base) return -1;
            dec += val * pow;
            pow *= base;
            if (dec > (int)1e12) return -1;
        }
        return dec;
    }
}
