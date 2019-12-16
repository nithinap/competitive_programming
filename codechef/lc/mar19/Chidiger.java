package lc.mar19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Chidiger {
    /*
}
    static class Pair {
        int min;
        int max;
        int pos;

        public Pair(int min, int max, int pos) {
            this.min = min;
            this.max = max;
            this.pos = pos;
        }
    }
    public static void main(String[] args) throws IOException {
        int t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nd = br.readLine().split(" ");
            int[] narr = new int[nd[0].length()];
            for (int i = 0; i< nd[0].length(); i++) {
                narr[i] = Character.getNumericValue(nd[0].charAt(i));
            }
/*
            Pair p = getMinDigFromEnd(narr);
            StringBuilder sb = new StringBuilder();
            if (p.min > d) {
                // replace all digits with d
                for (int i=0; i<narr.length; i++) {
                    sb.append(d);
                }
                System.out.println(sb.toString());
            } else if (p.max < d) {
                System.out.println(nd[0]);
            } else {
                int countMin = 0;
                for (int i=0; i<=p.pos; i++) {
                    if (narr[i] == p.min)
                        countMin++;
                }
                // append min countMin times
                for (int i=0; i<countMin; i++)
                    sb.append(p.min);

                int countD = p.pos+1 - countMin;
                //append D countD times
                for (int i=0; i<countD; i++)
                    sb.append(nd[1]);

                if (p.pos != narr.length-1) {
                    // for the remaining digits, pick digits in non decreasing order
                    countD = 0; int minInd = p.pos, min2 = Integer.MAX_VALUE;
                    Map<Integer, Integer> digMap = new HashMap<>();

                    for (int i = p.pos+1; i < narr.length; i++) {
                        if (narr[i] < min2) min2 = narr[i];
                        if (narr[i] < narr[i-1]) {
                            minInd = getIndNumLessThanEqualTo(narr[i], digMap);
                            countD =  narr.length - minInd + 1;
                        }
                        digMap.put(narr[i], i);
                    }

                }
            }
        }

    }

    private static int getIndNumLessThanEqualTo(int num, Map<Integer, Integer> digMap) {
        for (int i=num; i>=1; i--) {
            if (digMap.containsKey(i))
                return digMap.get(i);
        }
        return -1;
    }

    private static Pair getMinDigFromEnd(int[] narr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int pos = -1;
        for (int i=0; i<narr.length; i++) {
            if (narr[i] <= min) {
                min = narr[i];
                pos = i;
            }
            if (narr[i] > max){
                max = narr[i];
            }
        }
        return new Pair(min, max, pos);
    }
*/

}
