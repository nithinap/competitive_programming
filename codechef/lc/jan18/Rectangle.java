package lc.jan18;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		int t, a, b, c, d;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();

			if ((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		sc.close();
	}

}
