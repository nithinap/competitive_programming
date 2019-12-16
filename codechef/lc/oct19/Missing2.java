package lc.oct19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Missing2 {
    static long MAXLIM = 1000000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] num = new String[n];
            int[] base = new int[n];
            long[] decimal = new long[n];

            boolean knownbase = false;
            int knownX = -1;
            for (int i = 0; i < n; i++) {
                String[] inp = br.readLine().split(" ");
                num[i] = inp[1];
                base[i] = Integer.parseInt(inp[0]);
                if (base[i] != -1) {
                    decimal[i] = getDecimal(num[i], base[i]);
                    knownbase = true;
                } else {
                    decimal[i] = -1;
                }
            }
//            System.out.println(Arrays.toString(decimal));

            if (knownbase) {
                // get decimals, and validate all decimals are same
                boolean sameDec = true, invalidDec = false;
                long x = -1;
                for (int i = 0; i < n; i++) {
                    if (base[i] != -1) {
                        if (decimal[i] != -1) {
                            if (x == -1) x = decimal[i];
                            else if (x != decimal[i]) {
                                sameDec = false;
                                break;
                            }
                        } else {
                            invalidDec = true;
                            break;
                        }
                    }
                }

                if (!sameDec || invalidDec) {
                    System.out.println("-1");
                } else {// when all known bases have same decimal values
//                    System.out.println("x = " +x );
//                    System.out.println(Arrays.toString(num));
                    boolean invalid = false;
                    for (int i = 0; i < n; i++) {
                        if (base[i] == -1) {
//                            System.out.println("i = " + i);
                            boolean found = false;
                            for (int b = 2; b <= 36; b++) {
                                long dec = getDecimal(num[i], b);
                                if (dec == x) {
//                                    System.out.println("base found - " + b);
                                    found = true;
                                    break;
                                }
                            }

                            if (!found) { // didnt find decimal equal to known X
                                invalid = true;
                                break;
                            }
                        }
                    }
                    if (invalid) System.out.println("-1");
                    else System.out.println(x);
                }
            } else {
                // there is no known base till now, x = -1
                if (n == 1) {
                    boolean found = false; long dec = -1;
                    for (int b=2; b<=36; b++) {
                        dec = getDecimal(num[0], b);
                        if (dec != -1) {
                            found = true;
                            break;
                        }
                    }
                    System.out.println(dec);
                } else {
                    Map<Integer, Set<Long>> map = new HashMap<>();
                    boolean invalid = false;
                    for (int i=0; i<n; i++) {
                        invalid = false;
                        // find all valid decimals for num[i]
                        map.put(i, new HashSet<>());
                        for (int b=2; b<=36; b++) {
                            long dec = getDecimal(num[i], b);
                            if (dec != -1){
                                Set<Long> set = map.get(i);
                                set.add(dec);
                                map.put(i, set);
                            }
                        }
                        if (map.get(i).size() == 0) {
                            invalid = true;
                            break;
                        }
                    }
                    if (invalid) System.out.println("-1");
                    else {
                        Set<Long> tmp = map.get(0);
                        for (int i = 1; i < n; i++) {
                            tmp.retainAll(map.get(i));
                        }

                        long minDec = 2000000000000L;
                        for (long dec :  tmp) {
                            if (dec < minDec) minDec = dec;
                        }
                        if (minDec != 2000000000000L) System.out.println(minDec);
                        else System.out.println("-1");
                    }
                }
            }
        }
    }

    static int getNum(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    private static long getDecimal(String num, int base) {
        long dec = 0;
        int len = num.length();
        long pow = 1L;

        for (int i = len - 1; i >= 0; i--) {
            int val = getNum(num.charAt(i));
            if (val >= base || pow > MAXLIM || pow < 0) return -1;
            dec += val * pow;
            pow *= base;
            if (dec > MAXLIM || dec < 0) return -1;
        }
        return dec;
    }

}
