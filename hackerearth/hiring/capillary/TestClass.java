package hackerearth.hiring.capillary;

import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A=0; i_A<arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_L = br.readLine().split(" ");
            long[] L = new long[Q];
            for(int i_L=0; i_L<arr_L.length; i_L++)
            {
                L[i_L] = Long.parseLong(arr_L[i_L]);
            }

            String[] arr_R = br.readLine().split(" ");
            long[] R = new long[Q];
            for(int i_R=0; i_R<arr_R.length; i_R++)
            {
                R[i_R] = Long.parseLong(arr_R[i_R]);
            }

            long[] out_ = solve(A, R, L);
            System.out.print(out_[0]);
            for(int i_out_=1; i_out_<out_.length; i_out_++)
            {
                System.out.print(" " + out_[i_out_]);
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }
    static long[] solve(int[] A, long[] R, long[] L){
        int N = A.length;
        int[] psum = new int[N];
        int MOD = (int)1e9+7;
        long[] res = new long[R.length];
        psum[0] = A[0];

        for (int i=1; i<N; i++) {
            psum[i] = (A[i] + psum[i - 1]) % MOD;
        }

        for (int i=0; i<R.length; i++) {
            int lpos = (int)(L[i]%N), lrep = 0;
            if (L[i] > N) {
                if (lpos != 0) {
                    lpos = lpos - 1;
                    lrep = (int)(L[i]/N);
                }
                else {
                    lpos = N-1;
                    lrep = (int)(L[i]/N - 1);
                }
            } else {
                lpos = (int)(L[i]-1);
            }

            int rpos = (int)(R[i]%N), rrep = 0;
            if (R[i] > N) {
                if (rpos != 0) {
                    rpos = rpos- 1;
                    rrep = (int)(R[i]/N);
                }
                else {
                    rpos = N-1;
                    rrep = (int)(R[i]/N - 1);
                }
            } else {
                rpos = (int)(R[i] -1);
            }

            int times = rrep - lrep - 1;
            System.out.println(lpos + "; " + rpos + " ## " + lrep +"|"+rrep);

            if (lrep != rrep) {
                long sum = 0L;
                long tmp = getSum(psum[N-1], times, MOD);
                System.out.println(tmp);
                sum = tmp;
                sum = (lpos != 0) ? (sum + (psum[N-1] - psum[lpos-1])%MOD)%MOD : (sum + psum[N-1])%MOD;
                sum = (sum + psum[rpos])%MOD;
                res[i] = sum;
            } else {
                long sum = 0L;
                sum = getSum(psum[N-1], times, MOD);
                sum = (lpos > 0) ? (sum + (psum[rpos] - psum[lpos-1])%MOD)%MOD : (sum + psum[rpos])%MOD;
                res[i] = sum;
            }
        }

        return res;
    }

    private static long getSum(int num, int times, int MOD) {
        double lim = (times != 0) ? (Math.log(times)/Math.log(2)) : 0;
//        System.out.println("lim: " + lim);
        long tmp = (lim > 0) ? num : 0;
        for (int t=0; t<(int)lim; t++) {
            tmp = (2L * tmp)%MOD;
        }
        for (int t=0; t<times-Math.pow((int)lim, 2); t++) {
            tmp = (tmp + num)%MOD;
        }
        return tmp;

        /*
        long tmp = 0;
        for (int t=0; t<times; t++) {
            tmp = (tmp + num)%MOD;
        }
        return tmp;
        */
    }
}