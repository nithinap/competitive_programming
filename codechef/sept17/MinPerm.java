package lc.sept17;

import java.util.Scanner;

public class MinPerm {

	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			int[] a = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				a[i] = i;
			}

			int lim = (n % 2 == 0) ? n : (n - 1);
			int temp;
			for (int i = 1; i <= lim; i += 2) {
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
			
			if(lim < n) {
				temp = a[n];
				a[n] = a[n-1];
				a[n-1] = temp;
			}
			
			for(int i=1; i<=n; i++) {
				System.out.print(a[i]+" ");
			}
		
			System.out.println();
			
		}
		sc.close();
	}

}
