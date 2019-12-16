package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Arr implements Comparable<Arr>{
    int v;
    int ind;
    Arr(int v, int ind) {
        this.v =v;
        this.ind = ind;
    }

    @Override
    public int compareTo(Arr o) {
        return this.v - o.v;
    }

    @Override
    public String toString() {
        return "Arr{" +
                "v=" + v +
                ", ind=" + ind +
                '}';
    }
}

class Q implements Comparable<Q> {
    int no;
    int a, b, num;
    Q(int no, int a, int b, int num) {
        this.no = no;
        this.a = a;
        this.b = b;
        this.num = num;
    }

    @Override
    public int compareTo(Q o) {
        return this.num - o.num;
    }

    @Override
    public String toString() {
        return "Q{" +
                "no=" + no +
                ", a=" + a +
                ", b=" + b +
                ", num=" + num +
                '}';
    }
}

class MicroAndShopping {

    public static void main(String args[] ) throws Exception {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] nq = br.readLine().trim().split(" ");

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //Integer.parseInt(nq[0]);
        int q = sc.nextInt(); //Integer.parseInt(nq[1]);
        //String[] s = br.readLine().trim().split(" ");

        Arr[] arr = new Arr[n];
        for (int i=0; i<n; i++) {
            int val = sc.nextInt();//Integer.parseInt(s[i]);
            arr[i] = new Arr(val, i);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Q[] qu = new Q[q];
        for (int i=0; i<q; i++) {
            //String[] query = br.readLine().trim().split(" ");
//            System.out.println(Arrays.toString(query));

            int a = sc.nextInt() - 1;//Integer.parseInt(query[0])-1;
            int b = sc.nextInt() - 1;//Integer.parseInt(query[1])-1;
            int c = sc.nextInt(); //Integer.parseInt(query[2]);
            qu[i] = new Q(i, a, b, c);
        }
        Arrays.sort(qu);
//        System.out.println(Arrays.toString(qu));
        int[] ans = new int[q];
        int[] bit = new int[n+1];

        int c = 0;
        for (int i = 0; i<q; i++) {
            while (c < n && arr[c].v <= qu[i].num) {
                update(bit, arr[c].ind + 1, 1, n);
                c++;
            }
            System.out.println(Arrays.toString(bit));
            ans[qu[i].no] = getCount(bit, qu[i].b+1, n) - getCount(bit, qu[i].a, n);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<q; i++) {
            sb.append(ans[i]+"\n");
        }
        System.out.print(sb);
        //Arrays.sort()
    }

    private static int getCount(int[] bit, int ind, int n) {
        int sum = 0;
        for (; ind > 0; ind -= (ind & -ind)) {
            sum += bit[ind];
        }
        return sum;
    }

    private static void update(int[] bit, int ind, int val, int n) {
        for (; ind <= n; ind += (ind & -ind)) {
            bit[ind] += val;
        }
    }
}
