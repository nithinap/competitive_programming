package hackerearth.hiringchallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
*	For finding nth even palindromic number 
*/

public class PalindromicNumber {

	public static void main(String[] args) {
		long n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		/*
		if (n > 9) {
			long m = n - 9, i = 10;
			int dig = 2;
			while (m > 0) {
				m -= 9 * i;
				i *= 10;
				dig += 2;
			}
			
			// find mth (i+1) digit num
			// m-1 * (10 ^(i+1)/2)
			
			long ans = (long) ((m-1) + Math.pow(10, (dig+1)/2));
			System.out.print(ans);
			while (ans > 0) {
				System.out.print(ans%10);
				ans /= 10;
			}
			System.out.println();
			
		} else {
			System.out.println(n+""+n);
		}
		 */
		int[] a = new int[10];
		//Map <Integer, Integer> cmap = new HashMap<Integer, Integer>();
		while (n > 0) {
			int dig = (int) (n % 10);
			a[dig]++;
			n /= 10;
		}
		
		int res = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		
		for (int i=0; i<10; i++) {
			if (a[i] > 0 && a[i] > maxVal) {
				maxVal = a[i];
				res = i;
			}
		}
		
		System.out.println(res);
		
		sc.close();
	}

}
