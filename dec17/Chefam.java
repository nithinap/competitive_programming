package lc.dec17;

import java.util.Scanner;

public class Chefam {
	public static void main(String[] args) {
		int t, n;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			int[] arr = new int[n];
			int[] brr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			if (n > 1)
				System.out.println(n);
			else 
				System.out.println("0");
			
			for (int i = 0; i < n; i++) {
				brr[i] = arr[n - i - 1];
			}

			if (n % 2 != 0) {
				int mid = (int) Math.ceil(n / 2);
				brr[n - 1] = brr[mid];
				brr[mid] = arr[0];
			}

			for (int i = 0; i < n; i++)
				System.out.print(brr[i] + " ");
			System.out.println();
		}

	}
}
