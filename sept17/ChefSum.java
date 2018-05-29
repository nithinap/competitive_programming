package lc.sept17;

import java.util.Scanner;

public class ChefSum {
	public static void main(String[] args) {
		int t, n;
		
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-- >  0) {
			n = sc.nextInt();
			int[] arr = new int[n];

			for (int i=0; i<n; i++) 
				arr[i] = sc.nextInt();
			
			// find least index i such that prefix_sum(i) + suffix_sum(i) is minimum
			int minindex = 0;
			
			// as sum is constant compare the values at the arr indexes
			for (int i=1; i<n; i++) {
				if(arr[i] < arr[minindex])
					minindex = i;
			}
			
			System.out.println(minindex+1);
		}
		
		sc.close();
	}
}
