package lc.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nitika {

	public static void format(String source) {

		source.replaceAll("[ ]+", " ");
		String[] split = source.split(" ");

		if (split.length == 1) {
			System.out.println(split[0].substring(0, 1).toUpperCase()
					+ split[0].substring(1).toLowerCase());
		} else {
			int i=0;
			for(; i<split.length-1; i++) {
				//res.append(split[i].substring(0,1).toUpperCase()+". ");
				System.out.print(split[i].substring(0, 1).toUpperCase() + ". ");
			}
			System.out.println(split[i].substring(0, 1).toUpperCase()
					+ split[i].substring(1).toLowerCase());
		}
	}

	public static void main(String[] args) throws IOException {
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			format(str);
		}
	}
}
