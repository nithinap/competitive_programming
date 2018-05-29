package lc.mar18;

import java.util.Scanner;

public class BigSale {
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		int p, q, d;
		while(t-- > 0) {
			n = sc.nextInt();
			double loss = 0;
			while (n-- > 0) {
				p = sc.nextInt();
				q = sc.nextInt();
				d = sc.nextInt();
				
				loss += (p * Math.pow((double)d/100, 2)) * q;
			}
			System.out.println(loss);
		}
		
		sc.close();
	}
}
