package global.r7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Maximums {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] bs = br.readLine().split(" ");

        long[] b = new long[n];
        for (int i=0; i<n; i++) b[i] = Long.parseLong(bs[i]);
        long[] a = new long[n];
        a[0] = b[0];
        long max = a[0];
        for (int i = 1; i<n; i++) {
            a[i] = b[i] + max;
            max = Math.max(a[i], max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(a[i]+ " ");
        }
        System.out.println(sb);
    }

    class Pair implements Comparable<Pair> {
        int number;
        int value;

        public Pair(int n, int v, int i) {
            this.number = n;
            this.value = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return value == pair.value &&
                    value == pair.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, value);
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value == o.value) return this.number - o.number;
            else return this.value - o.value;
        }

        @Override
        public String toString() {
            return "P{" +
                    "number=" + number +
                    ", value=" + value +
                    '}';
        }
    }
}
