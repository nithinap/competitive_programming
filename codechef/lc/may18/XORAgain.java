package lc.may18;

import java.util.Scanner;

public class XORAgain {
	public static void main(String[] args) {
		int t,n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-- > 0) {
			n = sc.nextInt();
			int[] a = new int[n];
			for (int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			int res = 2 * a[0];
			for (int i=1; i<n; i++) {
				res = res ^ (2*a[i]);
			}

			System.out.println(res);
		}
		
		sc.close();
	}
}
