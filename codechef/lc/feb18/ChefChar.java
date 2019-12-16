package lc.feb18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChefChar {
	public static void main(String[] args) throws IOException {
		int t;
		String s;
		Set<Character> chefset = new HashSet<Character>();
		chefset.addAll(Arrays.asList(new Character[] { 'c', 'h', 'e', 'f' }));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			s = br.readLine();
			int len = s.length();
			if (len < 4) {
				System.out.println("normal");
			} else {
				int count = 0;
				Set<Character> last4 = new HashSet<Character>();
				last4.add(s.charAt(0));
				last4.add(s.charAt(1));
				last4.add(s.charAt(2));

				for (int i = 3; i < len; i++) {
					last4.add(s.charAt(i));
					boolean diff = chefset.removeAll(last4);

					if (diff && chefset.size() == 0) {
						count++;
//						System.out.println(i + " " + count);
//						System.out.println(last4);
					}
					chefset.addAll(Arrays.asList(new Character[] { 'c', 'h', 'e', 'f' }));
					
					last4.remove(s.charAt(i - 3));
					last4.add(s.charAt(i));
					last4.add(s.charAt(i-1));
					last4.add(s.charAt(i-2));

				}
				if (count > 0)
					System.out.println("lovely " + count);
				else
					System.out.println("normal");
			}
		}
	}
}
