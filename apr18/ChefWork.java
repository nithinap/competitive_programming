package lc.apr18;

import java.util.Scanner;

public class ChefWork {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int[] c = new int[n];
		int[] t = new int[n];
		
		for (int i=0; i<n; i++) 
			c[i] = sc.nextInt();
		
		for (int i=0; i<n; i++) 
			t[i] = sc.nextInt();
		
		int min_t1 = 100001;
		int min_t2 = 100001;
		int min_t3 = 100001;
		
		for (int i=0; i<n; i++) {
			if (t[i] == 1 && min_t1 > c[i]) 
				min_t1 = c[i];
			else if (t[i] == 2 && min_t2 > c[i])
				min_t2 = c[i];
			else if (t[i] == 3 && min_t3 > c[i]) {
				min_t3 = c[i];
				//System.out.println(min_t3);
			}
		}
//		System.out.println("t2: "+min_t2+"; t1: "+min_t1);
		long v1 = min_t1 + min_t2;
		if (v1 > min_t3)
			System.out.println(min_t3);
		else 
			System.out.println(v1);
		
		sc.close();
	}
}
