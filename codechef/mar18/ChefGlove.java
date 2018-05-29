package lc.mar18;

import java.util.Scanner;

public class ChefGlove {
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			int n;
			n = sc.nextInt();
			int[] h = new int[n];
			int[] g = new int[n];
			
			for (int i=0; i<n; i++) {
				h[i] = sc.nextInt();
			}
			
			for (int i=0; i<n; i++) {
				g[i] = sc.nextInt();
			}
			
			boolean front = true, back = true;
			for (int i=0; i<n; i++) {
				if (h[i] > g[i]) {
					front = false;
					break;
				}
			}
			
			for (int i=0; i<n; i++) {
				if (h[i] > g[n-i-1]) {
					back = false;
					break;
				}
			}
			
			if (front && back) {
				System.out.println("both");
			} else if (front) {
				System.out.println("front");
			} else if (back) {
				System.out.println("back");
			} else {
				System.out.println("none");
			}
			
		}
		
		sc.close();
	}
}
