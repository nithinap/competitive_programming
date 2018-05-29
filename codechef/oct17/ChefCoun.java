package lc.oct17;

import java.util.Scanner;

public class ChefCoun {

	public static void main(String[] args) {
		int t, n;
		long MAX = 1L << 32;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			long b = MAX / (n + 1);
			long a = b + 1;

			long na = MAX % (n + 1);
			long nb = n + 1 - na;

			for (int i = 0; i < nb; i++)
				System.out.print(b + " ");
			for (int i = 0; i < na - 1; i++)
				System.out.print(a + " ");
			System.out.println();
		}

		sc.close();
	}

}
