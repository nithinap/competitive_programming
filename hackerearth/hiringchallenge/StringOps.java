package hackerearth.hiringchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringOps {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int q, m;
		String s;

		s = br.readLine();
		q = Integer.parseInt(br.readLine());

		String qline;
		char[] arr = s.toCharArray();

		while (q-- > 0) {
			qline = br.readLine();
			String[] qsplit = qline.split(" ");
			arr[Integer.parseInt(qsplit[0]) - 1] = qsplit[1].charAt(0);
		}
		System.out.println(arr);

		char[] arr2 = Arrays.copyOf(arr, arr.length);
		// System.out.println(new String(arr2));
		m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			String mline = br.readLine();
			String[] msplit = mline.split(" ");
			int left = Integer.parseInt(msplit[0]) - 1;
			int right = Integer.parseInt(msplit[1]) - 1;
			int len = right - left;
			// System.out.println(left + " ==== "+ right);

			for (int i = 0; i <= len / 2; i++) {
				// System.out.println("swap "+(left+i)+" "+(right-i));
				char temp = arr2[left + i];
				arr2[left + i] = arr2[right - i];
				arr2[right - i] = temp;
				// System.out.println(arr2);
			}
		}

		System.out.println(arr2);
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr2[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
