package JunLC17;

import java.util.Scanner;

public class FeastNeo {
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();

			}

			int positive_sum = 0, negetive_sum = 0;
			int positive_setsize = 0, negetive_setsize = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] > 0) {
					positive_sum += arr[i];
					positive_setsize++;
				}
			}
			negetive_setsize = n - positive_setsize;
			
		}

		sc.close();
	}
}
