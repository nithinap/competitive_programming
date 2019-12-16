package lc.aug19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Interval implements Comparable<Interval> {
    char type;
    int value;

    public Interval(char type, int value) {
        this.type = type;
        this.value = value;
    }


    @Override
    public int compareTo(Interval o) {
        if (this.value == o.value && this.type != o.type)
            return o.type - this.type;
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "{" +
                "t=" + type +
                ", val=" + value +
                '}';
    }
}

public class Zombies {
    public static void main(String[] args) throws IOException {
        int t, n;
//        int lim = (int) 1e5;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            long[] count = new long[n];
            String[] nums = br.readLine().split(" ");
            String[] zoms = br.readLine().split(" ");

            Interval[] ranges = new Interval[2 * n];
            int j = 0;
            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(nums[i]);
                int left = Math.max(i - value, 0);
                int right = Math.min(i + value, n - 1);
                Interval rangeLeft = new Interval('s', left);
                Interval rangeRight = new Interval('e', right);

                ranges[j++] = rangeLeft;
                ranges[j++] = rangeRight;
                count[i] = value;
            }

            Arrays.sort(ranges);

            long[] res = new long[n + 1];
            for (int i = 0; i < 2 * n; i++) {
                Interval cur = ranges[i];
                if (cur.type == 's') {
                    res[cur.value]++;
                } else {
                    res[cur.value + 1]--;
                }
            }

            Map<Long, Integer> fmap = new HashMap<>();
            fmap.put(res[0], 1);
            for (int i = 1; i < n; i++) {
                res[i] = res[i] + res[i - 1];
                if (fmap.containsKey(res[i])) {
                    int val = fmap.get(res[i]);
                    fmap.put(res[i], ++val);
                } else {
                    fmap.put(res[i], 1);
                }
            }

//            System.out.println(Arrays.toString(res));
//            System.out.println(fmap);

            Map<Long, Integer> zmap = new HashMap<>();
            for (String zom : zoms) {
                long z = Long.parseLong(zom);
                if (zmap.containsKey(z)) {
                    int v = zmap.get(z);
                    zmap.put(z, ++v);
                } else {
                    zmap.put(z, 1);
                }
            }

            boolean flag = true;
            for (Map.Entry<Long, Integer> e : zmap.entrySet()) {
                long key = e.getKey();
                int val = e.getValue();

                if (!(fmap.containsKey(key) && fmap.get(key) == val)) {
                    flag = false;
                    break;
                }
            }

            String ans = flag ? "YES" : "NO";
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
