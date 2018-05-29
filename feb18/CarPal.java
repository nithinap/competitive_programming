package lc.feb18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarPal {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t, n;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			
			long[] a = new long[n];
			double sum = 0.000000000;			
			String ai = br.readLine();
			int i = 0;
			for (String num : ai.split(" ")) {
				a[i++] = Integer.parseInt(num);
//				sum += a[i++];
			}

			String[] cds = br.readLine().split(" ");
			int c = Integer.parseInt(cds[0]), d = Integer.parseInt(cds[1]), s = Integer.parseInt(cds[2]);

			/*double time =  ((double)d / s);
			double tfirst = sum + (n - 1) * time;
			double tlast = ((double) c - 1) * a[0] + tfirst;*/
/*
			double[] tdiff = new double[n];
			for (i = 0; i < n - 1; i++) {
				tdiff[i] = a[i + 1] - a[i];
			}

			for (i = 0; i < n - 1; i++) {
				if (tdiff[i] > 0) {
					tlast += (double) ((c - 1) * tdiff[i]);
				} 
			}
*/
			long prev = 0;
			for (i=0; i<n; i++) {
				if (a[i] > prev) {
					sum += (c-1) * (a[i] - prev);
					prev = a[i];
				}
			}
			
			System.out.printf("%.9f", sum);
			System.out.println();
		}

	}
}
