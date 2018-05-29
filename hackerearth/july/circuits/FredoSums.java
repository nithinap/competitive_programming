package hackerearth.july.circuits;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class FredoSums {
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while(t-- > 0) {
			n = sc.nextInt();
			int[] a = new int[n];
 			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
 			
 			Arrays.sort(a);
/* 			for(int i=0; i<n; i++)
 				System.out.print(a[i]+" ");
 			*/
 			
 			long max = 0;
/* 			for(int i=0; i<n/2; i++) {
 				long val = (a[n-i-1] - a[i]);
 				max +=  Math.abs(val) ;
 			}*/
 			
 			
			for(int i=0, j=n-1; i<n/2 && j>=n/2; i++, j--) {
 				long val = a[j] - a[i];
 				max += (val > 0)? val : val*-1;
 			}
 			
 			long min = 0;
 			for(int i=0; i<n-1; i+=2) {
 				long val = (a[i+1] - a[i]);
 				max += (val > 0)? val : val*-1;
 			}
 			
 			System.out.println(min + " "+ max);
 			
// 			ArrayList<Integer> a = new ArrayList<Integer>();
// 			a.remov
		}
		sc.close();
	}
}
