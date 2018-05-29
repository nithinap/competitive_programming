package soroco;

import java.util.BitSet;

public class SeiveOfEratosthenes {

	public static void seive(Long num) {
		System.out.println("Seive");
		int ub = (int)Math.sqrt(num) + 1;
		BitSet isprime = new BitSet(1000000);

		for (int j = 2; j <= ub; j++) {
			if (!isprime.get(j)) {
				// update all multiples of j
				for (int i = 2 * j; i <= ub; i++) {
					isprime.set(i);
					System.out.println("setting "+i);
				}
			}
		}
		
		for (int p = 2; p <= ub; p++) {
			if (!isprime.get(p)) {
				System.out.print(p + ", ");
			}
		}

	}

	public static void main(String[] args) {
		Long num = new Long(25);
		seive(num);
	}

}
