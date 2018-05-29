package JunLC17;

import java.util.Scanner;

public class GoodSet {
	private static void printseq(int n) {
		int a = 4;
		System.out.print(1+" "+2+" ");
		for (int i=0; i<n; i++) {
			System.out.print(a+" ");
			a += 3;
		}
		
	}
	
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		while (t-- > 0){
			n = sc.nextInt();
			if (n == 1)
				System.out.println(1);
			else if (n == 2)
				System.out.println(1+ " "+ 2);
			else 
				printseq(n-2);
		}
		sc.close();
	}
}
