package hackerearth.hiringchallenge;

import java.util.Arrays;
import java.util.Scanner;

public class Beauty {

	public static final int MOD = 1000000007;

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int[] a = new int[1001];
		int[] freq = new int[1001];
		 int[] arr = new int[n];

		int ind = 0;
		for (int i = 0; i < n; i++) {
			// a[i] = sc.nextInt();
			// a[i] = 1000; // 880271808
			int num = sc.nextInt();
			 arr[i] = num;
			if (freq[num] == 0)
				a[ind++] = num;
			freq[num]++;

		}

		Arrays.sort(a, 0, ind);
		// System.out.println(Arrays.toString(a));

		// calculate powers of 2 and store in lookup from 2^0 to 2^(n-2)
		long[] lookup = new long[n + 1];
		lookup[0] = 1;
		lookup[1] = 2;
		long start = System.currentTimeMillis();
		for (int i = 2; i < n + 1; i++) {
			if (i < 30)
				lookup[i] = 2 << (i - 1);

			// post this powers greater than MOD
			long res = (lookup[i - 1] << 1) % MOD;
			lookup[i] = res;
		}
		

		// System.out.println(Arrays.toString(lookup));
		// System.out.println(lookup[n - 2]);

		// System.out.println(ind);
		long res = 0;

		//if (ind > 1) {
			for (int i = 0; i < ind; i++) {
				int cum_freq = 0;
				if (freq[a[i]] > 1)
					res = (res + (a[i] * (lookup[freq[a[i]]] - freq[a[i]] - 1)) % MOD) % MOD;
				for (int j = i + 1; j < ind; j++) {
					cum_freq += freq[a[j]];
					res = (res + ((a[i] | a[j])
							* (lookup[cum_freq + freq[a[i]] - 2] + ((long)freq[a[i]] * freq[a[j]] - 1) % MOD) % MOD)) % MOD;
					res = res + (a[i] |a[j]) * lookup[freq]
				}
			}
		/*} else { // ind = 1
			res = (a[0] * (lookup[freq[a[0]]] - freq[a[0]] - 1)) % MOD;
		}*/

		long end = System.currentTimeMillis();
		System.out.println("res: " + res);
		System.out.println("time: " + (end - start));

		// (For testing)
		start = System.currentTimeMillis();
		// int[] arr = new int[200000];
		// Arrays.fill(arr, 1000);
		
		res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				 res = (res + ((arr[i] | arr[j]) * (lookup[j - i - 1])) % MOD) % MOD;
				
			}
		}
		// res = (res + (arr[0]*(200000-2))%MOD)%MOD;
		end = System.currentTimeMillis();
		System.out.println(res);
		System.out.println("time(brute): " + (end - start));
		
		
		sc.close();
	}
}
