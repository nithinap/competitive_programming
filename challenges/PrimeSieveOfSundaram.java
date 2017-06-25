package challenges;

import java.util.Arrays;

public class PrimeSieveOfSundaram {
	private static void sieveofsundaram(int n) {
		int nnew = (n - 2) / 2;
		boolean[] marked = new boolean[nnew+1];
		Arrays.fill(marked, Boolean.FALSE);
		for (int i = 1; i <= nnew; i++) {
			for (int j = i; (i + j + 2 * i * j <= nnew); j++) {
				marked[i + j + 2 * i * j] = true;
			}
		}
		
		if (n > 2)
			System.out.print("2 ");
		for (int i = 1; i <= nnew; i++)
			System.out.print(2 * i + 1 + " ");
	}

	public static void main(String[] args) {
		int n = 50;
		sieveofsundaram(n);
	}
}
