package hackerearth.october.circuits;

import java.util.Scanner;


class TestClass {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long[] a = new long[N];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            a[i] = s.nextInt();
            if(a[i] > max)
            	max = a[i];
        }
        
        int M = s.nextInt();
        long[] b = new long[M];
        for (int i = 0; i < M; i++) {
            b[i] = s.nextInt();
        }

        
        Long mincoins = 0L;
        for(int i=0; i<N; i++) {
            if(a[i] < max)
                mincoins += max - a[i];
        }
        
        System.out.println(mincoins);
        s.close();
    }
  
}
