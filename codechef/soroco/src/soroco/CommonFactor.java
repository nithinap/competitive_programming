package soroco;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Scanner;

public class CommonFactor {
	
	private static Long gcd(Long a, Long b) {
		Long t = new Long(0);
		while(b != 0) {
			t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	private static void SeiveOfEratosthenes(Long num) {
		//int[] prime = new int[num+1];
		for(Long p = new Long(2); p<=Math.sqrt(num); p++) {
			
		}
	}
	
	public static void main(String[] args) {
		Long a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		sc.close();

		Long count = new Long(0);
		Long i = gcd(a,b); //Math.max(a, b);
		
		while (i > 0) {
			if (a % i == 0 && b % i == 0) {
				count++;
			}
			i--;
		}
		System.out.println(count);
	}
}
