package lc.may18;

import java.util.Scanner;

public class MinDeletion {
	private static int compGCD(int x, int y) {
		if (x == 0 || y == 0) 
			return 0;
		if (x == y) 
			return x;
		if (x > y)
			return compGCD(x-y, y);
		
		return compGCD(x, y-x);
	}
	
	public static void main(String[] args) {
		int t, n;
		
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while (t-- > 0) {
			n = sc.nextInt();
			int[] a = new int[n];
			for (int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			int gcd = a[0];
			for (int i=1; i<n; i++) {
				gcd = compGCD(a[i], gcd);
			}
			
			int no_of_deletions = 0;
			if (gcd > 1) {
				no_of_deletions = -1;
				
			}
			// else GCD of entire sequence is 1, no deletions needed
			System.out.println(no_of_deletions);
		}
		
		sc.close();
	}
}
