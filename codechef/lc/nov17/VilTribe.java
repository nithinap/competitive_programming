package lc.nov17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VilTribe {

	public static void main(String[] args) throws IOException {
		int t;
		String s;
		int cntA, cntB, tmpcnt;
		boolean sndA, sndB;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			cntB = cntA = tmpcnt = 0;
			sndA = sndB = false;

			s = br.readLine();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'A') {
					cntA++;
					if (sndA) {
						cntA += tmpcnt;
						tmpcnt = 0;
					}
					if (sndB)
						tmpcnt = 0;
					sndA = true;
					sndB = false;
				} else if (s.charAt(i) == 'B') {
					cntB++;
					if (sndB) {
						cntB += tmpcnt;
						tmpcnt = 0;
					}
					if (sndA)
						tmpcnt = 0;
					sndA = false;
					sndB = true;
				} else if (sndA || sndB) {
					tmpcnt++;
				}
				// System.out.println(cntA + " " + cntB + " " + sndA + " "+
				// sndB);
			}

			System.out.println(cntA + " " + cntB);
		}
	}

}
