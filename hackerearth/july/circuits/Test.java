/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
*/
package hackerearth.july.circuits;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class TestClass {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int q, x;
		q = sc.nextInt();
		ArrayList<Integer> s = new ArrayList<Integer>();
		while (q-- > 0) {

			int num = sc.nextInt();
			if (num == 1) {
				// insert to set
				x = sc.nextInt();
				s.add(x);
			} else if (num == 2) {
				// delete from set
				x = sc.nextInt();
				if (!s.remove(new Integer(x)))
					System.out.println("-1");
			} else if (num == 3) {
				// max
				System.out.println(s.size());
				if (s.size() > 0)
					System.out.println(Collections.max(s));
				else
					System.out.println("-1");

			} else if (num == 4) {
				// min
				if (s.size() > 0)
					System.out.println(Collections.min(s));
				else
					System.out.println("-1");

			}

		}
		sc.close();
		// System.out.println("Hello World!");
	}
}
