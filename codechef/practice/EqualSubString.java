package practice;

import java.util.Arrays;

public class EqualSubString {
    public static void main(String[] args) {
        int res = equalSubstring("anryddgaqpjdw", "zjhotgdlmadcf", 5);
//        int res = equalSubstring("tlslxtfcdjhmknqudilp", "bvydddtftartnntdhyks", 39);
//        int res = equalSubstring("abc", "dzd", 25);
//        int res = equalSubstring("abcd", "cdef", 1);
//        int res = equalSubstring("abcd", "acde", 0);
        System.out.println(res);
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int maxlen  = 0;
        int len = s.length();
        int[] cost = new int[len];

        boolean flag = false;
        for (int i = 0; i<len; i++) {
            int res = s.charAt(i) - t.charAt(i);
            if (res < 0) res *= -1;
            cost[i] = res;
            if (cost[i] <= maxCost) flag = true;
        }

        System.out.println(Arrays.toString(cost));

        int rem = maxCost, res = 0, prev = 0, maxRes = 0;
        if (!flag) System.out.println("0");
        else {
            int i = 0;
            while (cost[i] > rem) {
                i++;
                prev = i;
            }

            for (; i < cost.length; i++) {
                while (i < cost.length && rem - cost[i] >= 0) {
                    rem -= cost[i];
                    ++res;
                    if (maxRes < res) maxRes = res;
                    i++;
                }

                while (i < cost.length - 1 && prev < i && rem < cost[i]) {
                    rem += cost[prev];
                    prev++;
                    --res;
                }
                System.out.println("### " + i + "; prev:" + prev + "; res: " + maxRes + "; cost: " + rem);

                if (i < cost.length - 1 && rem >= cost[i]) {
                    if (prev < i) {
                        rem -= cost[i];
                        res++;
                        if (res > maxRes) maxRes = res;
                    } else {
                        rem = maxCost - cost[i];
                        res = 1;
                        if (res > maxRes) maxRes = res;
                    }
                }

                System.out.println("at " + i + "; res: " + maxRes + "; cost: " + rem);
                System.out.println("===== i: " + i + ": " + rem + "## " + res);
            }
        }
        return maxRes;
    }
}
