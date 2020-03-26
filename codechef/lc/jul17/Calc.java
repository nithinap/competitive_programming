package lc.jul17;

import java.util.Scanner;

public class Calc {

	private static long computeMax(long n, long b) {

		long tstart = System.currentTimeMillis();
		long x = 1;
		
		if (n <= b)
			return 0;
/*		x = n - 1;
		long max = Long.MIN_VALUE, cur, i =1;
		long maxima = i;
		for (x = n - b; x > 0; x-= b) {
			cur = x*(i++);
			
			if (max < cur) {
				max = cur;
				maxima = i-1;
			}
		}
		System.out.println(" maxima :"+maxima);*/
//		System.out.println(" sol 1 :"+ max);
/*		long tend = System.currentTimeMillis();
		System.out.println(tend+ "  "+ tstart);
		System.out.println(" time :"+ (tend - tstart));*/
		long max = 0;
		long median = (1+ (n/b))/2;
		max = (n - median*b) * median;		
//		System.out.println(" sol 2 :"+ max);
		return max;
	}

	public static void main(String[] args) {
		int t;
		long n, b;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextLong();
			b = sc.nextLong();

			System.out.println(computeMax(n, b));
		}

		sc.close();
	}
}
