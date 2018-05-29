package hackerearth.october.circuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolynomialSign {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		String[] a = br.readLine().split(" ");

		int maxind = Integer.MIN_VALUE;
		// find largest non-zero index
		for (int i = n; i >=0;) {
			if (a[i].equals("0"))
				i--;
			else {
				maxind = i;
				break;
			}
		}

		if (maxind == Integer.MIN_VALUE) {
			// f(x) evaluates to zero, all  a[i]'s are 0
			System.out.println("0 0");
		} else if(maxind == 0) {
			if(a[maxind].contains("-"))
				System.out.println("-1 -1");
			else
				System.out.println("1 1");
		}
		else {
			// for +ve superbig 
			if (a[maxind].contains("-")) {
				System.out.print("-1 ");
			} else {
				System.out.print("1 ");
			}
			
			// for -ve superbig
			if(a[maxind].contains("-")) {
				if(maxind % 2 == 0) {
					System.out.println("-1");
				} else {
					System.out.println("1");
				}
			} else {
				if(maxind % 2 == 0) {
					System.out.println("1");
				} else {
					System.out.println("-1");
				}
			}
		}

	}
}
