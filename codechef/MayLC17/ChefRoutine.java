package MayLC17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefRoutine {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		String str;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			str = br.readLine();
			if (!str.equals(""))
				validateRoutine(str);

		}
	}

	private static void validateRoutine(String str) {
		boolean good = false;
		int i = 0;
		if (str.length() > 1) {
			while (i < str.length() - 1) {
				good = false;
				//System.out.println("i : " + i + str.charAt(i));
				char cur = str.charAt(i);

				if (cur == 'C') {
					if (cur == str.charAt(i + 1) || str.charAt(i + 1) == 'E' || str.charAt(i + 1) == 'S') {
						good = true;
						i++;
					}
				} else if (cur == 'E') {
					if (cur == str.charAt(i + 1) || str.charAt(i + 1) == 'S') {
						good = true;
						i++;
					}
				} else if (cur == 'S') {
					if (cur == str.charAt(i + 1)) {
						good = true;
						i++;
					}
				}
				if (!good) {
					System.out.println("no");
					break;
				}
			}
			if (good && i == str.length() - 1) {
				System.out.println("yes");
				return;
			}

		} else {
			System.out.println("yes");
		}
	}
}
